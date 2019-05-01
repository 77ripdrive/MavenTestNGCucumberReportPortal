package test;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class CloudGoogleDefs extends  CommonConditions{
    
    @Given("^I open CloudeGoogle page$")
    public void iOpenCloudeGooglePage() {
        mainCloudPage.openPage();
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

    @When("^I filled the field <numberOfInstance>,<whatInstunceFor>,<softWare>$")
    public void iFilledTheFieldNumberOfInstanceWhatInstunceForSoftWare
            (String numberOfInstance,String whatInstunceFor,String softWare ) {
        calculatorPage.fillFirstAND(numberOfInstance,whatInstunceFor,softWare);
    }

    @And("^I filled the field <vMClass>,<instanceType>,<numberGPU>,<gPUType>$")
    public void iFilledTheFieldVMClassInstanceTypeNumberGPUGPUType
            (String vMClass,String instanceType,String numberGPU,String gPUType ) {

        calculatorPage.fillSecondAND(vMClass,instanceType,numberGPU,gPUType);
    }


    @And("^I filled the field <localSSD>,<dataCenterLocation>,<commitedUsage> and click Button to Estimate$")
    public void iFilledTheFieldLocalSSDDataCenterLocationCommitedUsageAndClickButtonToEstimate
            (String localSSD,String dataCenterLocation,String commitedUsage) {
        calculatorPage.fillThiredAND(localSSD,dataCenterLocation,commitedUsage);
    }


    @Then("^I should see \"([^\"]*)\" message  equal to :Total Estimated Cost: USD (\\d+),(\\d+)\\.(\\d+) per (\\d+) month$")
    public void iShouldSeeMessageEqualToTotalEstimatedCostUSDPerMonth (String arg0, int arg1, int arg2, int arg3, int arg4) throws Throwable {
       String totalEstimateTable="Total Estimated Cost: USD 1,187.77 per 1 month";
        Assert.assertTrue(totalEstimateTable.contains(calculatorPage.getTotalEstimatedCost()));
        throw new cucumber.api.PendingException();
    }
}
