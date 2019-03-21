package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.TenMinuteMailPage;

public class VerificationOfTotalEstimateCoastFromEmail extends CommonConditions {
    protected TenMinuteMailPage tenMinuteMailPage=new TenMinuteMailPage(driver);
    @Test
    public void checkTotalCoastEstimateFromTenMinuteEmail() {
        String totalEstimateTable = calculatorPage.getTotalEstimatedCost();
        calculatorPage.goToTenMinuteEmail()
                .openPage();
        calculatorPage.setEmailFromTenMinuteMailToMailForm
                (tenMinuteMailPage.getemailFromTenMinute());
        String coastFromEmail = tenMinuteMailPage.readTotalEstimateCostFromTenMinute();
                Assert.assertTrue(totalEstimateTable.contains(String.valueOf(coastFromEmail)));

        calculatorPage.closeTenMinuteEmail();
    }
}
