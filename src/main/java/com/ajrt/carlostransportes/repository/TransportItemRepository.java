package com.ajrt.carlostransportes.repository;


import com.ajrt.carlostransportes.entities.CommonFreight;
import com.ajrt.carlostransportes.entities.TransportItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportItemRepository extends JpaRepository<TransportItem,Long> {

}