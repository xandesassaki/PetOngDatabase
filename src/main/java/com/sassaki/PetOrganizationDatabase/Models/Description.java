package com.sassaki.PetOrganizationDatabase.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "description")
public class Description {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String website;
    private String socialMedia;
    private String additionalInfo;

    @OneToOne
    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    @JsonIgnore
    private Organization organization;
}
