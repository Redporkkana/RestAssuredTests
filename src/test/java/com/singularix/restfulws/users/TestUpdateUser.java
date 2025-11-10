package com.singularix.restfulws.users;
import com.singularix.restfulws.base.BaseTest;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.UserDataFactory;
import utils.UserPayload;

import io.restassured.response.Response;

import java.time.LocalDate;


public class TestUpdateUser extends BaseTest {
	@Test
	@Tag("regression")
	public void shouldReturn200ToVerifyUserUpdate() {
		
		UserPayload user = UserDataFactory.validUser();
		Response response1 = requestSpec
				.contentType(ContentType.JSON)
				.body(user)
				.post("/users");
		
		int id = response1.then().extract().path("id");
		
		user.setName("Thomas");
		user.setBirthday(LocalDate.now().minusMonths(1000));
		
		Response response2 = requestSpec 
				.contentType(ContentType.JSON)
				.body(user)		
				.put("/users/"+id);
		response2.then()
			.statusCode(200);
		
	}
	
}
