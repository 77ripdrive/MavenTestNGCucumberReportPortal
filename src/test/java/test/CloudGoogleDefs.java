package test;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.DriverSingleton;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.*;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import page.*;
import reporting.MyLogger;
import util.TestListener;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Listeners({TestListener.class})
public class CloudGoogleDefs {

    protected WebDriver driver;
    protected MainCloudPage mainCloudPage;
    protected ProductsPage productsPage;
    protected PricingPage pricingPage;
    protected CalculatorPage calculatorPage;
    protected TenMinuteMailPage tenMinuteMailPage;
    String totalEstimateTable;
    String emailFromTenMinute;
    String coastFromEmail;


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
            (String vMClass,String instanceType,String numberGPU,String gPUType )  {
        calculatorPage.fillSecondAND(vMClass,instanceType,numberGPU,gPUType);

    }

    @And("^I filled the field \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and click Button to Estimate$")
    public void iFilledTheFieldAndClickButtonToEstimate
            (String localSSD,String dataCenterLocation,String commitedUsage)  {
        calculatorPage.fillThiredAND(localSSD,dataCenterLocation,commitedUsage);

    }


    @When("^I filled the field   \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" in table$")
    public void iFilledTheFieldInTable(String numberOfInstance,String whatInstunceFor,String softWare) {
        calculatorPage.fillFirstAND(numberOfInstance,whatInstunceFor,softWare);

    }
    @Then("^I should see  message  equal to \"([^\"]*)\"$")
    public void iShouldSeeMessageEqualTo(String estimateTable) {
        totalEstimateTable=calculatorPage.getTotalEstimatedCost();
       Assert.assertTrue(estimateTable.contains(totalEstimateTable));

    }
    @Then("^I should see price in letter is equal with price on calculator page$")
    public void iShouldSeePriceInLetterIsEqualWithPriceOnCalculatorPage() {
        totalEstimateTable=calculatorPage.getTotalEstimatedCost();
        emailFromTenMinute=calculatorPage.goToTenMinuteEmail()
                .openPage()
                .getemailFromTenMinute();
        calculatorPage.setEmailFromTenMinuteMailToMailForm(emailFromTenMinute);
        coastFromEmail = tenMinuteMailPage.readTotalEstimateCostFromTenMinute();
                Assert.assertTrue(totalEstimateTable.contains(String.valueOf(coastFromEmail)));
        calculatorPage.closeTenMinuteEmail();
    }


    @Then("^I should see logo Roche$")
    public void iShouldSeeLogoRoche() {
      Assert.assertTrue(  mainCloudPage.isLogoRocheExist());
    }

    @Before
    public void initializeTest() {

    }

    @After
    public void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {

            saveScreenshot();
        }

        DriverSingleton.closeDriver();
    }
    private void saveScreenshot(){
        File screenCapture = ((TakesScreenshot) DriverSingleton
                .getDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(
                    ".//target/screenshots/"
                            + getCurrentTimeAsString() +
                            ".png"));
        } catch (IOException e) {
            e.getLocalizedMessage();
        }
    }
    private String getCurrentTimeAsString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "uuuu-MM-dd_HH-mm-ss" );
        return ZonedDateTime.now().format(formatter);
    }

}
