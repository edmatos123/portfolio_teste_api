package data;


import com.github.javafaker.Faker;

import models.User;

public class FakeUser {
		
	private final Faker fake;
	
	public FakeUser() {
		fake = new Faker();
	}

	public User usuarioValido() {
		
		return new User()
				.email(fake.internet().emailAddress())
				.first_name(fake.name().firstName())
				.last_name(fake.name().lastName())
				.avatar("https://reqres.in/img/faces/"+ fake.avatar().image());
		
	}
	


}
