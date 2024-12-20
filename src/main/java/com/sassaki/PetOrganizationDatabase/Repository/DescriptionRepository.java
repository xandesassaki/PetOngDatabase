package com.sassaki.PetOrganizationDatabase.Repository;

import com.sassaki.PetOrganizationDatabase.Models.Description;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescriptionRepository extends JpaRepository<Description, Long> {
}
