package com.sassaki.PetOrganizationDatabase.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String state;
    private String country;
    private String postalCode;

    @OneToOne
    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    @JsonBackReference
    private Organization organization;
}
