package com.sassaki.PetOrganizationDatabase.controllers;

import com.sassaki.PetOrganizationDatabase.DTOs.OrganizationRequestDTO;
import com.sassaki.PetOrganizationDatabase.Models.Organization;
import com.sassaki.PetOrganizationDatabase.services.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/organization")
public class OrganizationController {
    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @Operation(summary = "Create a new organization", tags = {"organization"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation")
    })
    @PostMapping("/create-new")
    public ResponseEntity<Organization> returnNewOrganization(@RequestBody OrganizationRequestDTO  organizationRequestDTO) {
        Organization organization = organizationService.createOrganization(organizationRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(organization);
    }

    @Operation(summary = "Delete a organization", tags ={"organization"})
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Successful Operation")
    })
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteOrganizationById(@RequestHeader Long organizationId){
        String deletedOrganization = organizationService.deleteOrganizationById(organizationId);
        return ResponseEntity.status(HttpStatus.OK).body(deletedOrganization);
    }

    @Operation(summary = "List all organization", tags ={"organization"})
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Successful Operation")
    })
    @GetMapping("/list-organizations")
    public ResponseEntity<List<Organization>> listOrganizations(){
        List<Organization> listedOrganizations = organizationService.listOrganizations();
        return ResponseEntity.status(HttpStatus.OK).body(listedOrganizations);
    }

    @Operation(summary = "Get a organization", tags ={"organization"})
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Successful Operation")
    })
    @GetMapping("/get-by-id")
    public ResponseEntity<Optional<Organization>> getOrganizationById(@RequestHeader Long organizationId){
        Optional<Organization> getOrganizationById = organizationService.getOrganizationById(organizationId);
        return ResponseEntity.status(HttpStatus.OK).body(getOrganizationById);
    }

    @Operation(summary = "Update a organization", tags ={"organization"})
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Successful Operation")
    })
    @PatchMapping("/update")
    public ResponseEntity<Organization> updateOrganization(@RequestHeader Long organizationId, @RequestBody OrganizationRequestDTO  organizationRequestDTO){
        Organization updatedOrganization = organizationService.updateOrganization(organizationId, organizationRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedOrganization);
    }
}
