package guru.qa.lesson18;

import guru.qa.pages.demoWebShop.DemoWebShopPage;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class demoWebShopApiTests {
    DemoWebShopPage demoWebShopPage = new DemoWebShopPage();

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "http://demowebshop.tricentis.com/";
    }

    @Test
    @DisplayName("Successful authorization")
    @Tag("API")
    public void successfulAuthTest() {
        assertNotNull(demoWebShopPage.getCookie());
    }

    @Test
    @DisplayName("Add item to cart")
    public void checkAddItemToCart() {
        demoWebShopPage.addTopToCartAndCheckSuccessNotification();
        demoWebShopPage.checkrAPIResponsGetCartContainsTop();
    }
}
