package config;

import endpoints.Endpoints;
import io.restassured.specification.RequestSpecification;

//Obs.: Pensar na possibilide de passar os valor configuraveis pelo properties
public class RequestConfig {
	// private static final String BASE_URI ="https://reqres.in/api";
	
public static RequestSpecification configurarRegrs(){
	
	return ApiConfig.conectarApi(Endpoints.REGRS)
				.header("x-api-key","reqres_24291cb04e394593910de8b21f2c5f38");		
	
}
	
	
}
