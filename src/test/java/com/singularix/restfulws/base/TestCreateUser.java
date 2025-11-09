package com.singularix.restfulws.base;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

import java.util.Map;
import java.util.HashMap;
import java.time.LocalDate;


public class TestCreateUser extends BaseTest {
	@Test
	public void shouldReturn201AndValidBody() {
		Map<String, Object> userPayload = new HashMap<>();
		
		userPayload.put("name", "Ben");
		userPayload.put("birthday", LocalDate.now().minusYears(50));
		
		given()
			.contentType(ContentType.JSON)
			.body(userPayload)
		.when()
			.post("/users")
		.then()
			.statusCode(201)
			.log().all();
		
	}
	
}
