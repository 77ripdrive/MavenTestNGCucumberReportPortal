package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public  class CalculatorPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://cloud.google.com/products/calculator/";

    @FindBy(xpath = "//div[@class='tab-holder compute' and @title='Compute Engine']")
    public WebElement computeEngineOn;

    @FindBy(id = "input_46")
    public WebElement numberOfInstans;

    @FindBy(xpath = "//input[@id='input_47']")
    public WebElement instancesForField;

    @FindBy(xpath = "///*[@id='select_value_label_40']")
    public WebElement operatingSystem;

    @FindBy(xpath = "//*[@id='select_option_48']/div[1]")
    public WebElement choiceFree;

    @FindBy(id = "select_value_label_42")
    public WebElement popUpInstanceType;

    @FindBy(xpath = "//*[@id='select_option_70']/div[1]")
    public WebElement selectInstanceTypeNOneStandard;

    @FindBy(xpath = "//div[@class='md-icon']/..")
    public WebElement ripplyAddGpus;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_327']")
    public WebElement selectValueNumberOfGpus;

    @FindBy(xpath = "//*[@id='select_option_334']/div")
    public WebElement selectValueNumberOfGpus1;

    @FindBy(xpath = "//*[@id='select_value_label_328']/span[1]")
    public WebElement selectGpuType;

    @FindBy(xpath = "//*[@id='select_option_341']/div")
    public WebElement selectGpuTypeV100;

    @FindBy(id = "select_value_label_43")
    public WebElement selectLocalSsd;

    @FindBy(id = "select_option_182")
    public WebElement selectLocalSsd2x375;

    @FindBy(id = "select_value_label_44")
    public WebElement selectDataCenterLocation;

    @FindBy(id = "select_option_196")
    public WebElement selectDataCenterLocationEW3;

    @FindBy(id = "select_value_label_45")
    public WebElement selectCommitedUsage;

    @FindBy(id = "select_option_100")
    public WebElement selectCommitedUsageOneYear;

    @FindBy(xpath = "//form/div[11]/button[@aria-label='Add to Estimate']")
    public WebElement clickButtonAddToEstimate;

    @FindBy(xpath = "//h2[@class='md-title']/b[@class='ng-binding']")
    public WebElement tableTotalEstimateCost;

    @FindBy(xpath = "(//div[@class='md-list-item-text ng-binding'])[2]")
    public WebElement tatbleVMClass;

    @FindBy(xpath = "(//div[@class='md-list-item-text ng-binding'])[3]")
    public WebElement tableInstanceType;

    @FindBy(xpath = "(//div[@class='md-list-item-text ng-binding'])[4]")
    public WebElement tableRegin;

    @FindBy(xpath = "(//div[@class='md-list-item-text ng-binding'])[5]")
    public WebElement tableLocalSsd;

    @FindBy(xpath = "(//div[@class='md-list-item-text ng-binding'])[6]")
    public WebElement tableCommitmentTerm;

    @FindBy(xpath = "//*[@class='cp-header']//iframe")
    public WebElement switchOnIframe;

    @FindBy(xpath = "//*[@id='idIframe']")
    public WebElement switchOnIframeCalculator;

    @FindBy(xpath = "//button[@id='email_quote']")
    public WebElement emailEstimate;

    @FindBy(xpath = "//*[@id='input_380']")
    public WebElement stringEmailCalculator;

    @FindBy(xpath = "//form[@name='emailForm']//button[@aria-label='Send Email']")
    public WebElement buttonSendEmailCalculator;

    @FindBy(xpath = "//*[@id='mailAddress']")
    public WebElement emailFromTenMinute;

    @FindBy(xpath = "//*[@id='ui-id-1']/span[2]")
    public WebElement tenMinuteMail;

    @FindBy(xpath = ".//table[@class='quote']/tbody/tr[2]/td[2]/h3")
    public WebElement mailTotalEstCost;


    protected CalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }


    public CalculatorPage setDataToCalculationTable() {
        driver.switchTo().frame(switchOnIframe);
        computeEngineOn.click();
        numberOfInstans.sendKeys("4");
        instancesForField.sendKeys("");
        operatingSystem.click();
        choiceFree.click();
        popUpInstanceType.click();
        selectInstanceTypeNOneStandard.click();
        ripplyAddGpus.click();
        selectValueNumberOfGpus.click();
        selectValueNumberOfGpus1.click();
        selectGpuType.click();
        selectGpuTypeV100.click();
        selectLocalSsd.click();
        selectLocalSsd2x375.click();
        selectDataCenterLocation.click();
        selectDataCenterLocationEW3.click();
        selectCommitedUsage.click();
        selectCommitedUsageOneYear.click();
        clickButtonAddToEstimate.click();
        return new CalculatorPage(driver);
    }

    public String getTotalEstimatedCost() { return tableTotalEstimateCost.getText();    }

    public String getClassVM() {  return tatbleVMClass.getText();  }

    public String getInstataceType() {  return tableInstanceType.getText();  }

    public String getRegion() {  return tableRegin.getText(); }

    public String getLocalSsd() {  return tableLocalSsd.getText();  }

    public String getCommitmentTerm() { return tableCommitmentTerm.getText(); }

    public void switchingBetweenWindow() {
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

        public CalculatorPage nextStepToGetMailWithEstimateCost(){

            emailEstimate.click();
            String winHandleFirst = driver.getWindowHandle();
            driver.switchTo().defaultContent();
            String newWindow = "window.open('about:blank','_blank');";
            ( (JavascriptExecutor) driver ).executeScript(newWindow);
            switchingBetweenWindow();
            driver.get("https://10minutemail.com");
            String winHandleSecond = driver.getWindowHandle();
            String emailFromTenMinuteMail = emailFromTenMinute.getAttribute("value");

            driver.switchTo().window(winHandleFirst);
            driver.switchTo().frame(switchOnIframeCalculator);
            stringEmailCalculator.sendKeys(emailFromTenMinuteMail);
           buttonSendEmailCalculator.click();
            driver.switchTo().defaultContent();

            driver.switchTo().window(winHandleSecond);
            try {
                TimeUnit.SECONDS.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            tenMinuteMail.click();
            return new CalculatorPage(driver);
        }

    public String getTotalEstimateCostFromTenMinute() {
        String mailTotalEstimateCost = mailTotalEstCost.getText();
        return mailTotalEstimateCost;
    }
    public void closeHardCoreTest(){
        this.driver.switchTo().defaultContent();
        this.driver.close();
        switchingBetweenWindow();
        this.driver.close();
    }
    public void closeTestWintow(){
        this.driver.close();
    }

    @Override
    protected CalculatorPage openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Pricing page opened");
        return this;

    }
}

