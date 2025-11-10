package com.singularix.restfulws.users;
import com.singularix.restfulws.base.BaseTest;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;
import utils.UserDataFactory;
import utils.UserPayload;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class TestCreateUser extends BaseTest {
	@Test
	public void shouldReturn201AndValidBody() {
	
		UserPayload user = UserDataFactory.validUser();
		Response response = requestSpec
		
			.contentType(ContentType.JSON)
			.body(user)
			.post("/users");
		response.then()
			.statusCode(201)
			.log().all();
	}
	
}
