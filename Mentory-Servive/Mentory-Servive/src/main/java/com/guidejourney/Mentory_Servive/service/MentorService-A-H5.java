package com.guidejourney.Mentory_Servive.service;

import com.guidejourney.Mentory_Servive.model.entity.Mentee;
import com.guidejourney.Mentory_Servive.model.entity.Mentor;
import com.guidejourney.Mentory_Servive.repository.MentorRepository;
import com.guidejourney.Mentory_Servive.repository.MenteeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MentorService {

    private final MentorRepository mentorRepository;
    private final MenteeRepository menteeRepository;

    @Autowired
    public MentorService(MentorRepository mentorRepository, MenteeRepository menteeRepository) {
        this.mentorRepository = mentorRepository;
        this.menteeRepository = menteeRepository;
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

    public List<Mentee> findMenteesByMentor(Mentor mentor) {
        return menteeRepository.findByMentor(mentor);
    }
}