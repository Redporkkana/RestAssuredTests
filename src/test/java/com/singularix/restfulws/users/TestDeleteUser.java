package com.singularix.restfulws.users;
import com.singularix.restfulws.base.BaseTest;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;
import utils.UserDataFactory;
import utils.UserPayload;

import static io.restassured.RestAssured.given;

public class TestDeleteUser extends BaseTest {
	@Test
	public void shouldReturn404ToVerifyUserDeleted() {
		UserPayload user = UserDataFactory.validUser();
		
		int id = given()
					.contentType(ContentType.JSON)
					.body(user)
				.when()
					.post("/users")
				.then()
					.extract().path("id");
		
		given()
			.contentType(ContentType.JSON)
		.when()
			.delete("/users/"+id)
		.then()
			.statusCode(200);
		
		given()
			.contentType(ContentType.JSON)
		.when()
			.get("/users/"+id)
		.then()
			.statusCode(404);
	}	
	
}
