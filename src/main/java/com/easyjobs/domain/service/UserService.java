package com.easyjobs.domain.service;

import com.easyjobs.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    Page<User> getAllUsers(Pageable pageable);

    User getUserById(Long userId);

    User getUserByEmail(String email);

    User createUser (User user);

    User updateUser (Long userId, User userRequest);

    ResponseEntity<?> deleteUser(Long userId);
}
