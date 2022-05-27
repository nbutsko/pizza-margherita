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

public class BasePage extends AbstractPage {

    @FindBy(xpath = "//div[@class='cart-button']/button")
    private WebElement buttonCart;

    @FindBy(xpath = "//ul[@class='horizontal-menu__list']//a[@href='/pizza']")
    private WebElement buttonPizza;

    @FindBy(xpath = "//ul[@class='horizontal-menu__list']//a[@href='/drinks']")
    private WebElement buttonDrinks;

    public BasePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HomePage openPageAndAcceptAllCookies() {
        driver.get(BASE_URL);
        driver.manage().window().maximize();
        driver.manage().getCookies();
        return new HomePage(driver);
    }

    public PizzaPage clickButtonPizza() {
        buttonPizza.click();
        return new PizzaPage(driver);
    }

    public DrinksPage clickButtonDrinks() {
        buttonDrinks.click();
        return new DrinksPage(driver);
    }

    public CartPage clickButtonCart() {
        buttonCart.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='cart-button__mini-bag-actions cart-button__mini-bag-actions--bottom']")));
        return new CartPage(driver);
    }

    public BasePage findProductByNameAndAddToCart(String productName) {
        List<WebElement> listOfProducts = driver.findElements(By.className("product-card--vertical"));
        for (WebElement product : listOfProducts) {
            String productTitle = product.findElement(By.className("product-card__title")).getText();
            if (productTitle.contains(productName)) {
                logger.info("Product added to card " + productTitle);
                By buttonAddToCardXPath = By.cssSelector("div.product-card__actions>button");
                product.findElement(buttonAddToCardXPath).click();
                System.out.println("product " + productTitle);
            }
        }
        return this;
    }
}
