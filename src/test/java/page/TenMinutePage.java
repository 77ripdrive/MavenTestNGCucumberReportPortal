package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TenMinutePage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://10minutemail.com";



    @FindBy (xpath ="//*[@id='mailAddress']")
    private WebElement emailFromTenMinute;

    @FindBy (xpath ="//*[@id='ui-id-1']/span[2]")
    private WebElement tenMinuteMail;

    @FindBy (xpath =".//table[@class='quote']/tbody/tr[2]/td[2]/h3")
    private WebElement mailTotalEstCost;



    protected TenMinutePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);

    }

    @Override
    protected TenMinutePage openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Products page opened");
        return this;
    }
}
