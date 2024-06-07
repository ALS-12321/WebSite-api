package com.guidejourney.Mentory_Servive.repository;

import com.mentor.model.entity.Mentee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MenteeRepository extends JpaRepository<Mentee, Long> {
    List<Mentee> findByMentorId(Long mentorId);
}
