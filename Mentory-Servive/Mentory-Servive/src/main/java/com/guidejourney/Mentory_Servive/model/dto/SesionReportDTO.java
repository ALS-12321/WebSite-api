package com.guidejourney.Mentory_Servive.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SessionReportDTO {
    private Long id;

    @NotNull(message = "El ID del mentor no puede estar vacío")
    private Long mentorId;

    @NotNull(message = "El ID del mentee no puede estar vacío")
    private Long menteeId;

    @NotNull(message = "La fecha de la sesión no puede estar vacía")
    private LocalDateTime sessionDate;

    @NotBlank(message = "El resumen de la sesión no puede estar vacío")
    private String sessionSummary;
}

