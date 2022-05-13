package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DrinksPage extends BasePage {

    public final static String DRINKS_URL = BASE_URL + "/drinks";

    public DrinksPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public DrinksPage openPage() {
        driver.get(DRINKS_URL);
        return this;
    }
}
