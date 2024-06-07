package com.guidejourney.Mentory_Servive.repository;

import com.guidejourney.Mentory_Servive.model.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mentor.model.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramaMentoriaRepository extends JpaRepository<ProgramaMentoria, Long> {
    Optional<ProgramaMentoria> findByNombre(String nombre);
}
