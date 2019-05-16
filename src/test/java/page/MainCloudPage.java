package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import reporting.MyLogger;


public class MainCloudPage extends AbstractPage {

    Actions actions = new Actions(driver);
    public final String BASE_URL = "https://cloud.google.com";


    @FindBy(xpath = "//a[@track-name='seeProducts']")
    private WebElement exploreAllProductsButton;


    @FindBy(xpath = "//*[@alt='Roche logo']")
    private WebElement logoRoche;

    public boolean isLogoRocheExist(){
        highlightElement(logoRoche);

        return logoRoche.isDisplayed();
    }


    public MainCloudPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    public ProductsPage pushExploreAllProducts(){
        actions.moveToElement(exploreAllProductsButton);
        highlightElement(exploreAllProductsButton);
        waitUntilElementPresent(exploreAllProductsButton).click();
                return new ProductsPage(driver);
    }

    @Override
    public MainCloudPage openPage() {
        driver.get(BASE_URL);
        MyLogger.info("MainCloudPage opened"+BASE_URL);
        return  new MainCloudPage(driver);
    }
}
