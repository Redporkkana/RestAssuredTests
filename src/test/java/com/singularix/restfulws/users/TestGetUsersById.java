package com.singularix.restfulws.users;
import com.singularix.restfulws.base.BaseTest;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import io.restassured.response.Response;

@Epic("User API")
@Feature("User Management")
@Story("Get user details")
@Severity(SeverityLevel.CRITICAL)
public class TestGetUsersById extends BaseTest {
	
	@Test
	@Tag("regression")
	public void shouldReturnUserDetailsWhenExists() {
		
		Response response = requestSpec
				.contentType(ContentType.JSON)
				.get("/users/1");
	
		response.then()
			.statusCode(200)
			.body("id", equalTo(1))
			.body("name", notNullValue())
			.body("birthday", notNullValue());
	}
	
	@Test
	@Tag("regression")
	public void shouldReturn404WhenUserDoesntExist() {
		
		Response response = requestSpec
				.pathParam("id", 99999)
				.get("/users/+{id}");
		response.then()
			.statusCode(404);
	}
	
}
