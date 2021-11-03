package com.ajrt.carlostransportes.services;

import com.ajrt.carlostransportes.entities.Feedback;
import com.ajrt.carlostransportes.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    @Autowired
    FeedbackRepository feedbackRepository;

    public Feedback create(Feedback feedback) {
        Feedback feedbackCreated = feedbackRepository.save(feedback);

        return feedbackCreated;
    }
}
