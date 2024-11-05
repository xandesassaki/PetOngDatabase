package com.sassaki.PetOrganizationDatabase.DTOs;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationRequestDTO {
    private String name;
    private String registrationNumber;
    private String phone;
    private String email;
    private String profilePicture;
    private Date foundationDate;
    private AddressDTO address;
    private DescriptionDTO description;
}
