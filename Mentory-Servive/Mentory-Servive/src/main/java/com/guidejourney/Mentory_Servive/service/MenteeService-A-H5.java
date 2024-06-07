package com.guidejourney.Mentory_Servive.service;

import com.guidejourney.Mentory_Servive.model.dto.MenteeDTO;
import java.util.List;
import com.mentor.model.entity.Mentee;
import com.mentor.repository.MenteeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenteeService {

    private final MenteeRepository menteeRepository;

    @Autowired
    public MenteeService(MenteeRepository menteeRepository) {
        this.menteeRepository = menteeRepository;
    }

    public List<Mentee> findAll() {
        return menteeRepository.findAll();
    }

    public Optional<Mentee> findById(Long id) {
        return menteeRepository.findById(id);
    }

    public Mentee save(Mentee mentee) {
        return menteeRepository.save(mentee);
    }

    public void deleteById(Long id) {
        menteeRepository.deleteById(id);
    }

    public List<Mentee> findByMentor(Long mentorId) {
        return menteeRepository.findByMentorId(mentorId);
    }
}