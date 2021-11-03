package com.ajrt.carlostransportes.entities;

import com.ajrt.carlostransportes.dtos.TransportItemsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransportItem {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @Column
    private String item;

    @Column
    private Integer quantity;

    public TransportItem(TransportItemsDTO transportItemsDTO) {
        this.item = transportItemsDTO.getItem();
        this.quantity = transportItemsDTO.getQuantity();
    }
}
