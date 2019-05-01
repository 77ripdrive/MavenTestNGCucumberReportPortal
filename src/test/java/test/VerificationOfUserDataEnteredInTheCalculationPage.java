package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerificationOfUserDataEnteredInTheCalculationPage extends CommonConditions {

    private String classVM = "VM class: regular";
    private String instataceType = "Instance type: n1-standard-8";
    private String region = "Region: Frankfurt";
    private String localSsd = "Total available local SSD space 2x375 GB";
    private String commitmentTerm = "Commitment term: 1 Year";
    private String totalEstimatedCost = "Total Estimated Cost: USD 1,187.77 per 1 month";


    @Test
    public void checkInstanceTypeFromEstimate() {mainCloudPage.openPage();
        mainCloudPage.pushExploreAllProducts()
                .pushSeePrising()
                .pushPricingNavigationCalculators()
                .addToEstimate();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(calculatorPage.getClassVM(), classVM);
        softAssert.assertEquals(calculatorPage.getClassVM(), classVM);
        softAssert.assertEquals(calculatorPage.getInstataceType(), instataceType);
        softAssert.assertEquals(calculatorPage.getRegion(), region);
        softAssert.assertEquals(calculatorPage.getLocalSsd(), localSsd);
        softAssert.assertEquals(calculatorPage.getCommitmentTerm(), commitmentTerm);
        softAssert.assertEquals(calculatorPage.getTotalEstimatedCost(), totalEstimatedCost);
        softAssert.assertAll();

    }

}






