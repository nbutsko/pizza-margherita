package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

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
