package page;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reporting.MyLogger;

import java.util.concurrent.TimeUnit;

public class TenMinuteMailPage extends AbstractPage {

    protected final int WAIT_TIMEOUT_SECONDS_FOR_MAIL= 45;
    private final String BASE_URL = "https://10minutemail.net";

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
        MyLogger.info("Wait for GoogleEmail");

        try {
            TimeUnit.SECONDS.sleep(WAIT_TIMEOUT_SECONDS_FOR_MAIL);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        actions.moveToElement(tenMinuteMail);
        tenMinuteMail.click();
        String mailTotalEstimateCostFromTenMinuteEmail = mailTotalEstCost.getText();
        MyLogger.info("Email from GoogleCloud with Total Coast is checked " + mailTotalEstimateCostFromTenMinuteEmail);
        return mailTotalEstimateCostFromTenMinuteEmail;
    }
    @Override
    public TenMinuteMailPage openPage() {
        driver.navigate().to(BASE_URL);
        MyLogger.info("TenMinuteMailPage opened" + BASE_URL);
        return new TenMinuteMailPage(driver);
    }
}
