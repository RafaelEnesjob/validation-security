package com.validationAPI.validationsecurity.api.rest.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ValidationRequestModel {
    @NotNull
    private String password;
}
