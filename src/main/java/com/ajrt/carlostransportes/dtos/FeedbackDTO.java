package com.ajrt.carlostransportes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackDTO {

    private String id;

    @NotNull(message = "Field avaliation is required")
    private Integer avaliation;

    private String description;
}
