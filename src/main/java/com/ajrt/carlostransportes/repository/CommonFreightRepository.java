package com.ajrt.carlostransportes.repository;


import com.ajrt.carlostransportes.entities.CommonFreight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonFreightRepository extends JpaRepository<CommonFreight,Long> {

}