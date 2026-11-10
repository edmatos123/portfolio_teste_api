package config;

import static io.restassured.RestAssured.*;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;
import io.restassured.filter.log.LogDetail;

public class ApiConfig {

	

    public static RequestSpecification conectarApi(String URI) {
        
        // Permissão para efetuar requisição com relaxamento do SSL
       useRelaxedHTTPSValidation();
        
       return new RequestSpecBuilder()
			.setContentType(ContentType.JSON)
			.setBaseUri(URI)    		    				
		.addFilter(new AllureRestAssured())   		    				
		.log(LogDetail.ALL)
		.build();
       
          
      
    }
}