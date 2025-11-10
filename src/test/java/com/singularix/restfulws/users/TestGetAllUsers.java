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

@Epic("User API")
@Feature("User Management")
@Story("Get user details")
@Severity(SeverityLevel.CRITICAL)
public class TestGetAllUsers extends BaseTest {
	
	@Test
	@Tag("regression")
	public void shouldReturn200OKWhenAccessingAllUsers() {
		Response response = requestSpec
				.get("/users");
		
		response.then().statusCode(200);
	}
	
}
