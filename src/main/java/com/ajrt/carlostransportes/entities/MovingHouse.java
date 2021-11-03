package com.ajrt.carlostransportes.entities;

import com.ajrt.carlostransportes.dtos.QuotationRequestDTO;
import com.ajrt.carlostransportes.dtos.TransportItemsDTO;
import com.ajrt.carlostransportes.enums.TypeHousing;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovingHouse extends Quotation{

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @Column
    private TypeHousing typeHousing;

    @Column
    private boolean hasElevator;

    @Column
    private boolean needHelper;

    @Column
    private String dateToCollect;

    @OneToMany(cascade=CascadeType.ALL , orphanRemoval = true)
    private List<TransportItem> transportItems = new ArrayList<>();

    public MovingHouse(QuotationRequestDTO quotationRequestDTO) {
        super(quotationRequestDTO);
        this.typeHousing = quotationRequestDTO.getTypeHousing();
        this.dateToCollect = quotationRequestDTO.getDateToCollect();
        this.hasElevator = quotationRequestDTO.isHasElevator();
        this.needHelper = quotationRequestDTO.isNeedHelper();
        this.transportItems = quotationRequestDTO.getTransportItems().stream().map(this::convertTransportItemsToEntity).collect(Collectors.toList());
    }

    private TransportItem convertTransportItemsToEntity(TransportItemsDTO transportItemsDTO){
        return new TransportItem(transportItemsDTO);
    }
}
