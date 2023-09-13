// Nome do Pacote
package apiTest;

// Bibliotecas
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

// Classe

public class testeUser {
// Atributos
static String ct = "application/Json";                            // Content Type
static String uriUser = "https://petstore.swagger.io/v2/user/";
// Funções e Métodos
// Funções de Apoio
    public static String lerArquivoJson(String arquivoJson) throws IOException {
       return new String(Files.readAllBytes(Paths.get(arquivoJson)));

    }

@Test
    public void testarIncluirUser() throws IOException {
// Carregar os Dados do Json
    String jsonBody = lerArquivoJson("src/test/resources/json/user1.json");
    String userId = "1372633669";

// Realizar o Ieste
    given()                                                        // Dado que
            .contentType(ct)           // o tipo do conteúdo
            .log().all()                                        // mostre tudo
            .body(jsonBody)                             // corpo da requisição
    .when()                                                          // Quando
            .post("https://petstore.swagger.io/v2/user")  // Endpoint/ Onde
    .then()                                                           // Então
            .log().all()                             // mostre tudo no retorno
            .statusCode(200)                    // Comunicação - ida e volta
            .body("code", is(200))                   // Tag Code é 200
            .body("type", is("unknown"))         // Tag type é unknowm
            .body("message", is(userId))
    ;
    }                                                           // Fim do Post
    @Test
    public void testarConsultarUser(){
        String username = "axel";
        int userId = 1372633669;                         // Código do usuário
        String email = "axel@test.com";
        String senha = "alex1975";
        String telefone = "989134557";
    given()
            .contentType(ct).log().all()
    .when()
            .get(uriUser + username)
    .then()
            .log().all()
            .statusCode(200)
            .body("id", is(userId))
            .body("email", is(email))
            .body("password", is(senha))
            .body("phone", is(telefone))
        ;
    }                                                       //Fim do Get User
    @Test
    public void testarAlterarUser() throws IOException {// Inicio do Put User
        String jsonBody = lerArquivoJson("src/test/resources/json/user2.json");
        String userId = "1372633669";
        String username = "axel";

        given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)
        .when()
                .put(uriUser + username)
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is(userId))
        ;
    }                                                       // Fim da Put User

@Test
public void testarExcluirUser(){
        String username = "axel";
        given()
                .contentType(ct)
                .log().all()
        .when()
                .delete(uriUser + username)
        .then()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is(username))
        ;
}

}                                                             // Fim da Classe