package com.validationAPI.validationsecurity.api.rest.mapper;

import com.validationAPI.validationsecurity.api.rest.models.request.ValidationRequestModel;
import com.validationAPI.validationsecurity.api.rest.models.response.ValidationResponseModel;
import com.validationAPI.validationsecurity.domain.entities.Validation;
import org.springframework.stereotype.Component;

@Component
public class ValidationMapper {

    public Validation toEntity(ValidationRequestModel requestModel) {
        Validation validation = new Validation();
        validation.setPassword(requestModel.getPassword());
        return validation;
    }

    public ValidationResponseModel toModel(Validation validation) {
        ValidationResponseModel validationResponseModel = new ValidationResponseModel();
        validationResponseModel.setIsValid(validation.getValid());
        return validationResponseModel;
    }
}
