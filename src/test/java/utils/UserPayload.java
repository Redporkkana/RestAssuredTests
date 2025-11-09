package utils;

import java.time.LocalDate;
import java.util.Arrays;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;

public class UserPayload {
	private String name;
	@Past
	private LocalDate birthday;
	@Email
	private String email;
	private char[] password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(char[] password) {
	    this.password = Arrays.copyOf(password, password.length);
	}

	public char[] getPassword() {
	    return Arrays.copyOf(password, password.length);
	}
}
