package com.guidejourney.Mentory_Servive.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SessionResponseDTO {
    private Long id;

    private MentorResponseDTO mentor;

    private MenteeResponseDTO mentee;

    private LocalDateTime sessionDate;

    private String sessionSummary;
}

