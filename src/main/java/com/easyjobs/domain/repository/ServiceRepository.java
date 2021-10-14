package com.easyjobs.domain.repository;

import com.easyjobs.domain.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ServiceRepository extends JpaRepository<Service,Long> {
    Page<Service> findAllByUserId(Long userId, Pageable pageable);
}
