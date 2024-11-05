package com.sassaki.PetOrganizationDatabase.services;

import com.sassaki.PetOrganizationDatabase.DTOs.OrganizationRequestDTO;
import com.sassaki.PetOrganizationDatabase.Models.Address;
import com.sassaki.PetOrganizationDatabase.Models.Description;
import com.sassaki.PetOrganizationDatabase.Models.Organization;
import com.sassaki.PetOrganizationDatabase.Repository.AddressRepository;
import com.sassaki.PetOrganizationDatabase.Repository.DescriptionRepository;
import com.sassaki.PetOrganizationDatabase.Repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private DescriptionRepository descriptionRepository;

    public Organization createOrganization(OrganizationRequestDTO organizationDTO) {

        Organization organization = new Organization();
        organization.setName(organizationDTO.getName());
        organization.setRegistrationNumber(organizationDTO.getRegistrationNumber());
        organization.setPhone(organizationDTO.getPhone());
        organization.setEmail(organizationDTO.getEmail());
        organization.setProfilePicture(organizationDTO.getProfilePicture());
        organization.setFoundationDate(organizationDTO.getFoundationDate());

        Address address = new Address();
        address.setStreet(organizationDTO.getAddress().getStreet());
        address.setCity(organizationDTO.getAddress().getCity());
        address.setState(organizationDTO.getAddress().getState());
        address.setCountry(organizationDTO.getAddress().getCountry());
        address.setPostalCode(organizationDTO.getAddress().getPostalCode());

        Description description = new Description();
        description.setWebsite(organizationDTO.getDescription().getWebsite());
        description.setSocialMedia(organizationDTO.getDescription().getSocialMedia());
        description.setAdditionalInfo(organizationDTO.getDescription().getAdditionalInfo());

        organization.setAddress(address);
        organization.setDescription(description);

        address.setOrganization(organization);
        description.setOrganization(organization);

        return organizationRepository.save(organization);
    }
}
