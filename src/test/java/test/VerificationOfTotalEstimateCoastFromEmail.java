package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.TenMinuteMailPage;

public class VerificationOfTotalEstimateCoastFromEmail extends CommonConditions {

    @Test
    public void checkTotalCoastEstimateFromTenMinuteEmail() {
         String totalEstimateTable=mainCloudPage.openPage()
                .pushExploreAllProducts()
                .pushSeePrising()
                .pushPricingNavigationCalculators()
                .addToEstimate().getTotalEstimatedCost();

        String emailFromTenMinute=calculatorPage.goToTenMinuteEmail()
                .openPage()
                .getemailFromTenMinute();
        calculatorPage.setEmailFromTenMinuteMailToMailForm(emailFromTenMinute);
        String coastFromEmail = tenMinuteMailPage.readTotalEstimateCostFromTenMinute();
                Assert.assertTrue(totalEstimateTable.contains(String.valueOf(coastFromEmail)));
        calculatorPage.closeTenMinuteEmail();
    }
}
