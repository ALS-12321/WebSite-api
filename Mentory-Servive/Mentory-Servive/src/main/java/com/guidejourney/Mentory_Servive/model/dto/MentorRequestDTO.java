package com.guidejourney.Mentory_Servive.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MentorRequestDTO {

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String name;

    @NotBlank(message = "El área de experiencia no puede estar vacía")
    @Size(min = 2, max = 50, message = "El área de experiencia debe tener entre 2 y 50 caracteres")
    private String expertise;

    @NotNull(message = "Los años de experiencia no pueden estar vacíos")
    private Integer yearsOfExperience;

    @NotBlank(message = "El correo electrónico no puede estar vacío")
    @Email(message = "Debe proporcionar un correo electrónico válido")
    private String email;
}
