package com.easyjobs.domain.repository;

import com.easyjobs.domain.model.Request;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request,Long> {
    Page<Request> findAllByUserId(Long userId, Pageable pageable);

    Page<Request> findAllByServiceId(Long serviceId, Pageable pageable);

    Page<Request> findAllByUserIdAndServiceId(Long userId, Long serviceId, Pageable pageable);
}
