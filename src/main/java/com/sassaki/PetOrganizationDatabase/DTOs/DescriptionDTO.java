package com.sassaki.PetOrganizationDatabase.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DescriptionDTO {
    private String website;
    private String socialMedia;
    private String additionalInfo;
}
