package utils;

import java.util.UUID;

public class UserDataFactory {
	public static UserPayload validUser() {
		UserPayload user = new UserPayload();
		String randomID = UUID.randomUUID().toString();
		user.setName("TestUser_"+randomID);
		user.setEmail(randomID+"@example.com");
		char[] password = {'S', 't', 'r', 'o', 'n', 'g', '1', '2','3','!'};
		user.setPassword(password);
		return user;
	}
	
	public static UserPayload missingEmail() {
		UserPayload user = validUser();
		user.setEmail(null);
		return user;
	}
}
