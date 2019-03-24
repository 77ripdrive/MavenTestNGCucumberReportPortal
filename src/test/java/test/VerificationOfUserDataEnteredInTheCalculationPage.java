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
    public void checkInstanceTypeFromEstimate() {mainCloudPage.openPage();
        mainCloudPage.pushExploreAllProducts()
                .pushSeePrising()
                .pushPricingNavigationCalculators()
                .addToEstimate();
        Assert.assertEquals(calculatorPage.getClassVM(), classVM);
        Assert.assertEquals(calculatorPage.getInstataceType(), instataceType);
        Assert.assertEquals(calculatorPage.getRegion(), region);
        Assert.assertEquals(calculatorPage.getLocalSsd(), localSsd);
        Assert.assertEquals(calculatorPage.getCommitmentTerm(), commitmentTerm);
        Assert.assertEquals(calculatorPage.getTotalEstimatedCost(), totalEstimatedCost);

    }

}






