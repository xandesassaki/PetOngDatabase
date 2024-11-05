package com.sassaki.PetOrganizationDatabase.services;

import com.sassaki.PetOrganizationDatabase.Models.Description;
import com.sassaki.PetOrganizationDatabase.Repository.DescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DescriptionService {

    private final DescriptionRepository descriptionRepository;

    @Autowired
    public DescriptionService(DescriptionRepository addressRepository) {
        this.descriptionRepository = addressRepository;
    }

    public Description saveAddress(Description address) {
        return descriptionRepository.save(address);
    }

    public Optional<Description> getAddress(Long id) {
        return descriptionRepository.findById(id);
    }

    public List<Description> getAllAddresses() {
        return descriptionRepository.findAll();
    }

    public void deleteAddress(Long id) {
        descriptionRepository.deleteById(id);
    }
}
