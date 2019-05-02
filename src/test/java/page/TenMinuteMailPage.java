package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class TenMinuteMailPage extends AbstractPage {
    private final String BASE_URL = "https://10minutemail.net";
    private final Logger logger = LogManager.getRootLogger();
    private Actions actions = new Actions(driver);
    public TenMinuteMailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//*[@id='fe_text']")
    protected  WebElement emailFromTenMinute;
    @FindBy(xpath = "//*[text()='Google Cloud Platform Price Estimate']")
    protected WebElement tenMinuteMail;
    @FindBy(xpath = "//h3[text()[contains(.,'USD')]]")
    protected WebElement mailTotalEstCost;

    public  String getemailFromTenMinute() {
          return emailFromTenMinute.getAttribute("value");
    }

    public String readTotalEstimateCostFromTenMinute() {
        logger.info("Wait for GoogleEmail");
        try {
            TimeUnit.SECONDS.sleep(60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        actions.moveToElement(tenMinuteMail);
        tenMinuteMail.click();
        String mailTotalEstimateCostFromTenMinuteEmail = mailTotalEstCost.getText();
        logger.info("Email from GoogleCloud with Total Coast is checked"+mailTotalEstimateCostFromTenMinuteEmail);
        return mailTotalEstimateCostFromTenMinuteEmail;
    }
    @Override
    public TenMinuteMailPage openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("TenMinuteMailPage opened");
        return new TenMinuteMailPage(driver);
    }
}
