package com.ajrt.carlostransportes.controllers;

import com.ajrt.carlostransportes.dtos.FeedbackDTO;
import com.ajrt.carlostransportes.entities.ConfigEmail;
import com.ajrt.carlostransportes.entities.Feedback;
import com.ajrt.carlostransportes.entities.Quotation;
import com.ajrt.carlostransportes.services.EmailService;
import com.ajrt.carlostransportes.services.FeedbackService;
import com.ajrt.carlostransportes.services.QuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/feedbacks")
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @Autowired
    EmailService emailService;

    @PostMapping
    public ResponseEntity<Feedback> create(@RequestBody @Valid FeedbackDTO feedbackDTO) throws Exception {
        Feedback feedback = new Feedback(feedbackDTO);
        Feedback feedbackCreated = feedbackService.create(feedback);

        String content = emailService.getHtmlFeedbackCreated(feedbackDTO);
        ConfigEmail configEmail = new ConfigEmail();
        configEmail.setContent(content);
        configEmail.setSubject("Carlos Transportes - Novo feedback recebido");

        emailService.sendEmail(configEmail);

        return ResponseEntity.ok().body(feedbackCreated);
    }

}
