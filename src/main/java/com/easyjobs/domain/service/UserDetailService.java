package com.easyjobs.domain.service;

import com.easyjobs.domain.model.UserDetail;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface UserDetailService {

    Page<UserDetail> getAllDetails(Pageable pageable);

    UserDetail getDetailById(Long detailId);

    Page<UserDetail> getDetailsByUserId(Long userId, Pageable pageable);

    UserDetail createDetail (Long userId, UserDetail userDetail);

    UserDetail updateDetail (Long userId, Long detailId, UserDetail userDetail);

    ResponseEntity<?> deleteDetail(Long detailId, Long userId);
}
