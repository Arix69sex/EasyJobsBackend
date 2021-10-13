package com.easyjobs.controller;

import com.easyjobs.domain.model.Cuenta;
import com.easyjobs.domain.service.CuentaService;
import com.easyjobs.resource.CuentaResource;
import com.easyjobs.resource.SaveCuentaResource;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
// @RequestMapping("/api")
public class CuentaController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CuentaService cuentaService;

    @Operation(summary = "Get All Cuentas", description = "Get All Cuentas", tags = {"cuentas"})
    @GetMapping("/cuentas")
    public Page<CuentaResource> getAllCuentas(Pageable pageable){
        Page<Cuenta> cuentaPage = cuentaService.getAllCuentas(pageable);
        List<CuentaResource> resources = cuentaPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Get All Cuentas by Tipo", description = "Get All Cuentas by Tipo", tags = {"cuentas"})
    @GetMapping("/cuentas/type/{tipo}")
    public Page<CuentaResource> getAllCuentasByTipo(@PathVariable String tipo, Pageable pageable){
        Page<Cuenta> cuentaPage = cuentaService.getAllCuentasByTipo(pageable, tipo);
        List<CuentaResource> resources = cuentaPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Get Cuenta by Id", description = "Get Cuenta by Id", tags = {"cuentas"})
    @GetMapping("/cuentas/{cuentaId}")
    public CuentaResource GetCuentasById(@PathVariable Long cuentaId){
        return convertToResource(cuentaService.getCuentaById(cuentaId));
    }

    @Operation(summary = "Get Cuenta by Email", description = "Get Cuenta by Email", tags = {"cuentas"})
    @GetMapping("/cuentas/email/{cuentaEmail}")
    public CuentaResource GetCuentasByEmail(@PathVariable String cuentaEmail){
        return convertToResource(cuentaService.getCuentaByEmail(cuentaEmail));
    }

    @Operation(summary = "Get Cuenta by Username", description = "Get Cuenta by Username", tags = {"cuentas"})
    @GetMapping("/cuentas/username/{cuentaUsername}")
    public CuentaResource GetCuentasByUsername(@PathVariable String cuentaUsername){
        return convertToResource(cuentaService.getCuentaByUsername(cuentaUsername));
    }

    @Operation(summary = "Create Cuenta", description = "Create a new Cuenta", tags = {"cuentas"})
    @PostMapping("/cuentas")
    public CuentaResource createCuenta(@Valid @RequestBody SaveCuentaResource resource){
        Cuenta cuenta = convertToEntity(resource);
        return convertToResource(cuentaService.createCuenta(cuenta));
    }

    @Operation(summary = "Update Cuenta", description = "Update an existing Cuenta with given Id", tags = {"cuentas"})
    @PutMapping("/cuentas/{cuentaId}")
    public CuentaResource updateCuenta(@PathVariable Long cuentaId, @RequestBody SaveCuentaResource resource) {
        Cuenta cuenta = convertToEntity(resource);
        return convertToResource(cuentaService.updateCuenta(cuentaId,cuenta));
    }

    @Operation(summary = "Delete Cuenta", description = "Delete an existing Cuenta using its id", tags = {"cuentas"})
    @DeleteMapping("/cuentas/{cuentaId}")
    public ResponseEntity<?> deleteCuenta(@PathVariable Long cuentaId){
        return cuentaService.deleteCuenta(cuentaId);
    }


    private Cuenta convertToEntity(SaveCuentaResource resource) {
        return mapper.map(resource, Cuenta.class);
    }

    private CuentaResource convertToResource(Cuenta entity){
        return mapper.map(entity, CuentaResource.class);
    }

}
