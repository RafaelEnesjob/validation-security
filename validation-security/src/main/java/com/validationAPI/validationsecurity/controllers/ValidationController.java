package com.validationAPI.validationsecurity.controllers;

import com.validationAPI.validationsecurity.models.entitys.Validation;
import com.validationAPI.validationsecurity.models.request.ValidationRequestDTO;
import com.validationAPI.validationsecurity.services.ValidationService;
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

    public ValidationController(ValidationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Validation> enterThePassword(@Valid @RequestBody ValidationRequestDTO validationRequest) {
            return new ResponseEntity<>(service.enterThePassword(validationRequest), HttpStatus.OK);
    }


}
