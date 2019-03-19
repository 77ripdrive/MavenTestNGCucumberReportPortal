package test;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import page.CalculatorPage;
import page.MainCloudPage;
import page.PricingPage;
import page.ProductsPage;
import util.TestListener;

@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver driver;
    protected MainCloudPage mainCloudPage;
    protected ProductsPage productsPage;
    protected PricingPage pricingPage;
    protected CalculatorPage calculatorPage;
    protected String startUrl = "https://cloud.google.com";
    @BeforeTest()
    public void setUp()
    {   driver = DriverSingleton.getDriver();
        mainCloudPage=new MainCloudPage(driver);
        productsPage=new ProductsPage(driver);
        pricingPage=new PricingPage(driver);
        calculatorPage=new CalculatorPage(driver);
        driver.get(startUrl);
        mainCloudPage.openPage();
        mainCloudPage.pushExploreAllProducts();
        productsPage.openPage();
        productsPage.pushSeePrising();
        pricingPage.openPage();
        pricingPage.pushPricingNavigationCalculators();
        calculatorPage.openPage();
        calculatorPage.setDataToCalculationTable();
    }

    @AfterTest(alwaysRun = true)
    public void stopBrowser()
    {        DriverSingleton.closeDriver();
    }
}
