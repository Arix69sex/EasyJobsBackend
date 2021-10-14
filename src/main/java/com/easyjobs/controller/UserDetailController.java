package com.easyjobs.controller;

import com.easyjobs.domain.model.UserDetail;
import com.easyjobs.domain.service.UserDetailService;
import com.easyjobs.resource.SaveUserDetailResource;
import com.easyjobs.resource.UserDetailResource;
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
public class UserDetailController {


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserDetailService userDetailService;

    @Operation(summary = "Get all Details", description = "Get all UserDetails", tags = {"details"})
    @GetMapping("/details")
    public Page<UserDetailResource> getallDetails(Pageable pageable){
        Page<UserDetail> detailPage = userDetailService.getAllDetails(pageable);
        List<UserDetailResource> resources = detailPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Get Detail by DetailId", description = "Get Detail by its id", tags = {"details"})
    @GetMapping("/details/{detailId}")
    public UserDetailResource getDetailsById(@PathVariable Long detailId){
        return convertToResource(userDetailService.getDetailById(detailId));
    }

    @Operation(summary = "Get All Details by UserId", description = "Get All Details by UserId", tags = {"details"})
    @GetMapping("/users/{userId}/details")
    public Page<UserDetailResource> getDetailsByUserId(@PathVariable Long userId, Pageable pageable){
        Page<UserDetail> detailPage = userDetailService.getDetailsByUserId(userId, pageable);
        List<UserDetailResource> resources = detailPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }


    @Operation(summary = "Create Detail", description = "Create a new User Detail", tags = {"details"})
    @PostMapping("/users/{userId}/details")
    public UserDetailResource createDetail(@PathVariable Long userId, @Valid @RequestBody SaveUserDetailResource resource){
        UserDetail userDetail = convertToEntity(resource);
        return convertToResource(userDetailService.createDetail(userId, userDetail));
    }

    @Operation(summary = "Update a Detail", description = "Update an existing Detail with given UserId", tags = {"details"})
    @PutMapping("/users/{userId}/details")
    public UserDetailResource updateDetail(@PathVariable Long userId, @Valid @RequestBody SaveUserDetailResource resource) {
        UserDetail userDetail = convertToEntity(resource);
        return convertToResource(userDetailService.updateDetail(userId, userDetail.getId(), userDetail));
    }

    @Operation(summary = "Delete a Detail", description = "Delete an existing Detail with given Id", tags = {"details"})
    @DeleteMapping("/users/{userId}/details/{detailId}")
    public ResponseEntity<?> deleteDetail(@PathVariable Long userId, @PathVariable Long detailId) {
        return userDetailService.deleteDetail(detailId, userId);
    }

    private UserDetail convertToEntity(SaveUserDetailResource resource) {
        return modelMapper.map(resource, UserDetail.class);
    }

    private UserDetailResource convertToResource(UserDetail entity){
        return modelMapper.map(entity, UserDetailResource.class);
    }
}
