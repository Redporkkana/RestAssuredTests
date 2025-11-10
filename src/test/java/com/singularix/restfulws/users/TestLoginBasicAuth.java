package com.singularix.restfulws.users;
import com.singularix.restfulws.base.BaseTest;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

@Epic("User API")
@Feature("User Management")
@Story("Verify authentication need enforced")
@Severity(SeverityLevel.CRITICAL)
public class TestLoginBasicAuth extends BaseTest {
	
	@Test
	@Tag("regression")
	public void shouldReturn401WhenNotAuthenticated() {
		given().when().get("/users").then().statusCode(401);
		
	}
	
	@Test
	@Tag("regression")
	public void shouldReturn200WhenAuthenticated() {
		Response response = requestSpec
				.get("/users");
		
		response.then().statusCode(200);
	}
	
}
