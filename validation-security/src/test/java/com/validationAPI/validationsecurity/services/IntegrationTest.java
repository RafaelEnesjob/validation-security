package com.validationAPI.validationsecurity.services;

import com.google.common.io.Files;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import static com.jayway.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest  {

    private static final String RESOURCE_DIRECTORY = "src/test/resources";

    @LocalServerPort
    public int port;

    @Test
    void shouldReturnIsValidTrueWhenHasCorrectPassword() throws IOException {

        given()
                .log().everything()
                .when()
                .body(resource("/__files/enterThePassword.json").replace("{password}", "AbTp9!fok"))
                .contentType("application/json")
                .port(port)
                .post("/validation")
                .then()
                .log().everything()
                .assertThat()
                .body("isValid", is(true))
                .statusCode(SC_OK);
    }

    private static String resource(String payloadPath) throws IOException {
        File file = new File(RESOURCE_DIRECTORY + payloadPath);
        if (!file.exists()) {
            throw new IllegalArgumentException("Payload file not found: "
                    + RESOURCE_DIRECTORY + payloadPath);
        }
        return Files.toString(file, Charset.defaultCharset());
    }

}