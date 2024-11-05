package com.sassaki.PetOrganizationDatabase;

import com.sassaki.PetOrganizationDatabase.DTOs.OrganizationRequestDTO;
import com.sassaki.PetOrganizationDatabase.Models.Organization;
import com.sassaki.PetOrganizationDatabase.Repository.OrganizationRepository;
import com.sassaki.PetOrganizationDatabase.services.OrganizationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class OrganizationServiceTest {

	@InjectMocks
	private OrganizationService organizationService;

	@Mock
	private OrganizationRepository organizationRepository;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testCreateOrganization() {
		OrganizationRequestDTO request = new OrganizationRequestDTO();
		request.setName("Test Organization");
		// ... set outros campos ...

		Organization expectedOrganization = new Organization();
		expectedOrganization.setName("Test Organization");
		// ... set outros campos ...

		// Mock do repositório para retornar a organização criada
		when(organizationRepository.save(any(Organization.class))).thenReturn(expectedOrganization);

		// Act
		Organization actualOrganization = organizationService.createOrganization(request);

		// Assert
		assertNotNull(actualOrganization);
		assertEquals(expectedOrganization.getName(), actualOrganization.getName());
		// ... adicione mais asserções conforme necessário ...
	}
}
