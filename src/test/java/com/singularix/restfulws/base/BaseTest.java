package com.singularix.restfulws.base;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.qameta.allure.restassured.AllureRestAssured;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    @Value("${spring.security.user.name}")
    private String username;

    @Value("${spring.security.user.password}")
    private String password;

    @LocalServerPort
    private int port; 
    
    protected RequestSpecification requestSpec;

    @BeforeAll
    public void setup() {
        RestAssured.filters(new AllureRestAssured());

        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port; 

        requestSpec = RestAssured.given()
                .auth().preemptive().basic(username, password)
                .contentType("application/json");
    }
}
