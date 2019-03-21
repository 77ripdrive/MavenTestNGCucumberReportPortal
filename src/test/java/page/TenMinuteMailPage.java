package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TenMinuteMailPage extends AbstractPage {
    public final String BASE_URL = "https://10minutemail.com";
    private final Logger logger = LogManager.getRootLogger();

    public TenMinuteMailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//*[@id='mailAddress']")
    public WebElement emailFromTenMinute;
    @FindBy(xpath = "//*[@id='ui-id-1']/span[2]")
    public WebElement tenMinuteMail;
    @FindBy(xpath = ".//table[@class='quote']/tbody/tr[2]/td[2]/h3")
    public WebElement mailTotalEstCost;

    public  String getemailFromTenMinute() {
        String emailFromTenMinuteMail = emailFromTenMinute.getAttribute("value");
    return emailFromTenMinuteMail;
    }

    public String readTotalEstimateCostFromTenMinute() {
        new WebDriverWait(driver,60)
                .until(ExpectedConditions.visibilityOf(tenMinuteMail));
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        tenMinuteMail.click();
        String mailTotalEstimateCostFromTenMinuteEmail = mailTotalEstCost.getText();
        logger.info("Email from GoogleCloud with Total Coast");
        return mailTotalEstimateCostFromTenMinuteEmail;
    }
    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("TenMinuteMailPage opened");
    }
}
