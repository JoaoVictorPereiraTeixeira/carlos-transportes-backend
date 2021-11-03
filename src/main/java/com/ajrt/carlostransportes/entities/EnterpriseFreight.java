package com.ajrt.carlostransportes.entities;

import com.ajrt.carlostransportes.dtos.QuotationRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnterpriseFreight extends Quotation {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @Column
    private Long weight;

    @Column
    private String cnpjSender;

    @Column
    private String cnpjRecipient;

    @Column
    private Integer quantityItems;

    @Column
    private String collectObservations;

    @Column
    private String merchandiseObservations;

    @Column
    Boolean paidAtOrigin;

    @Column
    private String dateToCollect;

    public EnterpriseFreight(QuotationRequestDTO quotationRequestDTO) {
        super(quotationRequestDTO);
        this.paidAtOrigin = quotationRequestDTO.getPaidAtOrigin();
        this.cnpjSender = quotationRequestDTO.getCnpjSender();
        this.cnpjRecipient = quotationRequestDTO.getCnpjRecipient();
        this.weight = quotationRequestDTO.getWeight();
        this.quantityItems = quotationRequestDTO.getQuantityItems();
        this.collectObservations = quotationRequestDTO.getCollectObservations();
        this.merchandiseObservations = quotationRequestDTO.getMerchandiseObservations();
        this.dateToCollect = quotationRequestDTO.getDateToCollect();
    }
}
