package com.sassaki.PetOrganizationDatabase.Repository;

import com.sassaki.PetOrganizationDatabase.Models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
