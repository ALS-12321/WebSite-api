package com.guidejourney.Mentory_Servive.repository;

import com.guidejourney.Mentory_Servive.model.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mentor.model.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {
    // Métodos personalizados si es necesario
}
