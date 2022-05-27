package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isProductInCart(String productName){
        String productsInCartSelector = "div.cart-button__mini-bag div.product-card__title";
        List<String> productsInCartNames = driver.findElements(By.cssSelector(productsInCartSelector)).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        logger.info(productsInCartNames.toString());
        return productsInCartNames.stream().anyMatch(s -> s.contains(productName));
    }
}
