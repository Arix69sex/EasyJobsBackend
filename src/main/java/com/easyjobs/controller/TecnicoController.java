package com.easyjobs.controller;

import com.easyjobs.domain.model.Tecnico;
import com.easyjobs.domain.service.TecnicoService;
import com.easyjobs.resource.SaveTecnicoResource;
import com.easyjobs.resource.TecnicoResource;
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
// @RequestMapping("/api")
public class TecnicoController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private TecnicoService tecnicoService;

    @Operation(summary = "Get all Tecnicos", description = "Get all Tecnicos", tags = {"tecnicos"})
    @GetMapping("/cuentas/tecnicos")
    public Page<TecnicoResource> getAllTecnicos(Pageable pageable){
        Page<Tecnico> tecnicoPage = tecnicoService.getAllTecnicos(pageable);
        List<TecnicoResource> resources = tecnicoPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Get Tecnico by CuentaId", description = "Get Tecnico by CuentaId", tags = {"tecnicos"})
    @GetMapping("/cuentas/{cuentaId}/tecnicos")
    public TecnicoResource getTecnicoByCuentaId(@PathVariable Long cuentaId, Pageable pageable){
        return convertToResource(tecnicoService.getTecnicoByCuentaId(cuentaId));
    }

    @Operation(summary = "Get Tecnico by its Id", description = "Get Tecnico by its Id", tags = {"tecnicos"})
    @GetMapping("/tecnicos/{tecnicoId}")
    public TecnicoResource getTecnicoById(@PathVariable Long tecnicoId){
        return convertToResource(tecnicoService.getTecnicoById(tecnicoId));
    }

    @Operation(summary = "Get Tecnico by its Dni", description = "Get Tecnico by its Dni", tags = {"tecnicos"})
    @GetMapping("/tecnicos/dni/{tecnicoDni}")
    public TecnicoResource getTecnicoByDni(@PathVariable Long tecnicoDni){
        return convertToResource(tecnicoService.getTecnicoByDni(tecnicoDni));
    }

    @Operation(summary = "Create Tecnico", description = "Create a new Tecnico", tags = {"tecnicos"})
    @PostMapping("/cuentas/{cuentaId}/tecnicos")
    public TecnicoResource createTecnico(@PathVariable Long cuentaId, @Valid @RequestBody SaveTecnicoResource resource){
        Tecnico tecnico = convertToEntity(resource);
        return convertToResource(tecnicoService.createTecnico(cuentaId,tecnico));
    }

    @Operation(summary = "Update a Tecnico", description = "Update an existing Tecnico with given CuentaId", tags = {"tecnicos"})
    @PutMapping("/cuentas/{cuentaId}/tecnicos")
    public TecnicoResource updateTecnico(@PathVariable Long cuentaId, @Valid @RequestBody SaveTecnicoResource resource) {
        Tecnico tecnico = convertToEntity(resource);
        return convertToResource(tecnicoService.updateTecnico(cuentaId, tecnico.getId(), tecnico));
    }

    @Operation(summary = "Delete a Tecnico", description = "Delete an existing Tecnico with given Id", tags = {"tecnicos"})
    @DeleteMapping("/cuentas/{cuentaId}/tecnicos/{tecnicoId}")
    public ResponseEntity<?> deleteTecnico(@PathVariable Long cuentaId, @PathVariable Long tecnicoId) {
        return tecnicoService.deleteTecnico(cuentaId, tecnicoId);
    }

    private Tecnico convertToEntity(SaveTecnicoResource resource) {
        return mapper.map(resource, Tecnico.class);
    }

    private TecnicoResource convertToResource(Tecnico entity){
        return mapper.map(entity, TecnicoResource.class);
    }

}
