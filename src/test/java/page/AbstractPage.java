package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected abstract AbstractPage openPage();
    protected final int WAIT_TIMEOUT_SECONDS = 10;

    protected AbstractPage(WebDriver driver)
    {
        this.driver = driver;
    }

    protected WebElement waitUntilElementPresent(By by) {
        return new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(by));
    }

    protected WebElement waitUntilElementPresent(WebElement webElement) {
        return new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(webElement));
    }





}
