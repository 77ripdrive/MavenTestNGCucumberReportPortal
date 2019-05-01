package test;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

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

    @When("^I filled the field <numberOfInstance>,<whatInstunceFor>,<softWare>,<vMClass>,<instanceType>$")
    public void iFilledTheFieldNumberOfInstanceWhatInstunceForSoftWareVMClassInstanceType() {


    }

    @And("^I filled the field <vMClass>,<instanceType>,<numberGPU>,<gPUType>$")
    public void iFilledTheFieldVMClassInstanceTypeNumberGPUGPUType() {
        
    }

    @And("^I filled the field <localSSD>,<dataCenterLocation>,<commitedUsage>$")
    public void iFilledTheFieldLocalSSDDataCenterLocationCommitedUsage() {
    }
}
