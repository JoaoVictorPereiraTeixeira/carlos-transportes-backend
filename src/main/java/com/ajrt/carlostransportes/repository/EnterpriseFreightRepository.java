package com.ajrt.carlostransportes.repository;


import com.ajrt.carlostransportes.entities.EnterpriseFreight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseFreightRepository extends JpaRepository<EnterpriseFreight,Long> {

}