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
        String productsInCartLocator = "//div[@class='cart-button__mini-bag']//div[@class='product-card__title']";
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(productsInCartLocator)));
        List<String> productsInCartNames = driver.findElements(By.xpath(productsInCartLocator)).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        logger.info(productsInCartNames.toString());
        return productsInCartNames.contains(productName);
    }
}
