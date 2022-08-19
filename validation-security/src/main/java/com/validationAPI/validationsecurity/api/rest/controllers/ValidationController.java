package com.validationAPI.validationsecurity.api.rest.controllers;

import com.validationAPI.validationsecurity.api.rest.mapper.ValidationMapper;
import com.validationAPI.validationsecurity.api.rest.models.response.ValidationResponseModel;
import com.validationAPI.validationsecurity.api.rest.models.request.ValidationRequestModel;
import com.validationAPI.validationsecurity.domain.entities.Validation;
import com.validationAPI.validationsecurity.domain.services.ValidationService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(value = "/validation")
@Api(value = "API Validation Security")
@CrossOrigin(origins = "*")
public class ValidationController {

    private final ValidationService service;
    private final ValidationMapper converter;

    public ValidationController(ValidationService service, ValidationMapper converter) {
        this.service = service;
        this.converter = converter;
    }

    @PostMapping
    public ResponseEntity<ValidationResponseModel> enterThePassword(@Valid @RequestBody ValidationRequestModel validationRequest) {
        Validation validation = converter.toEntity(validationRequest);
        return new ResponseEntity<>(converter.toModel(service.enterThePassword(validation)), HttpStatus.OK);
    }
}
