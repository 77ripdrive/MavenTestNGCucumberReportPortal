package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class VerificationOfUserDataEnteredInTheCalculationPage extends CommonConditions {

    protected String classVM = "VM class: regular";
    protected String instataceType = "Instance type: n1-standard-8";
    protected String region = "Region: Frankfurt";
    protected String localSsd = "Total available local SSD space 2x375 GB";
    protected String commitmentTerm = "Commitment term: 1 Year";
    protected String totalEstimatedCost = "Total Estimated Cost: USD 1,187.77 per 1 month";

    @Test
    public void checkClassVMFromEstimate() {
        Assert.assertEquals(calculatorPage.getClassVM(), classVM);
    }

    @Test
    public void checkInstanceTypeFromEstimate() {
        Assert.assertEquals(calculatorPage.getInstataceType(), instataceType);
    }

    @Test
    public void checkRegoinFromEstimate() {
        Assert.assertEquals(calculatorPage.getRegion(), region);
    }

    @Test
    public void checkLocalSSDFromEstimate() {
        Assert.assertEquals(calculatorPage.getLocalSsd(), localSsd);
    }

    @Test
    public void checkCommitmentFromEstimate() {
        Assert.assertEquals(calculatorPage.getCommitmentTerm(), commitmentTerm);
    }

    @Test
    public void checkTotalCoastFromEstimate() {
        Assert.assertEquals(calculatorPage.getTotalEstimatedCost(), totalEstimatedCost);
    }
//    @Test(priority = 7)
//    public void checkTotalCoastEstimateFromTenMinuteEmail(){
//        String totalEstimateTable=calculatorPage.getTotalEstimatedCost();
//        calculatorPage.nextStepToGetMailWithEstimateCost();
//        String coastFromEmail=calculatorPage.getTotalEstimateCostFromTenMinute();
//        Assert.assertTrue(totalEstimateTable.contains(String.valueOf(coastFromEmail)));
//        calculatorPage.closeTenMinuteEmail();
}






