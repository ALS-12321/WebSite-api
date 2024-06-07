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
@RequestMapping("/api/disponibilidad")
public class DisponibilidadController {
    @Autowired
    private DisponibilidadService service;

    @PostMapping
    public ResponseEntity<Disponibilidad> agregarDisponibilidad(@RequestBody Map<String, Object> request) {
        Mentor mentor = obtenerMentorAutenticado(); // Implementar lógica de autenticación
        String dia = (String) request.get("dia");
        LocalTime horaInicio = LocalTime.parse((String) request.get("horaInicio"));
        LocalTime horaFin = LocalTime.parse((String) request.get("horaFin"));
        Disponibilidad disponibilidad = service.agregarDisponibilidad(mentor, dia, horaInicio, horaFin);
        return ResponseEntity.status(HttpStatus.CREATED).body(disponibilidad);
    }

    @GetMapping
    public ResponseEntity<List<Disponibilidad>> obtenerDisponibilidad() {
        Mentor mentor = obtenerMentorAutenticado(); // Implementar lógica de autenticación
        List<Disponibilidad> disponibilidad = service.obtenerDisponibilidad(mentor);
        return ResponseEntity.ok(disponibilidad);
    }
}