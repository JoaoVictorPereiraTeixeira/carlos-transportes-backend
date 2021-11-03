package com.ajrt.carlostransportes.dtos;

import com.ajrt.carlostransportes.enums.QuotationType;
import com.ajrt.carlostransportes.enums.TypeHousing;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransportItemsDTO {

    private String item;

    private Integer quantity;

}
