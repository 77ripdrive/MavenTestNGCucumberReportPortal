package page;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reporting.MyLogger;

public class PricingPage extends AbstractPage {

    private final String BASE_URL = "https://cloud.google.com/pricing/";
    Actions actions = new Actions(driver);

    @FindBy(xpath = "//*[@id='cloud-site']//a[@href='https://cloud.google.com/products/calculator/']")
    public WebElement pricingNavigationCalculators;


    public CalculatorPage pushPricingNavigationCalculators(){
        MyLogger.info("Pricing page opened"+BASE_URL);
        actions.moveToElement(pricingNavigationCalculators);
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(pricingNavigationCalculators));

        pricingNavigationCalculators.click();
        return new CalculatorPage(driver);
    }

    public PricingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public PricingPage openPage() {
        driver.navigate().to(BASE_URL);
        return new PricingPage(driver);

    }
}
