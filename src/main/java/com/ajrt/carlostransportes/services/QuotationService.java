package com.ajrt.carlostransportes.services;

import com.ajrt.carlostransportes.dtos.QuotationRequestDTO;
import com.ajrt.carlostransportes.entities.*;
import com.ajrt.carlostransportes.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuotationService {

    @Autowired
    CommonFreightRepository commonFreightRepository;

    @Autowired
    EnterpriseFreightRepository enterpriseFreightRepository;

    @Autowired
    MovingHouseRepository movingHouseRepository;

    public CommonFreight createCommonFreight(CommonFreight commonFreight) {
        CommonFreight commonFreightCreated = commonFreightRepository.save(commonFreight);
        return commonFreightCreated;
    }

    public EnterpriseFreight createEnterpriseFreight(EnterpriseFreight enterpriseFreight) {
        EnterpriseFreight enterpriseFreightCreated = enterpriseFreightRepository.save(enterpriseFreight);
        return enterpriseFreightCreated;
    }

    public MovingHouse createMovingHouse(MovingHouse movingHouse) {
        MovingHouse movingHouseCreated = movingHouseRepository.save(movingHouse);
        return movingHouseCreated;
    }

    public List<EnterpriseFreight> findAll() {
        return enterpriseFreightRepository.findAll();
    }
}
