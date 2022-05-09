package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends AbstractPage {

    private WebDriver driver;

    @FindBy(xpath = "//img[@class='popup-banner__image']/preceding-sibling::button[contains(@class,'modal__close')]")
    private WebElement buttonCloseBanner;

    @FindBy(xpath = "//div[@class='cart-button']/button")
    private WebElement buttonCart;

    @FindBy(xpath = "//ul[@class='horizontal-menu__list']//a[@href='/pizza']")
    private WebElement buttonPizza;

    @FindBy(xpath = "//ul[@class='horizontal-menu__list']//a[@href='/drinks']")
    private WebElement buttonDrinks;

    public HomePage(WebDriver driver) {
        this.driver = driver;
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

    public HomePage clickButtonPizza(){
        buttonPizza.click();
        return this;
    }

    public HomePage clickButtonDrinks(){
        buttonDrinks.click();
        return this;
    }

    public HomePage clickButtonCart(){
        buttonCart.click();
        return this;
    }

    public HomePage findProductByNameAndAddToCart(String productName) {
        String productXPath = String.format("//*[text()='%s']/parent::div//div[@class='product-card__actions']/button", productName);
        By selectedProduct = By.xpath(productXPath);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(selectedProduct));
        driver.findElement(selectedProduct).click();
        return this;
    }

    public boolean isProductInCart(String productName){
        String productsInCartLocator = "//div[@class='cart-button__mini-bag']//div[@class='product-card__title']";
        List<String> productsInCartNames = driver.findElements(By.xpath(productsInCartLocator)).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        return productsInCartNames.contains(productName);
    }
}
