package guru.qa.pages.demoWebShop;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import guru.qa.ApiSteps;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DemoWebShopPage {
    ApiSteps apiSteps = new ApiSteps();

    SelenideElement addToCartButton = $("input#add-to-cart-button-5"),
            successNotification = $("#bar-notification");

    @Step("Successful authorization")
    public DemoWebShopPage getCookie() {
        apiSteps.getCookie();

        return this;
    }

    @Step("Add top to cart")
    public void addTopToCartAndCheckSuccessNotification() {
        open("http://demowebshop.tricentis.com/50s-rockabilly-polka-dot-top-jr-plus-size");
        getWebDriver().manage().addCookie(
                new Cookie("NOPCOMMERCE.AUTH", getCookie().toString()));
        addToCartButton.click();
        successNotification.shouldBe(Condition.enabled);
    }

    @Step("API response. Cart contains added top")
    public void checkrAPIResponsGetCartContainsTop() {
        assertTrue(apiSteps.getProductFromCart().contains("Polka Dot Top JR Plus Size"), "Cart does not contains added top");
    }
}