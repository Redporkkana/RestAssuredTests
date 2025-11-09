package com.singularix.restfulws.users;
import com.singularix.restfulws.base.BaseTest;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;
import utils.UserDataFactory;
import utils.UserPayload;

import static io.restassured.RestAssured.given;

public class TestCreateUser extends BaseTest {
	@Test
	public void shouldReturn201AndValidBody() {
	
		UserPayload user = UserDataFactory.validUser();
		
		given()
			.contentType(ContentType.JSON)
			.body(user)
		.when()
			.post("/users")
		.then()
			.statusCode(201)
			.log().all();
	}
	
}
