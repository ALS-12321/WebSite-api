package com.guidejourney.Mentory_Servive.controller;

import com.mentor.model.dto.MentorRequestDTO;
import com.mentor.model.dto.MentorResponseDTO;
import com.mentor.service.MentorService;
import com.mentor.mapper.MentorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mentors")
public class MentorController {

    private final MentorService mentorService;
    private final MentorMapper mentorMapper;

    @Autowired
    public MentorController(MentorService mentorService, MentorMapper mentorMapper) {
        this.mentorService = mentorService;
        this.mentorMapper = mentorMapper;
    }

    @GetMapping
    public List<MentorResponseDTO> getAllMentors() {
        return mentorService.findAll().stream().map(mentorMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MentorResponseDTO> getMentorById(@PathVariable Long id) {
        return mentorService.findById(id)
                .map(mentor -> ResponseEntity.ok(mentorMapper.toDto(mentor)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public MentorResponseDTO createMentor(@RequestBody MentorRequestDTO mentorRequestDTO) {
        return mentorMapper.toDto(mentorService.save(mentorMapper.toEntity(mentorRequestDTO)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMentor(@PathVariable Long id) {
        if (mentorService.findById(id).isPresent()) {
            mentorService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
