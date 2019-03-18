package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

public class MainCloudPage extends AbstractPage {

    private final String BASE_URL = "https://cloud.google.com/";

    @FindBy(xpath = "//a[@track-name='exploreProducts']")
    private WebElement exploreAllProductsButton;


    public MainCloudPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    public ProductsPage pushExploreAllProducts(){

        exploreAllProductsButton.click();
        return new ProductsPage(driver);
    }

    @Override
    public MainCloudPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;

    }
}
