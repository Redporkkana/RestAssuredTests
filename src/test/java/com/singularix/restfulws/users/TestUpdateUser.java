package com.singularix.restfulws.users;
import com.singularix.restfulws.base.BaseTest;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;
import utils.UserDataFactory;
import utils.UserPayload;

import static io.restassured.RestAssured.given;

import java.time.LocalDate;


public class TestUpdateUser extends BaseTest {
	@Test
	@Tag("regression")
	public void shouldReturn200ToVerifyUserUpdate() {
		UserPayload user = UserDataFactory.validUser();
		
		int id = given()
			.contentType(ContentType.JSON)
			.body(user)
		.when()
			.post("/users")
		.then()
			.extract().path("id");
		
		user.setName("Thomas");
		user.setBirthday(LocalDate.now().minusMonths(1000));
		
		given()
			.contentType(ContentType.JSON).body(user)
		.when()
			.put("/users/"+id)
		.then()
			.statusCode(200);
		
	}
	
}
