package test;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import page.*;
import util.TestListener;

@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver driver;
    protected MainCloudPage mainCloudPage;
    protected ProductsPage productsPage;
    protected PricingPage pricingPage;
    protected CalculatorPage calculatorPage;
    protected TenMinuteMailPage tenMinuteMailPage;


    @BeforeMethod()
    public void setUp()
    {   driver = DriverSingleton.getDriver();
        mainCloudPage=new MainCloudPage(driver);
        productsPage=new ProductsPage(driver);
        pricingPage=new PricingPage(driver);
        calculatorPage=new CalculatorPage(driver);
        tenMinuteMailPage=new TenMinuteMailPage(driver);

    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser()
    {       DriverSingleton.closeDriver();
    }
}
