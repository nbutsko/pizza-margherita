package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PizzaPage extends BasePage {

    public final static String PIZZA_URL = BASE_URL + "/pizza";


    public PizzaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public PizzaPage openPage() {
        driver.get(PIZZA_URL);
        return this;
    }

}
