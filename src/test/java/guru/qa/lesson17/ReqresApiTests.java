package guru.qa.lesson17;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;

public class ReqresApiTests {

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @Test
    @DisplayName("Create user")
    public void createUser() {
        String data = "{ \"name\": \"morpheus\", \"job\": \"leader\" }";

        Response response = given()
                .contentType(JSON)
                .body(data)
                .when()
                .post("/api/users")
                .then()
                .statusCode(201)
                .extract().response();
        assertThat(response.statusCode()).isEqualTo(201);
        assertThat(response.path("name").toString()).isEqualTo("morpheus");
        assertThat(response.path("job").toString()).isEqualTo("leader");
    }

    @Test
    @DisplayName("Update user")
    public void updateUser() {
        String data = "{ \"name\": \"morpheus\", \"job\": \"driver\" }";

        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Response response = given()
                .contentType(JSON)
                .body(data)
                .when()
                .patch("/api/users/2")
                .then()
                .extract().response();
        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.path("name").toString()).isEqualTo("morpheus");
        assertThat(response.path("job").toString()).isEqualTo("driver");
        assertThat(response.path("updatedAt").toString()).contains(date);
    }


    @Test
    @DisplayName("Get user")
    public void getUser() {
        String data = "{ \"name\": \"morpheus\", \"job\": \"leader\" }";

        Response response = given()
                .contentType(JSON)
                .body(data)
                .when()
                .get("/api/users/2")
                .then()
                .statusCode(200)
                .extract().response();
        System.out.println(response.asString());
        assertThat(response.path("data.email").toString()).isEqualTo("janet.weaver@reqres.in");
    }

    @Test
    @DisplayName("Delete user")
    public void deleteUser() {
        Response response = given()
                .when()
                .delete("/api/users/2")
                .then()
                .statusCode(204)
                .extract().response();
        assertThat(response.statusCode()).isEqualTo(204);
    }

    @Test
    @DisplayName("Register successful")
    public void registerSuccessful() {
        given()
                .contentType(JSON)
                .body("{\"email\": \"eve.holt@reqres.in\",\"password\": \"pistol\"}")
                .when()
                .post("/api/register")
                .then()
                .statusCode(200)
                .body("id", is(4), "token", is("QpwL5tke4Pnpja7X4"));
    }

    @Test
    @DisplayName("Login successful")
    public void loginSuccessful() {
        given()
                .contentType(JSON)
                .body("{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }")
                .when()
                .post("/api/login")
                .then()
                .statusCode(200)
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }
}
