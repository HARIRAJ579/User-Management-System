package com.Zylentrix.Model;
import org.springframework.stereotype.Component;
import jakarta.validation.constraints.*;

@Component
public class User {
	private int uId;
	@NotNull(message = "Name cannot be null")
	@Size(min = 2, max = 10, message = "Name must be between 2 and 10 characters")
	private String name;
	@Email(message = "Invalid email format")
	private String email;
	private int age;

	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
