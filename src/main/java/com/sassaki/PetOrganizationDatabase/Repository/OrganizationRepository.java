package com.sassaki.PetOrganizationDatabase.Repository;

import com.sassaki.PetOrganizationDatabase.Models.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}
