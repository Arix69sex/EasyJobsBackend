package com.easyjobs.controller;

import com.easyjobs.domain.model.User;
import com.easyjobs.domain.service.UserService;
import com.easyjobs.resource.SaveUserResource;
import com.easyjobs.resource.UserResource;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserService userService;

    @Operation(summary = "Get All Users", description = "Get All Cuentas", tags = {"users"})
    @GetMapping("/users")
    public Page<UserResource> getAllUsers(Pageable pageable){
        Page<User> userPage = userService.getAllUsers(pageable);
        List<UserResource> resources = userPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Get User by Id", description = "Get User by Id", tags = {"users"})
    @GetMapping("/users/{userId}")
    public UserResource getUserById(@PathVariable Long userId){
        return convertToResource(userService.getUserById(userId));
    }

    @Operation(summary = "Get User by Email", description = "Get User by Email", tags = {"users"})
    @GetMapping("/users/email/{userEmail}")
    public UserResource getUserByEmail(@PathVariable String userEmail){
        return convertToResource(userService.getUserByEmail(userEmail));
    }

    @Operation(summary = "Create User", description = "Create a new User", tags = {"users"})
    @PostMapping("/users")
    public UserResource createUser(@Valid @RequestBody SaveUserResource resource){
        User user = convertToEntity(resource);
        return convertToResource(userService.createUser(user));
    }

    @Operation(summary = "Update User", description = "Update an existing User with given Id", tags = {"users"})
    @PutMapping("/users/{userId}")
    public UserResource updateCuenta(@PathVariable Long userId, @RequestBody SaveUserResource resource) {
        User user = convertToEntity(resource);
        return convertToResource(userService.updateUser(userId,user));
    }

    @Operation(summary = "Delete User", description = "Delete an existing User using its id", tags = {"users"})
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId){
        return userService.deleteUser(userId);
    }


    private User convertToEntity(SaveUserResource resource) {
        return modelMapper.map(resource, User.class);
    }

    private UserResource convertToResource(User entity){
        return modelMapper.map(entity, UserResource.class);
    }
}
