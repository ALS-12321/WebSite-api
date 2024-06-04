package com.guidejourney.Mentory_Servive.controller;

import com.mentor.model.dto.SessionRequestDTO;
import com.mentor.model.dto.SessionResponseDTO;
import com.mentor.service.SessionService;
import com.mentor.mapper.SessionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sessions")
public class SessionController {

    private final SessionService sessionService;
    private final SessionMapper sessionMapper;

    @Autowired
    public SessionController(SessionService sessionService, SessionMapper sessionMapper) {
        this.sessionService = sessionService;
        this.sessionMapper = sessionMapper;
    }

    @GetMapping
    public List<SessionResponseDTO> getAllSessions() {
        return sessionService.findAll().stream().map(sessionMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SessionResponseDTO> getSessionById(@PathVariable Long id) {
        return sessionService.findById(id)
                .map(session -> ResponseEntity.ok(sessionMapper.toDto(session)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SessionResponseDTO createSession(@RequestBody SessionRequestDTO sessionRequestDTO) {
        return sessionMapper.toDto(sessionService.save(sessionMapper.toEntity(sessionRequestDTO)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSession(@PathVariable Long id) {
        if (sessionService.findById(id).isPresent()) {
            sessionService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}