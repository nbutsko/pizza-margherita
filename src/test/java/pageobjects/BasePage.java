package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage extends AbstractPage{

    @FindBy(xpath = "//div[@class='cart-button']/button")
    private WebElement buttonCart;

    @FindBy(xpath = "//ul[@class='horizontal-menu__list']//a[@href='/pizza']")
    private WebElement buttonPizza;

    @FindBy(xpath = "//ul[@class='horizontal-menu__list']//a[@href='/drinks']")
    private WebElement buttonDrinks;

    /*@FindBy(className = "product-card product-card--vertical")
    private WebElement productCard;*/

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

    public PizzaPage clickButtonPizza(){
        buttonPizza.click();
        return new PizzaPage(driver);
    }

    public DrinksPage clickButtonDrinks(){
        buttonDrinks.click();
        return new DrinksPage(driver);
    }

    public CartPage clickButtonCart(){
        buttonCart.click();
        return new CartPage(driver);
    }

    public BasePage findProductByNameAndAddToCart(String pizzaName) {
        //List<WebElement> listOfPizzas = driver.findElements(By.className("product-card product-card--vertical"));
        //String selectedPizzaXPath = String.format("//div[@class='product-card__title'][contains(text(),'%s')]", pizzaName);
        String productXPath = String.format("//*[text()='%s']/parent::div//div[@class='product-card__actions']/button", pizzaName);
        By selectedProduct = By.xpath(productXPath);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(selectedProduct));
        driver.findElement(selectedProduct).click();
        return this;
    }
}
