package com.ajrt.carlostransportes.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfigEmail {
    private String subject;
    private String content;
    private List<String> addressList;
}
