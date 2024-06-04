package com.guidejourney.Mentory_Servive.repository;

import com.mentor.model.entity.Mentee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenteeRepository extends JpaRepository<Mentee, Long> {
    // Métodos personalizados si es necesario
}
