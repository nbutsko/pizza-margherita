package pageobjects;

import org.openqa.selenium.WebDriver;

public class AbstractPage {

    protected WebDriver driver;

    public final static String BASE_URL = "https://dominos.by/";
    public final static int WAIT_TIMEOUT_SECONDS = 10;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }
}
