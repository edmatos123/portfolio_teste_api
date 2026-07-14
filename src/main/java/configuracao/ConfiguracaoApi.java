package configuracao;

import org.junit.jupiter.api.BeforeAll;
import dados.UsuarioFalso;
import static io.restassured.RestAssured.*;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import servicos.UsuarioServico;
import io.restassured.http.ContentType;
import io.restassured.filter.log.LogDetail;

public class ConfiguracaoApi {
    protected static UsuarioFalso usuarioTeste ;
    protected static UsuarioServico servUsuario; 
    public static RequestSpecification requisicaoPadrao;
	
	@BeforeAll 
    public static void conectarApi() {
        // Configuração do ENDPOINT
        baseURI = "https://reqres.in/api";
        
        // Permissão para efetuar requisição com relaxamento do SSL
       useRelaxedHTTPSValidation();
        
       //Inicialização da classes
       usuarioTeste = new UsuarioFalso();
       
       
       requisicaoPadrao = new RequestSpecBuilder()
    		   					.setContentType(ContentType.JSON)
    		    				.addHeader("x-api-key","reqres_24291cb04e394593910de8b21f2c5f38")
    		    				.addFilter(new AllureRestAssured())   		    				
    		    				.log(LogDetail.ALL)
    		    				.build();
       
       //Inicializar Serviço
       servUsuario = new UsuarioServico(requisicaoPadrao);
       
    }
}