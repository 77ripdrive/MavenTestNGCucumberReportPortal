package test;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.*;

public class CloudGoogleDefs {
    protected WebDriver driver;
    protected MainCloudPage mainCloudPage;
    protected ProductsPage productsPage;
    protected PricingPage pricingPage;
    protected CalculatorPage calculatorPage;
    protected TenMinuteMailPage tenMinuteMailPage;
    String totalEstimateTable;

    public CloudGoogleDefs() {
        driver = DriverSingleton.getDriver();
        mainCloudPage=new MainCloudPage(driver);
        productsPage=new ProductsPage(driver);
        pricingPage=new PricingPage(driver);
        calculatorPage=new CalculatorPage(driver);
        tenMinuteMailPage=new TenMinuteMailPage(driver);
    }

    @Given("^I open Cloud Google page$")
    public void iOpenCloudGooglePage() {mainCloudPage.openPage();
    }

    @And("^I open Products page$")
    public void iOpenProductsPage() {
        mainCloudPage.pushExploreAllProducts();
    }

    @And("^I open Pricing page$")
    public void iOpenPricingPage() {
        productsPage.pushSeePrising();
    }

    @And("^I open Calculator page$")
    public void iOpenCalculatorPage() {
        pricingPage.pushPricingNavigationCalculators();
    }

    @And("^I filled the field \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void iFilledTheField
            (String vMClass,String instanceType,String numberGPU,String gPUType ) throws Throwable {
        calculatorPage.fillSecondAND(vMClass,instanceType,numberGPU,gPUType);
        throw new PendingException();
    }

    @And("^I filled the field \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and click Button to Estimate$")
    public void iFilledTheFieldAndClickButtonToEstimate
            (String localSSD,String dataCenterLocation,String commitedUsage) throws Throwable {
        calculatorPage.fillThiredAND(localSSD,dataCenterLocation,commitedUsage);
        throw new PendingException();
    }


    @When("^I filled the field   \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" in table$")
    public void iFilledTheFieldInTable(String numberOfInstance,String whatInstunceFor,String softWare) throws Throwable {
        calculatorPage.fillFirstAND(numberOfInstance,whatInstunceFor,softWare);
        throw new PendingException();
    }
    @Then("^I should see  message  equal to \"([^\"]*)\"$")
    public void iShouldSeeMessageEqualTo(String estimateTable) throws Throwable {
        totalEstimateTable=calculatorPage.getTotalEstimatedCost();
        Assert.assertTrue(estimateTable.contains(totalEstimateTable));
        throw new PendingException();
    }
    @Then("^I should see price in letter is equal with price on calculator page$")
    public void iShouldSeePriceInLetterIsEqualWithPriceOnCalculatorPage() {
        String emailFromTenMinute=calculatorPage.goToTenMinuteEmail()
                .openPage()
                .getemailFromTenMinute();
        calculatorPage.setEmailFromTenMinuteMailToMailForm(emailFromTenMinute);
        String coastFromEmail = tenMinuteMailPage.readTotalEstimateCostFromTenMinute();
                Assert.assertTrue(totalEstimateTable.contains(String.valueOf(coastFromEmail)));
        calculatorPage.closeTenMinuteEmail();
    }
}
