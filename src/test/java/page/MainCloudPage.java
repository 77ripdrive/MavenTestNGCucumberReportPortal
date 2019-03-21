package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainCloudPage extends AbstractPage {
    Actions actions = new Actions(driver);
    public final String BASE_URL = "https://cloud.google.com/";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//a[@track-name='exploreProducts']")
    public WebElement exploreAllProductsButton;

    public MainCloudPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    public ProductsPage pushExploreAllProducts(){
        actions.moveToElement(exploreAllProductsButton);
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(exploreAllProductsButton));
        exploreAllProductsButton.click();
        return new ProductsPage(driver);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("MainCloudPage opened");
    }
}
