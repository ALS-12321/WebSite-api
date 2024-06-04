package com.guidejourney.Mentory_Servive.mapper;

import com.mentor.model.dto.MentorRequestDTO;
import com.mentor.model.dto.MentorResponseDTO;
import com.mentor.model.entity.Mentor;
import org.springframework.stereotype.Component;

@Component
public class MentorMapper {

    public Mentor toEntity(MentorRequestDTO dto) {
        return new Mentor(null, dto.getName(), dto.getExpertise(), dto.getYearsOfExperience(), dto.getEmail());
    }

    public MentorResponseDTO toDto(Mentor mentor) {
        return new MentorResponseDTO(mentor.getId(), mentor.getName(), mentor.getExpertise(), mentor.getYearsOfExperience(), mentor.getEmail());
    }
}
