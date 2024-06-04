package com.guidejourney.Mentory_Servive.service;

import com.guidejourney.Mentory_Servive.model.dto.MentorDTO;
import java.util.List;
import com.mentor.model.entity.Mentor;
import com.mentor.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MentorService {

    private final MentorRepository mentorRepository;

    @Autowired
    public MentorService(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    public List<Mentor> findAll() {
        return mentorRepository.findAll();
    }

    public Optional<Mentor> findById(Long id) {
        return mentorRepository.findById(id);
    }

    public Mentor save(Mentor mentor) {
        return mentorRepository.save(mentor);
    }

    public void deleteById(Long id) {
        mentorRepository.deleteById(id);
    }
}