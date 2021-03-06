package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.BasePage;
import pageobjects.CartPage;

public class BaseTest extends AbstractTest {

    @Test
    public void testAdditionProductsToCart(){
        String pizzaName = "Маргарита";
        String drinkName = "Кока-Кола 1 л";
        CartPage homePage = new BasePage(driver).openPageAndAcceptAllCookies()
                .clickButtonCloseBanner()
                .clickButtonPizza()
                .findProductByNameAndAddToCart(pizzaName)
                .clickButtonDrinks()
                .findProductByNameAndAddToCart(drinkName)
                .clickButtonCart();

        Assertions.assertTrue(homePage.isProductInCart(pizzaName));
        Assertions.assertTrue(homePage.isProductInCart(drinkName));
    }
}
