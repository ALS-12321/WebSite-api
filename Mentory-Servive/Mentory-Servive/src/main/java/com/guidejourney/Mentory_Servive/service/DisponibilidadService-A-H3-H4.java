package com.guidejourney.Mentory_Servive.service;

import com.guidejourney.Mentory_Servive.model.dto.SessionDTO;
import com.mentor.model.entity.Session;
import com.mentor.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisponibilidadService {
    @Autowired
    private DisponibilidadRepository repository;

    public Disponibilidad agregarDisponibilidad(Mentor mentor, String dia, LocalTime horaInicio, LocalTime horaFin) {
        if (horaInicio.isAfter(horaFin)) {
            throw new BadRequestException("La hora de inicio debe ser antes de la hora de fin.");
        }

        Disponibilidad disponibilidad = new Disponibilidad();
        disponibilidad.setMentor(mentor);
        disponibilidad.setDia(dia);
        disponibilidad.setHoraInicio(horaInicio);
        disponibilidad.setHoraFin(horaFin);
        return repository.save(disponibilidad);
    }
}