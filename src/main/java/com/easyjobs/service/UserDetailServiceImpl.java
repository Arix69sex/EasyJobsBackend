package com.easyjobs.service;

import com.easyjobs.domain.model.UserDetail;
import com.easyjobs.domain.repository.UserDetailRepository;
import com.easyjobs.domain.repository.UserRepository;
import com.easyjobs.domain.service.UserDetailService;
import com.easyjobs.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;

public class UserDetailServiceImpl implements UserDetailService {

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<UserDetail> getAllDetails(Pageable pageable) {
        return userDetailRepository.findAll(pageable);
    }

    @Override
    public UserDetail getDetailById(Long detailId) {
        return userDetailRepository.findById(detailId)
                .orElseThrow(() -> new ResourceNotFoundException("UserDetail", "Id", detailId));
    }

    @Override
    public Page<UserDetail> getDetailsByUserId(Long userId, Pageable pageable) {
        return userDetailRepository.findAllByUserId(userId, pageable);
    }

    @Override
    public UserDetail createDetail(Long userId, UserDetail userDetail) {
        return userRepository.findById(userId).map(user -> {
            userDetail.setUser(user);
            return userDetailRepository.save(userDetail);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "user", "Id", userId));
    }

    @Override
    public UserDetail updateDetail(Long userId, Long detailId, UserDetail userDetail) {
        if (!userRepository.existsById(userId))
            throw new ResourceNotFoundException("User", "Id", userId);
        return userDetailRepository.findById(detailId).map(detail -> {
            detail.setFirstName(userDetail.getFirstName());
            detail.setLastName(userDetail.getLastName());
            detail.setAddress(userDetail.getAddress());
            detail.setDni(userDetail.getDni());
            detail.setRating(userDetail.getRating());
            detail.setStatus(userDetail.getStatus());
            return userDetailRepository.save(detail);
        }).orElseThrow(() -> new ResourceNotFoundException("Detail", "Id", detailId));
    }

    @Override
    public ResponseEntity<?> deleteDetail(Long detailId, Long userId) {
        if (!userRepository.existsById(userId))
            throw new ResourceNotFoundException("User", "Id", userId);
        return userDetailRepository.findById(detailId).map(detail -> {
            userDetailRepository.delete(detail);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Detail", "Id", detailId));
    }
}
