package dados;


import com.github.javafaker.Faker;


import modelo.Usuario;

public class UsuarioFalso {
		
	private final Faker fake;
	
	public UsuarioFalso() {
		fake = new Faker();
	}

	public Usuario usuarioValido() {
		
		return new Usuario()
				.email(fake.internet().emailAddress())
				.first_name(fake.name().firstName())
				.last_name(fake.name().lastName())
				.avatar("https://reqres.in/img/faces/"+ fake.avatar().image());
		
	}
	


}
