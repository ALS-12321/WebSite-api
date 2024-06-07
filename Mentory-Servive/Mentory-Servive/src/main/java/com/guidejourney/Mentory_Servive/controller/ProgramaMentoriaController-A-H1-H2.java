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
@RequestMapping("/api/programas")
public class ProgramaMentoriaController {
    @Autowired
    private ProgramaMentoriaService service;

    @PostMapping
    public ResponseEntity<ProgramaMentoria> crearPrograma(@RequestBody Map<String, Object> request) {
        String nombre = (String) request.get("nombre");
        Double costo = Double.valueOf(request.get("costo").toString());
        ProgramaMentoria programa = service.crearProgramaMentoria(nombre, costo);
        return ResponseEntity.status(HttpStatus.CREATED).body(programa);
    }
}