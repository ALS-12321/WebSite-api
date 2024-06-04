package com.guidejourney.Mentory_Servive.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MentorResponseDTO {
    private Long id;

    private String name;

    private String expertise;

    private int yearsOfExperience;

    private String email;
}

