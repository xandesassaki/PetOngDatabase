package com.sassaki.PetOrganizationDatabase.services;

import com.sassaki.PetOrganizationDatabase.Models.Address;
import com.sassaki.PetOrganizationDatabase.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public Optional<Address> getAddress(Long id) {
        return addressRepository.findById(id);
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
