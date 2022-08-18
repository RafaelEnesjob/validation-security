package com.validationAPI.validationsecurity.mapper;

import com.validationAPI.validationsecurity.models.entitys.Validation;
import com.validationAPI.validationsecurity.models.request.ValidationRequestDTO;

public enum ValidationConverter {

    INSTANCE;
    public Validation toValidation(ValidationRequestDTO requestDTO) {
        if (requestDTO == null) {
            return null;
        }
        Validation validation = new Validation();
        validation.setPassword(requestDTO.getPassword());
        return validation;
    }
}
