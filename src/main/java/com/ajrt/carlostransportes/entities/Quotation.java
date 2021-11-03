package com.ajrt.carlostransportes.entities;

import com.ajrt.carlostransportes.dtos.QuotationRequestDTO;
import com.ajrt.carlostransportes.enums.QuotationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quotation {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @Column
    private String requesterName;

    @Column
    private String requesterMainTelephone;
    @Column
    private String requesterSecondaryTelephone;

    @Column
    private String dateSolicitation;

    @Column
    private String originCep;
    @Column
    private String originCity;
    @Column
    private String originAddress;
    @Column
    private String originDistrict;
    @Column
    private String originNumber;

    @Column
    private String destinyCep;
    @Column
    private String destinyCity;
    @Column
    private String destinyddress;
    @Column
    private String destinyDistrict;
    @Column
    private String destinyNumber;

    @Column
    private QuotationType quotationType;

    public Quotation(QuotationRequestDTO quotationRequestDTO) {
        this.requesterName = quotationRequestDTO.getRequesterName();
        this.requesterMainTelephone = quotationRequestDTO.getRequesterMainTelephone();
        this.requesterSecondaryTelephone = quotationRequestDTO.getRequesterSecondaryTelephone();
        this.dateSolicitation = quotationRequestDTO.getDateSolicitation();
        this.originCep = quotationRequestDTO.getOriginCep();
        this.originCity = quotationRequestDTO.getOriginCity();
        this.originAddress = quotationRequestDTO.getOriginAddress();
        this.originDistrict = quotationRequestDTO.getOriginDistrict();
        this.originNumber = quotationRequestDTO.getOriginNumber();
        this.destinyCep = quotationRequestDTO.getDestinyCep();
        this.destinyCity = quotationRequestDTO.getDestinyCity();
        this.destinyddress = quotationRequestDTO.getDestinyddress();
        this.destinyDistrict = quotationRequestDTO.getDestinyDistrict();
        this.destinyNumber = quotationRequestDTO.getDestinyNumber();
        this.quotationType = quotationRequestDTO.getQuotationType();
    }
}
