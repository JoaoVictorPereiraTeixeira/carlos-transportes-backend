package com.ajrt.carlostransportes.repository;


import com.ajrt.carlostransportes.entities.MovingHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovingHouseRepository extends JpaRepository<MovingHouse,Long> {

}