package com.guidejourney.Mentory_Servive.service;

import com.guidejourney.Mentory_Servive.model.dto.SessionDTO;
import java.util.List;
import com.mentor.model.entity.Session;
import com.mentor.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;

    @Autowired
    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public List<Session> findAll() {
        return sessionRepository.findAll();
    }

    public Optional<Session> findById(Long id) {
        return sessionRepository.findById(id);
    }

    public Session save(Session session) {
        return sessionRepository.save(session);
    }

    public void deleteById(Long id) {
        sessionRepository.deleteById(id);
    }
}