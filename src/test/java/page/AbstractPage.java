package page;



import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class AbstractPage {
    protected WebDriver driver;
    protected final int WAIT_TIMEOUT_SECONDS = 10;
    protected abstract AbstractPage openPage();


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
    protected void highlightElement(WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='5px solid green'", webElement);
    }

    protected void unHighlightElement(WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='0px'", webElement);
    }


}


