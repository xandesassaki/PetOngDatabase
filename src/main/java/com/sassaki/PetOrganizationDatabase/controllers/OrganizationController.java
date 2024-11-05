package com.sassaki.PetOrganizationDatabase.controllers;

import com.sassaki.PetOrganizationDatabase.DTOs.OrganizationRequestDTO;
import com.sassaki.PetOrganizationDatabase.Models.Organization;
import com.sassaki.PetOrganizationDatabase.services.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
