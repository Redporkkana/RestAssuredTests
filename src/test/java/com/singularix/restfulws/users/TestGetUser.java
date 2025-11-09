package com.singularix.restfulws.users;
import com.singularix.restfulws.base.BaseTest;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;


public class TestGetUser extends BaseTest {
	@Test
	public void shouldReturn200OKWhenAccessingAllUsers() {
		given().when().get("/users").then().statusCode(200);
	}
	
	@Test
	public void shouldReturnUserDetailsWhenExists() {
		given()
			.contentType(ContentType.JSON)
			//.pathParam("id", 1)
			
		.when()
			.get("/users/1")
			//.get("/users/{id}")
		.then()
			.statusCode(200)
			.body("id", equalTo(1))
			.body("name", notNullValue())
			.body("birthday", notNullValue());
	}
	
	@Test
	public void shouldReturn404WhenUserDoesntExist() {
		given()
			.pathParam("id", 99999)
		.when()
			.get("/users/{id}")
		.then()
			.statusCode(404);
	}
	
}
