package com.guidejourney.Mentory_Servive.repository;

import com.guidejourney.Mentory_Servive.model.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mentor.model.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    // Métodos personalizados si es necesario
}
