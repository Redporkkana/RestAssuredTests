package com.singularix.restfulws.users;
import com.singularix.restfulws.base.BaseTest;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;

public class TestDeleteUser extends BaseTest {
	@Test
	public void shouldReturn404ToVerifyUserDeleted() {
		Map <String, Object> user = new HashMap<>();
		
		user.put("name", "Leo");
		user.put("birthday", LocalDate.now().minusYears(27));
		
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
