package services;

import static io.restassured.RestAssured.given;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import endpoints.Endpoints;
import io.restassured.specification.RequestSpecification;
import models.UserResponse;
import models.User;

import static org.apache.http.HttpStatus.*;


public class UserService {
	
	private final RequestSpecification spec;
	
	public UserService (RequestSpecification spec) {
		this.spec = spec;
		
	}	
	
	public User obterUsuarioId(String id) {		
		return given().
				spec(spec).    
		    	pathParam("id", id).
		    	when().
		    	get(Endpoints.USER_ID).
		    	then().		    	
		    	statusCode(SC_OK).
		    	extract().jsonPath().getObject("data",User.class);				
		
		
	}
	
	
	public List<User> obterUsuariosPagina(String pag){
		UserResponse usuarios = new UserResponse();
		                                  
		usuarios = given().
		queryParam("page", pag).
		spec(spec). 
			when(). 
			get(Endpoints.USERS).
				then().				
				statusCode(SC_OK).
				extract().				
				as(UserResponse.class);
		
		
		return usuarios.getData();			
		
	}
	
	public void consultarIdInexistente(String id) {		
		given().
				spec(spec).    
		    	pathParam("id", id).
		    	when().
		    	get(Endpoints.USER_ID).
		    	then().
		    	statusCode(SC_NOT_FOUND);				
		
		
	}
	
	
	
	public void cadastrarUsuario(User usr) {
		
		given().
		spec(spec). 
		body(usr).
			when().
			post(Endpoints.USERS).
			 	then().
			 	statusCode(SC_CREATED);
		
		
	}
	
	public void alterarUsuario(User usr,String nomeNovo) {
		
		usr.setFirst_name(nomeNovo);
		
		given().
		spec(spec). 
		pathParam("id", usr.getId()).
		body(usr).		
			when().
			put(Endpoints.USER_ID).
			then().
			statusCode(SC_OK);
		
		
		
		
	}
	
	
	public void deletarUsuario(User usr) {
						
		given().
		spec(spec). 
		pathParam("id", usr.getId()).
		body(usr).		
			when().
			delete(Endpoints.USER_ID).
			then().
			statusCode(SC_NO_CONTENT);
		
		
		
		
	}
	
	
	public User obterUsuario() {
		UserResponse usrDados =		
				given().
				spec(spec). 
				when().
				get(Endpoints.USERS).
				then().
				statusCode(SC_OK).
				extract().
				as(UserResponse.class);						
		
		List<User> usr = usrDados.getData();
		
		
		return  usr.get(ThreadLocalRandom.current().nextInt(usr.size()));
		
		
	}
	

}
