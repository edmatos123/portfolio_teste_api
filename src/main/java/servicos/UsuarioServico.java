package servicos;

import static io.restassured.RestAssured.given;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import io.restassured.specification.RequestSpecification;
import modelo.RespostaUsuarios;
import modelo.Usuario;
import static org.apache.http.HttpStatus.*;


public class UsuarioServico {
	
	private final RequestSpecification spec;
	
	public UsuarioServico (RequestSpecification spec) {
		this.spec = spec;
		
	}
	
	
	public Usuario obterUsuarioId(String id) {		
		return given().
				spec(spec).    
		    	pathParam("id", id).
		    	when().
		    	get("/users/{id}").
		    	then().		    	
		    	statusCode(SC_OK).
		    	extract().jsonPath().getObject("data",Usuario.class);				
		
		
	}
	
	
	public List<Usuario> obterUsuariosPagina(String pag){
		RespostaUsuarios usuarios = new RespostaUsuarios();
		                                  
		usuarios = given().
		queryParam("page", pag).
		spec(spec). 
			when(). 
			get("/users/").
				then().				
				statusCode(SC_OK).
				extract().				
				as(RespostaUsuarios.class);
		
		
		return usuarios.getData();			
		
	}
	
	public void consultarIdInexistente(String id) {		
		given().
				spec(spec).    
		    	pathParam("id", id).
		    	when().
		    	get("/users/{id}").
		    	then().
		    	statusCode(SC_NOT_FOUND);				
		
		
	}
	
	
	
	public void cadastrarUsuario(Usuario usr) {
		
		given().
		spec(spec). 
		body(usr).
			when().
			post("/users").
			 	then().
			 	statusCode(SC_CREATED);
		
		
	}
	
	public void alterarUsuario(Usuario usr,String nomeNovo) {
		
		usr.setFirst_name(nomeNovo);
		
		given().
		spec(spec). 
		pathParam("id", usr.getId()).
		body(usr).		
			when().
			put("/users/{id}").
			then().
			statusCode(SC_OK);
		
		
		
		
	}
	
	
	public void deletarUsuario(Usuario usr) {
						
		given().
		spec(spec). 
		pathParam("id", usr.getId()).
		body(usr).		
			when().
			delete("/users/{id}").
			then().
			statusCode(SC_NO_CONTENT);
		
		
		
		
	}
	
	
	public Usuario obterUsuario() {
		RespostaUsuarios usrDados =		
				given().
				spec(spec). 
				when().
				get("/users/").
				then().
				statusCode(SC_OK).
				extract().
				as(RespostaUsuarios.class);						
		
		List<Usuario> usr = usrDados.getData();
		
		
		return  usr.get(ThreadLocalRandom.current().nextInt(usr.size()));
		
		
	}
	

}
