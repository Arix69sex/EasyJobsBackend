package com.easyjobs.domain.repository;

import com.easyjobs.domain.model.UserDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;

public interface UserDetailRepository extends JpaRepository<UserDetail,Long> {
    Page<UserDetail> findAllByUserId(Long userId, Pageable pageable);
}
