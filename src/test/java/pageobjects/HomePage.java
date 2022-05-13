package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(xpath = "//img[@class='popup-banner__image']/preceding-sibling::button[contains(@class,'modal__close')]")
    private WebElement buttonCloseBanner;

    @FindBy(xpath = "//div[@class='cart-button']/button")
    private WebElement buttonCart;

    @FindBy(xpath = "//ul[@class='horizontal-menu__list']//a[@href='/pizza']")
    private WebElement buttonPizza;

    @FindBy(xpath = "//ul[@class='horizontal-menu__list']//a[@href='/drinks']")
    private WebElement buttonDrinks;

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

    /*public HomePage findProductByNameAndAddToCart(String productName) {
        String productXPath = String.format("//*[text()='%s']/parent::div//div[@class='product-card__actions']/button", productName);
        By selectedProduct = By.xpath(productXPath);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(selectedProduct));
        driver.findElement(selectedProduct).click();
        return this;
    }*/
}
