package com.ajrt.carlostransportes.controllers;


import com.ajrt.carlostransportes.dtos.QuotationRequestDTO;
import com.ajrt.carlostransportes.entities.*;
import com.ajrt.carlostransportes.services.EmailService;
import com.ajrt.carlostransportes.services.QuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/quotations")
public class QuotationController {

    @Autowired
    QuotationService quotationService;

    @Autowired
    EmailService emailService;

    @CrossOrigin
    @PostMapping
    public  ResponseEntity<Quotation> create(@RequestBody @Valid QuotationRequestDTO quotationDTO) throws Exception {

        Quotation quotation;

        switch (quotationDTO.getQuotationType()){
            case CARRETOS:
            case FRETES_COMUNS:
                CommonFreight commonFreight = new CommonFreight(quotationDTO);
                quotation = quotationService.createCommonFreight(commonFreight);
                break;
            case MUDANCAS:
                MovingHouse movingHouse = new MovingHouse(quotationDTO);
                quotation = quotationService.createMovingHouse(movingHouse);
                break;
            case FRETES_EMPRESARIAIS:
                EnterpriseFreight enterpriseFreight = new EnterpriseFreight(quotationDTO);
                quotation = quotationService.createEnterpriseFreight(enterpriseFreight);
                break;
            default:
                throw new Exception("Quotation type not exists");
        }

        ConfigEmail configEmail = new ConfigEmail();
        String content = emailService.getHtmlQuotationCreated("Dados da cotação criada", quotationDTO);
        configEmail.setContent(content);
        configEmail.setSubject("Carlos Transportes - Nova cotação realizada");

        emailService.sendEmail(configEmail);

        return ResponseEntity.status(HttpStatus.CREATED).body(quotation);
    }

    @GetMapping
    public  ResponseEntity<List<EnterpriseFreight>> getAll() throws Exception {
        List<EnterpriseFreight> quotations = quotationService.findAll();
        return ResponseEntity.ok().body(quotations);
    }

}
