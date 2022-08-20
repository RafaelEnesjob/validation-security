package com.validationAPI.validationsecurity.api.rest.models.request;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ValidationRequestModel {
    @NotNull
    private String password;
}
