package com.easyjobs.domain.service;

import com.easyjobs.domain.model.Request;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface RequestService {

    Page<Request> getAllRequest(Pageable pageable);

    Request getRequestById(Long serviceId);

    Page<Request> getRequestsByUserId(Long userId, Pageable pageable);

    Page<Request> getRequestsByServiceId(Long serviceId, Pageable pageable);

    Page<Request> getRequestsByUserIdAndServiceId(Long userId, Long serviceId, Pageable pageable);

    Request createRequest (Long userId, Long serviceId, Request request);

    Request updateRequest (Long requestId, Long serviceId, Long userId, Request request);

    ResponseEntity<?> deleteRequest(Long requestId, Long serviceId, Long userId);
}
