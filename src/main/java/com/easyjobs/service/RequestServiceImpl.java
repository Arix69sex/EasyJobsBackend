package com.easyjobs.service;

import com.easyjobs.domain.model.Request;
import com.easyjobs.domain.repository.RequestRepository;
import com.easyjobs.domain.repository.ServiceRepository;
import com.easyjobs.domain.repository.UserRepository;
import com.easyjobs.domain.service.RequestService;
import com.easyjobs.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;

public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<Request> getAllRequest(Pageable pageable) {
        return requestRepository.findAll(pageable);
    }

    @Override
    public Request getRequestById(Long requestId) {
        return requestRepository.findById(requestId)
                .orElseThrow(() -> new ResourceNotFoundException("Request", "Id", requestId));
    }

    @Override
    public Page<Request> getRequestsByUserId(Long userId, Pageable pageable) {
        return requestRepository.findAllByUserId(userId, pageable);
    }

    @Override
    public Page<Request> getRequestsByServiceId(Long serviceId, Pageable pageable) {
        return requestRepository.findAllByServiceId(serviceId, pageable);
    }

    @Override
    public Page<Request> getRequestsByUserIdAndServiceId(Long userId, Long serviceId, Pageable pageable) {
        return requestRepository.findAllByUserIdAndServiceId(userId, serviceId, pageable);
    }

    @Override
    public Request createRequest(Long userId, Long serviceId, Request request) {
        return userRepository.findById(userId).map(user -> {
            request.setUser(user);
            return serviceRepository.findById(serviceId).map(service -> {
                request.setService(service);
                return requestRepository.save(request);
            }).orElseThrow(() -> new ResourceNotFoundException(
                    "Service", "Id", serviceId));
        }).orElseThrow(() -> new ResourceNotFoundException(
                "User", "Id", userId));
    }

    @Override
    public Request updateRequest(Long requestId, Long serviceId, Long userId, Request request) {
        if (!userRepository.existsById(userId))
            throw new ResourceNotFoundException("User", "Id", userId);
        if (!serviceRepository.existsById(serviceId))
            throw new ResourceNotFoundException("Service", "Id", serviceId);
        return requestRepository.findById(requestId).map(requestMap -> {
            requestMap.setStatus(request.getStatus());
            return requestRepository.save(requestMap);
        }).orElseThrow(() -> new ResourceNotFoundException("Request", "Id", requestId));
    }

    @Override
    public ResponseEntity<?> deleteRequest(Long requestId, Long serviceId, Long userId) {
        if (!userRepository.existsById(userId))
            throw new ResourceNotFoundException("User", "Id", userId);
        if (!serviceRepository.existsById(serviceId))
            throw new ResourceNotFoundException("Service", "Id", serviceId);
        return requestRepository.findById(requestId).map(request -> {
            requestRepository.delete(request);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Request", "Id", requestId));
    }
}
