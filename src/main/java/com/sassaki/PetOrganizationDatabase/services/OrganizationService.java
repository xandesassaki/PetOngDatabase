package com.sassaki.PetOrganizationDatabase.services;

import com.sassaki.PetOrganizationDatabase.DTOs.OrganizationRequestDTO;
import com.sassaki.PetOrganizationDatabase.Models.Address;
import com.sassaki.PetOrganizationDatabase.Models.Description;
import com.sassaki.PetOrganizationDatabase.Models.Organization;
import com.sassaki.PetOrganizationDatabase.Repository.AddressRepository;
import com.sassaki.PetOrganizationDatabase.Repository.DescriptionRepository;
import com.sassaki.PetOrganizationDatabase.Repository.OrganizationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public String deleteOrganizationById(Long organizationId){
        String organizationName = organizationRepository.getReferenceById(organizationId).getName();

        organizationRepository.deleteById(organizationId);

        return "Deleted the organizatiton: " + organizationName;
    }

    public List<Organization> listOrganizations(){
        return organizationRepository.findAll();
    }

    public Optional<Organization> getOrganizationById(Long organizationId){
        return organizationRepository.findById(organizationId);
    }

    public Organization updateOrganization(Long organizationId, OrganizationRequestDTO organizationRequestDTO){

        Organization oldOrganization = getOrganizationById(organizationId).get();

        oldOrganization.setName(organizationRequestDTO.getName() != null ? organizationRequestDTO.getName() : oldOrganization.getName());
        oldOrganization.setRegistrationNumber(organizationRequestDTO.getRegistrationNumber() != null ? organizationRequestDTO.getRegistrationNumber() : oldOrganization.getRegistrationNumber());
        oldOrganization.setPhone(organizationRequestDTO.getPhone() != null ? organizationRequestDTO.getPhone() : oldOrganization.getPhone());
        oldOrganization.setEmail(organizationRequestDTO.getEmail() != null ? organizationRequestDTO.getEmail() : oldOrganization.getEmail());
        oldOrganization.setProfilePicture(organizationRequestDTO.getProfilePicture() != null ? organizationRequestDTO.getProfilePicture() : oldOrganization.getProfilePicture());
        oldOrganization.setFoundationDate(organizationRequestDTO.getFoundationDate() != null ? organizationRequestDTO.getFoundationDate() : oldOrganization.getFoundationDate());

        if (organizationRequestDTO.getAddress() != null) {
            Address address = oldOrganization.getAddress();
            address.setStreet(organizationRequestDTO.getAddress().getStreet() != null ? organizationRequestDTO.getAddress().getStreet() : address.getStreet());
            address.setCity(organizationRequestDTO.getAddress().getCity() != null ? organizationRequestDTO.getAddress().getCity() : address.getCity());
            address.setState(organizationRequestDTO.getAddress().getState() != null ? organizationRequestDTO.getAddress().getState() : address.getState());
            address.setCountry(organizationRequestDTO.getAddress().getCountry() != null ? organizationRequestDTO.getAddress().getCountry() : address.getCountry());
            address.setPostalCode(organizationRequestDTO.getAddress().getPostalCode() != null ? organizationRequestDTO.getAddress().getPostalCode() : address.getPostalCode());
        }

        if (organizationRequestDTO.getDescription() != null) {
            Description description = oldOrganization.getDescription();
            description.setWebsite(organizationRequestDTO.getDescription().getWebsite() != null ? organizationRequestDTO.getDescription().getWebsite() : description.getWebsite());
            description.setSocialMedia(organizationRequestDTO.getDescription().getSocialMedia() != null ? organizationRequestDTO.getDescription().getSocialMedia() : description.getSocialMedia());
            description.setAdditionalInfo(organizationRequestDTO.getDescription().getAdditionalInfo() != null ? organizationRequestDTO.getDescription().getAdditionalInfo() : description.getAdditionalInfo());
        }

        return organizationRepository.save(oldOrganization);
    }

}
