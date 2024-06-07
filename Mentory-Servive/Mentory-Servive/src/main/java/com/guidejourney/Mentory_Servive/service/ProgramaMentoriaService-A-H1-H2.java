package com.guidejourney.Mentory_Servive.service;

import com.guidejourney.Mentory_Servive.model.dto.SessionDTO;
import com.mentor.model.entity.Session;
import com.mentor.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramaMentoriaService {
    @Autowired
    private ProgramaMentoriaRepository repository;

    public ProgramaMentoria crearProgramaMentoria(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new BadRequestException("El nombre es obligatorio y debe ser válido.");
        }
        if (repository.findByNombre(nombre).isPresent()) {
            throw new BadRequestException("El nombre debe ser único.");
        }
        if (costo == null || costo < 0) {
            throw new BadRequestException("El costo debe ser un monto válido.");
        }

        ProgramaMentoria programa = new ProgramaMentoria();
        programa.setNombre(nombre);
        programa.setCosto(costo);
        return repository.save(programa);
    }
}