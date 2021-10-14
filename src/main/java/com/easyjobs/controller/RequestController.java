package com.easyjobs.controller;

import com.easyjobs.domain.model.Request;
import com.easyjobs.domain.service.RequestService;
import com.easyjobs.resource.RequestResource;
import com.easyjobs.resource.SaveRequestResource;
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
public class RequestController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RequestService requestService;

    @Operation(summary = "Get all Requests", description = "Get all Requests", tags = {"requests"})
    @GetMapping("/requests")
    public Page<RequestResource> getAllRequests(Pageable pageable){
        Page<Request> requestPage = requestService.getAllRequest(pageable);
        List<RequestResource> resources = requestPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Get Request by RequestId", description = "Get Request by its id", tags = {"requests"})
    @GetMapping("/requests/{requestId}")
    public RequestResource getRequestById(@PathVariable Long requestId, Pageable pageable){
        return convertToResource(requestService.getRequestById(requestId));
    }

    @Operation(summary = "Get All Requests by UserId", description = "Get Request by UserId", tags = {"requests"})
    @GetMapping("/users/{userId}/requests")
    public Page<RequestResource> getRequestsyUserId(@PathVariable Long userId, Pageable pageable){
        Page<Request> requestPage = requestService.getRequestsByUserId(userId, pageable);
        List<RequestResource> resources = requestPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Get All Requests by ServiceId", description = "Get Request by ServiceId", tags = {"requests"})
    @GetMapping("/services/{serviceId}/requests")
    public Page<RequestResource> getRequestsByServiceId(@PathVariable Long serviceId, Pageable pageable){
        Page<Request> requestPage = requestService.getRequestsByServiceId(serviceId, pageable);
        List<RequestResource> resources = requestPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Get All Requests by UserId and ServiceId", description = "Get Request by UserId and ServiceId", tags = {"requests"})
    @GetMapping("/users/{userId}/services/{serviceId}/requests")
    public Page<RequestResource> getRequestsByUserIdAndServiceId(@PathVariable Long userId, @PathVariable Long serviceId, Pageable pageable){
        Page<Request> requestPage = requestService.getRequestsByUserIdAndServiceId(userId, serviceId, pageable);
        List<RequestResource> resources = requestPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }


    @Operation(summary = "Create Request", description = "Create a new Request", tags = {"requests"})
    @PostMapping("/users/{userId}/services/{serviceId}/requests")
    public RequestResource createRequest(@PathVariable Long userId, @PathVariable Long serviceId, @Valid @RequestBody SaveRequestResource resource){
        Request request = convertToEntity(resource);
        return convertToResource(requestService.createRequest(userId, serviceId, request));
    }

    @Operation(summary = "Update a Request", description = "Update an existing Request", tags = {"requests"})
    @PutMapping("/users/{userId}/services/{serviceId}/requests")
    public RequestResource updateRequest(@PathVariable Long userId, @PathVariable Long serviceId, @Valid @RequestBody SaveRequestResource resource) {
        Request request = convertToEntity(resource);
        return convertToResource(requestService.updateRequest(request.getId(), serviceId, userId, request));
    }

    @Operation(summary = "Delete a Request", description = "Delete an existing Request", tags = {"requests"})
    @DeleteMapping("/users/{userId}/services/{serviceId}/requests/requestId")
    public ResponseEntity<?> deleteRequest(@PathVariable Long userId, @PathVariable Long serviceId, @PathVariable Long requestId) {
        return requestService.deleteRequest(requestId, serviceId, userId);
    }

    private Request convertToEntity(SaveRequestResource resource) {
        return modelMapper.map(resource, Request.class);
    }

    private RequestResource convertToResource(Request entity){ return modelMapper.map(entity, RequestResource.class); }
}
