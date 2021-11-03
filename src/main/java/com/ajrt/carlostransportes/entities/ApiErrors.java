package com.ajrt.carlostransportes.entities;

import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ApiErrors {

    @Getter
    private String message;

    @Getter
    private List<String> errors = new ArrayList<>();

    public ApiErrors(String message) {
        this.message = message;
    }

    public ApiErrors(String message, List<String> errors) {
        this.message = message;
        this.errors = errors;
    }

    public static void verifyListIsEmpty(List t,String message) throws NotFoundException {
        if(t.isEmpty()){
            throw new NotFoundException(message);
        }
    }

    public static void verifyIsEmpty(Object t, String message) throws NotFoundException {
        if(t == null || t.equals("")){
            throw new NotFoundException(message);
        }
    }
}