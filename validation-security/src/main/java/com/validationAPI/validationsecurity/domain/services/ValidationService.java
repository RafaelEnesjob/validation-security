package com.validationAPI.validationsecurity.domain.services;

import com.validationAPI.validationsecurity.domain.entities.Validation;
import com.validationAPI.validationsecurity.domain.repositories.ValidationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

@Service
public class ValidationService {

    private static String message;
    private final ValidationRepository repository;
    private static final Pattern DIGIT = Pattern.compile("\\p{Digit}+");
    private static final Pattern LOWER = Pattern.compile("\\p{Lower}+");
    private static final Pattern UPPER = Pattern.compile("\\p{Upper}+");
    private static final Pattern PUNCT = Pattern.compile("\\p{Punct}+");
    private static final Pattern NINE = Pattern.compile("[^\\p{Space}]{9,512}");

    public ValidationService(ValidationRepository repository) {
        this.repository = repository;
    }

    private static boolean hasDuplicatedChar(String password) {

        char[] inp = password.toCharArray();
        for (int i = 0; i < password.length(); i++) {
            for (int j = i + 1; j < password.length(); j++) {
                if (inp[i] == inp[j]) return true;
            }
        }
        return false;
    }

    private static boolean isValid(String password) {
        message = "true";
        if (!DIGIT.matcher(password).find()) message = "A senha deve conter ao menos um dígito.";
        if (!LOWER.matcher(password).find()) message = "A senha deve conter ao menos uma letra minúscula.";
        if (!UPPER.matcher(password).find()) message = "A senha deve conter ao menos uma letra maiúscula.";
        if (!PUNCT.matcher(password).find()) message = "A senha deve conter ao menos um caracter especial.";
        if (!NINE.matcher(password).find()) message = "A senha deve conter no mínimo 9 caracteres.";
        if (hasDuplicatedChar(password)) message = "A senha não deve conter caracteres repetidos.";

        return message.equalsIgnoreCase("true");
    }


    @Transactional
    public Validation enterThePassword(Validation validation) {
        if (!isValid(validation.getPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
        }
        validation.setValid(isValid(validation.getPassword()));
        validation.setPassword(encryption(validation.getPassword()));
        return repository.save(validation);
    }

    private static String encryption(String password) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(password.getBytes(StandardCharsets.UTF_8));
            byte[] digest = messageDigest.digest();
            for (byte b : digest) {
                stringBuilder.append(String.format("%02x", b & 0xFF));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
