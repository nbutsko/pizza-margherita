package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(xpath = "//img[@class='popup-banner__image']/preceding-sibling::button[contains(@class,'modal__close')]")
    private WebElement buttonCloseBanner;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HomePage openPageAndAcceptAllCookies() {
        driver.get(BASE_URL);
        driver.manage().window().maximize();
        driver.manage().getCookies();
        return this;
    }

    public HomePage clickButtonCloseBanner(){
        buttonCloseBanner.click();
        return this;
    }
}
