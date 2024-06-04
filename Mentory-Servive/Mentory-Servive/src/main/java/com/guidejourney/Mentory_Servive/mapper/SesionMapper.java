package com.guidejourney.Mentory_Servive.mapper;


import com.mentor.model.dto.SessionRequestDTO;
import com.mentor.model.dto.SessionResponseDTO;
import com.mentor.model.entity.Session;
import org.springframework.stereotype.Component;

@Component
public class SessionMapper {

    private final MentorMapper mentorMapper;
    private final MenteeMapper menteeMapper;

    public SessionMapper(MentorMapper mentorMapper, MenteeMapper menteeMapper) {
        this.mentorMapper = mentorMapper;
        this.meneeMapper = menteeMapper;
    }

    public Session toEntity(SessionRequestDTO dto) {
        return new Session(null, dto.getMentorId(), dto.getMenteeId(), dto.getSessionDate(), dto.getSessionSummary());
    }

    public SessionResponseDTO toDto(Session session) {
        return new SessionResponseDTO(
                session.getId(),
                mentorMapper.toDto(session.getMentor()),
                menteeMapper.toDto(session.getMentee()),
                session.getSessionDate(),
                session.getSessionSummary()
        );
    }
}