package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://cloud.google.com/products/calculator/";

    @FindBy(xpath = "//div[@class='tab-holder compute' and @title='Compute Engine']")
    private WebElement computeEngineOn;

    @FindBy (id ="input_46")
    private WebElement numberOfInstans;

    @FindBy (xpath ="//input[@id='input_47']")
    private WebElement instancesForField;

    @FindBy (xpath ="///*[@id='select_value_label_40']")
    private WebElement operatingSystem;

    @FindBy (xpath ="//*[@id='select_option_48']/div[1]")
    private WebElement choiceFree;

    @FindBy (id ="select_value_label_42")
    private WebElement popUpInstanceType;

    @FindBy (xpath ="//*[@id='select_option_70']/div[1]")
    private WebElement selectInstanceTypeNOneStandard;

    @FindBy (xpath ="//div[@class='md-icon']/..")
    private WebElement ripplyAddGpus;

    @FindBy (xpath ="//md-select-value[@id='select_value_label_327']")
    private WebElement selectValueNumberOfGpus;

    @FindBy (xpath ="//*[@id='select_option_334']/div")
    private WebElement selectValueNumberOfGpus1;

    @FindBy (xpath ="//*[@id='select_value_label_328']/span[1]")
    private WebElement selectGpuType;

    @FindBy (xpath ="//*[@id='select_option_341']/div")
    private WebElement selectGpuTypeV100;

    @FindBy (id ="select_value_label_43")
    private WebElement selectLocalSsd;

    @FindBy (id ="select_option_182")
    private WebElement selectLocalSsd2x375;

    @FindBy (id ="select_value_label_44")
    private WebElement selectDataCenterLocation;

    @FindBy (id ="select_option_196")
    private WebElement selectDataCenterLocationEW3;

    @FindBy (id ="select_value_label_45")
    private WebElement selectCommitedUsage;

    @FindBy (id ="select_option_100")
    private WebElement selectCommitedUsageOneYear;

    @FindBy (xpath ="//form/div[11]/button[@aria-label='Add to Estimate']")
    private WebElement clickButtonAddToEstimate;

    @FindBy (xpath ="//h2[@class='md-title']/b[@class='ng-binding']")
    private WebElement tableTotalEstimateCost;

    @FindBy (xpath ="(//div[@class='md-list-item-text ng-binding'])[2]")
    private WebElement  tatbleVMClass;

    @FindBy (xpath ="(//div[@class='md-list-item-text ng-binding'])[3]")
    private WebElement tableInstanceType;

    @FindBy (xpath ="(//div[@class='md-list-item-text ng-binding'])[4]")
    private WebElement tableRegin;

    @FindBy (xpath ="(//div[@class='md-list-item-text ng-binding'])[5]")
    private WebElement tableLocalSsd;

    @FindBy (xpath ="(//div[@class='md-list-item-text ng-binding'])[6]")
    private WebElement tableCommitmentTerm;

    @FindBy (xpath ="//*[@class='cp-header']//iframe")
    private WebElement switchOnIframe;

    @FindBy (xpath ="//*[@id='idIframe']")
    private WebElement switchOnIframeCalculator;

    @FindBy (xpath ="//button[@id='email_quote']")
    private WebElement emailEstimate;

    @FindBy (xpath ="//*[@id='input_380']")
    private WebElement stringEmailCalculator;

    @FindBy (xpath ="//form[@name='emailForm']//button[@aria-label='Send Email']")
    private WebElement buttonSendEmailCalculator;








    protected CalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    protected CalculatorPage openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Calculators page opened");
        return this;
    }

}
