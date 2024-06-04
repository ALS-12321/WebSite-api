package com.guidejourney.Mentory_Servive.controller;

import com.mentor.model.dto.MenteeRequestDTO;
import com.mentor.model.dto.MenteeResponseDTO;
import com.mentor.service.MenteeService;
import com.mentor.mapper.MenteeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mentees")
public class MenteeController {

    private final MenteeService menteeService;
    private final MenteeMapper menteeMapper;

    @Autowired
    public MenteeController(MenteeService menteeService, MenteeMapper menteeMapper) {
        this.menteeService = menteeService;
        this.menteeMapper = menteeMapper;
    }

    @GetMapping
    public List<MenteeResponseDTO> getAllMentees() {
        return menteeService.findAll().stream().map(menteeMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenteeResponseDTO> getMenteeById(@PathVariable Long id) {
        return menteeService.findById(id)
                .map(mentee -> ResponseEntity.ok(menteeMapper.toDto(mentee)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public MenteeResponseDTO createMentee(@RequestBody MenteeRequestDTO menteeRequestDTO) {
        return menteeMapper.toDto(menteeService.save(menteeMapper.toEntity(menteeRequestDTO)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMentee(@PathVariable Long id) {
        if (menteeService.findById(id).isPresent()) {
            menteeService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}