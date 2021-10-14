package com.easyjobs.domain.service;

import com.easyjobs.domain.model.Service;
import com.easyjobs.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;

@org.springframework.stereotype.Service
public interface ServiceService {

    Page<Service> getAllServices(Pageable pageable);

    Service getServiceById(Long serviceId);

    Page<Service> getServicesByUserId(Long userId, Pageable pageable);

    Service createService (Long userId, Service service);

    Service updateService (Long serviceId, Long userId, Service serviceRequest);

    ResponseEntity<?> deleteService(Long serviceId, Long userId);
}
