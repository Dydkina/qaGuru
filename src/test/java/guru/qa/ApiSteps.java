package guru.qa;

import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;

public class ApiSteps {

    private String cookie;

    private String authCookie() {
        return cookie =given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("Email", "qaguru@qa.guru")
                .formParam("Password", "qaguru@qa.guru1")
                .when()
                .post("/login")
                .then()
                .statusCode(302)
                .extract()
                .cookie("NOPCOMMERCE.AUTH");
    }

    @Step("Get cookie")
    public String getCookie() {
        return authCookie();
    }

    @Step("Get product from cart")
    public String getProductFromCart() {
        String response =given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie("Nop.customer=4818447f-937f-4840-85ba-1546b77928cb;")
                .when()
                .get("/cart")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .getBody().asString();

        return response;
    }
}