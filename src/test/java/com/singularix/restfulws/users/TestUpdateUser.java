package com.singularix.restfulws.users;
import com.singularix.restfulws.base.BaseTest;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

import java.util.Map;
import java.util.HashMap;
import java.time.LocalDate;


public class TestUpdateUser extends BaseTest {
	@Test
	public void shouldReturn200ToVerifyUserUpdate() {
		Map<String, Object> userPayload = new HashMap<>();
		userPayload.put("name", "Tom");
		userPayload.put("birthday", LocalDate.now().minusYears(49));
		 
		int id = given()
			.contentType(ContentType.JSON)
			.body(userPayload)
		.when()
			.post("/users")
		.then()
			.extract().path("id");
		
		userPayload.put("name", "Thomas");
		userPayload.put("birthday", LocalDate.now().minusYears(49));
		
		given()
			.contentType(ContentType.JSON).body(userPayload)
		.when()
			.put("/users/"+id)
		.then()
			.statusCode(200);
		
	}
	
}
