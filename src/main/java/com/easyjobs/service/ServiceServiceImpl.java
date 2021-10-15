package com.easyjobs.service;

import com.easyjobs.domain.model.Service;
import com.easyjobs.domain.repository.ServiceRepository;
import com.easyjobs.domain.repository.UserRepository;
import com.easyjobs.domain.service.ServiceService;
import com.easyjobs.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public Page<Service> getAllServices(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public Service getServiceById(Long serviceId) {
        return serviceRepository.findById(serviceId)
                .orElseThrow(() -> new ResourceNotFoundException("Service", "Id", serviceId));
    }

    @Override
    public Page<Service> getServicesByUserId(Long userId, Pageable pageable) {
        return serviceRepository.findAllByUserId(userId, pageable);
    }

    @Override
    public Service createService(Long userId, Service service) {
        return userRepository.findById(userId).map(user -> {
            service.setUser(user);
            return serviceRepository.save(service);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "User", "Id", userId));
    }

    @Override
    public Service updateService(Long serviceId, Long userId, Service serviceRequest) {
        if (!userRepository.existsById(userId))
            throw new ResourceNotFoundException("User", "Id", userId);
        return serviceRepository.findById(serviceId).map(service -> {
            service.setName(serviceRequest.getName());
            service.setDescription(serviceRequest.getDescription());
            service.setPrice(serviceRequest.getPrice());
            return serviceRepository.save(service);
        }).orElseThrow(() -> new ResourceNotFoundException("Service", "Id", serviceId));
    }

    @Override
    public ResponseEntity<?> deleteService(Long serviceId, Long userId) {
        if (!userRepository.existsById(userId))
            throw new ResourceNotFoundException("User", "Id", userId);
        return serviceRepository.findById(serviceId).map(service -> {
            serviceRepository.delete(service);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Service", "Id", serviceId));
    }
}
