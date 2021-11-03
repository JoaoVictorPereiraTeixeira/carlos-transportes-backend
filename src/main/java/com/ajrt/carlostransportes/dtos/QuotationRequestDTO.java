package com.ajrt.carlostransportes.dtos;

import com.ajrt.carlostransportes.enums.QuotationType;
import com.ajrt.carlostransportes.enums.TypeHousing;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuotationRequestDTO {

    @NotEmpty(message = "Field requesterName is required")
    private String requesterName;

    @NotEmpty(message = "Field requesterMainTelephone is required")
    private String requesterMainTelephone;

    private String requesterSecondaryTelephone;

    private String dateSolicitation;

    @NotEmpty(message = "Field originCep is required")
    private String originCep;

    @NotEmpty(message = "Field originCity is required")
    private String originCity;

    @NotEmpty(message = "Field originAddress is required")
    private String originAddress;

    @NotEmpty(message = "Field originDistrict is required")
    private String originDistrict;

    private String originNumber;

    @NotEmpty(message = "Field destinyCep is required")
    private String destinyCep;

    @NotEmpty(message = "Field destinyCity is required")
    private String destinyCity;

    @NotEmpty(message = "Field destinyddress is required")
    private String destinyddress;

    @NotEmpty(message = "Field destinyDistrict is required")
    private String destinyDistrict;

    private String destinyNumber;

    private Long weight;

    private Integer quantityItems;

    private String CollectObservations;

    private String merchandiseObservations;

    private String dateToCollect;

    private boolean needHelper;

    private TypeHousing typeHousing;

    private QuotationType quotationType;

    private boolean hasElevator;

    private String cnpjSender;

    private String cnpjRecipient;

    private Boolean paidAtOrigin;

    private List<TransportItemsDTO> transportItems = new ArrayList<>();

}
