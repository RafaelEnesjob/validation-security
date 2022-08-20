package com.validationAPI.validationsecurity.services;

import com.validationAPI.validationsecurity.domain.entities.Validation;
import com.validationAPI.validationsecurity.domain.repositories.ValidationRepository;
import com.validationAPI.validationsecurity.domain.services.ValidationService;
import org.hibernate.mapping.Any;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class ValidationServiceTests {

    @InjectMocks
    private ValidationService service;

    @Mock
    private ValidationRepository repository;

    private String password;


    @Test
    void shouldReturnIsValidTrueWhenHasCorrectPassword() {
        Validation validation = new Validation();
        validation.setValid(true);

        Mockito.when(repository.save(any())).thenReturn(validation);

        validation = service.enterThePassword(new Validation("AbTp9!fok"));
        Assertions.assertEquals(true, validation.getValid());
    }

    @Test
    void shouldReturnBadRequestWhenHasIncorrectPassword() {

        Exception exception = Assertions.assertThrows(ResponseStatusException.class,() -> service.enterThePassword(new Validation("aa")));

        String message = ((ResponseStatusException) exception).getReason();

        Assertions.assertTrue("A senha não deve conter caracteres repetidos.".contains(message));
    }


}
