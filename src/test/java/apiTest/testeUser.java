// Nome do Pacote
package apiTest;

// Bibliotecas
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

// Classe

public class testeUser {
// Atributos
static String ct = "application/Json";                         // Content Type
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
@Test
public void testarLogin(){
        String username = "axel";
        String password = "alex1975";

         Response response = (Response) given()
                .contentType(ct)
                .log().all()
        .when()
                .get(uriUser + "login?username=" + username +"&password=" + password)
        .then()
                 .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", containsString("logged in user session:"))
                .body("message", hasLength(36))
                .extract()
        ;
// Extração do Token da resposta
    String token = response.jsonPath().getString("message").substring(23);
    System.out.println("Conteúdo do Token: " + token )
        ;
    }

    @ParameterizedTest
    @CsvFileSource(resources = "csv/massaUser.csv", numLinesToSkip = 1, delimiter = ',')
public void testarIncluirUserCsv(
        String id,
        String username,
        String firstName,
        String lastName,
        String email,
        String password,
        String phone,
        String userStatus) {                             //Inio Incluir CSV
/*
        StringBuilder jsonBody = new StringBuilder("{");
        jsonBody.append("'id':" + id + ",");
                jsonBody.append("'username´: " + username + ",");
                jsonBody.append("'firstName': " + firstName + ",");
                jsonBody.append("'lastName': " + lastName + ",");
                jsonBody.append("'email': " + email + ",");
                jsonBody.append("'password': " + password + ",");
                jsonBody.append("'phone': " + phone + ",");
                jsonBody.append("'userStatus' " + userStatus);
                jsonBody.append("}");
*/
        User user = new User(); // Instancía a Classe User
        user.id = id;
        user.username = username;
        user.firstname = firstName;
        user.lastname = lastName;
        user.email = email;
        user.password = password;
        user.phone = phone;
        user.userStatus = userStatus;

        Gson gson = new Gson(); // Instancía a Classe Gson
        String jsonBody = gson.toJson(user);



// Realizar o Teste
        given()                                                       // Dado que
                .contentType(ct)                            // o tipo do conteúdo
                .log().all()                                       // mostre tudo
                .body(jsonBody)                            // corpo da requisição
        .when()                                                         // Quando
                .post("https://petstore.swagger.io/v2/user")  // Endpoint/ Onde
        .then()                                                           // Então
                .log().all()                             // mostre tudo no retorno
                .statusCode(200)                    // Comunicação - ida e volta
                .body("code", is(200))                   // Tag Code é 200
                .body("type", is("unknown"))         // Tag type é unknowm
                .body("message", is(id))
        ;
    }

}                                                             // Fim da Classe