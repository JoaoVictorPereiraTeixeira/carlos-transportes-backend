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
public class CommonFreight extends Quotation{

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @Column
    private boolean needHelper;

    @Column
    private String merchandiseObservations;

    public CommonFreight(QuotationRequestDTO quotationRequestDTO) {
        super(quotationRequestDTO);
        this.needHelper = quotationRequestDTO.isNeedHelper();
        this.merchandiseObservations = quotationRequestDTO.getMerchandiseObservations();
    }
}
