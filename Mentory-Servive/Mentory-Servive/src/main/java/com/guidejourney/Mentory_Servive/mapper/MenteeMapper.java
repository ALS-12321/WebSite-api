package com.guidejourney.Mentory_Servive.mapper;

import com.mentor.model.dto.MenteeRequestDTO;
import com.mentor.model.dto.MenteeResponseDTO;
import com.mentor.model.entity.Mentee;
import org.springframework.stereotype.Component;

@Component
public class MenteeMapper {

    public Mentee toEntity(MenteeRequestDTO dto) {
        return new Mentee(null, dto.getName(), dto.getLearningGoals(), dto.getEmail());
    }

    public MenteeResponseDTO toDto(Mentee mentee) {
        return new MenteeResponseDTO(mentee.getId(), mentee.getName(), mentee.getLearningGoals(), mentee.getEmail());
    }
}