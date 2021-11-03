package com.ajrt.carlostransportes.repository;


import com.ajrt.carlostransportes.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback,Long> {

}