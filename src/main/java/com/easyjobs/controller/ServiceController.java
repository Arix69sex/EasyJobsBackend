package com.easyjobs.controller;

import com.easyjobs.domain.model.Service;
import com.easyjobs.domain.service.ServiceService;
import com.easyjobs.resource.SaveServiceResource;
import com.easyjobs.resource.ServiceResource;
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
public class ServiceController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ServiceService serviceService;

    @Operation(summary = "Get all Services", description = "Get all Services", tags = {"services"})
    @GetMapping("/services")
    public Page<ServiceResource> getAllServices(Pageable pageable){
        Page<Service> servicePage = serviceService.getAllServices(pageable);
        List<ServiceResource> resources = servicePage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Get Service by ServiceId", description = "Get Service by its id", tags = {"services"})
    @GetMapping("/services/{serviceId}")
    public ServiceResource getServiceById(@PathVariable Long serviceId, Pageable pageable){
        return convertToResource(serviceService.getServiceById(serviceId));
    }

    @Operation(summary = "Get All Services by UserId", description = "Get Services by UserId", tags = {"services"})
    @GetMapping("/users/{userId}/services")
    public Page<ServiceResource> getSevicesByUserId(@PathVariable Long userId, Pageable pageable){
        Page<Service> servicePage = serviceService.getServicesByUserId(userId, pageable);
        List<ServiceResource> resources = servicePage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }


    @Operation(summary = "Create Service", description = "Create a new Service", tags = {"services"})
    @PostMapping("/users/{userId}/services")
    public ServiceResource createService(@PathVariable Long userId, @Valid @RequestBody SaveServiceResource resource){
        Service service = convertToEntity(resource);
        return convertToResource(serviceService.createService(userId, service));
    }

    @Operation(summary = "Update a Service", description = "Update an existing Service with given UserId", tags = {"services"})
    @PutMapping("/users/{userId}/services")
    public ServiceResource updateService(@PathVariable Long userId, @Valid @RequestBody SaveServiceResource resource) {
        Service service = convertToEntity(resource);
        return convertToResource(serviceService.updateService(service.getId(), userId, service));
    }

    @Operation(summary = "Delete a Service", description = "Delete an existing Service with given Id", tags = {"services"})
    @DeleteMapping("/users/{userId}/services/{serviceId}")
    public ResponseEntity<?> deleteService(@PathVariable Long userId, @PathVariable Long serviceId) {
        return serviceService.deleteService(serviceId, userId);
    }

    private Service convertToEntity(SaveServiceResource resource) {
        return modelMapper.map(resource, Service.class);
    }

    private ServiceResource convertToResource(Service entity){
        return modelMapper.map(entity, ServiceResource.class);
    }
}
