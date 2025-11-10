package com.singularix.restfulws.users;
import com.singularix.restfulws.base.BaseTest;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;
import utils.UserDataFactory;
import utils.UserPayload;

import io.restassured.response.Response;

public class TestDeleteUser extends BaseTest {
	@Test
	@Tag("regression")
	public void shouldReturn404ToVerifyUserDeleted() {
		UserPayload user = UserDataFactory.validUser();
		Response response1 = requestSpec
				.contentType(ContentType.JSON)
				.body(user)
				.post("/users");
				
		int id = response1	
				.then()
					.extract().path("id");
		
		Response response2 = requestSpec
			.delete("/users/"+id);
		
		response2.then()
			.statusCode(200);
		
		Response response3 = requestSpec
			.get("/users/"+id);
		response3.then()
			.statusCode(404);
	}	
	
}
