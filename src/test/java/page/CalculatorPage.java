package page;

import model.UserCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import service.LocatorCorrector;
import service.UserCaseCreator;

import java.util.ArrayList;
import java.util.List;

public  class CalculatorPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    Actions actions = new Actions(driver);
    private final String BASE_URL = "https://cloud.google.com/products/calculator/";
    ArrayList <String> windowHandle;
    public CalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }


    UserCase userCase=UserCaseCreator.withCredentialsFromProperty();

    @FindBy(xpath = "//div[@class='tab-holder compute' and @title='Compute Engine']")
    protected WebElement computeEngineOn;

    @FindBy(id = "input_46")
    protected WebElement numberOfInstans;

    @FindBy(xpath = "//input[@id='input_47']")
    protected WebElement instancesForField;

    @FindBy(xpath = "//*[@id='select_value_label_40']")
    protected WebElement operatingSystem;

    @FindBy(xpath = "//*[@id='select_value_label_41']/span[2]")
    protected WebElement vmClassField;

    @FindBy(xpath ="//md-select[@placeholder='Instance type']")
    protected WebElement dropDownInstanceType;

    @FindBy(xpath = "//*[@aria-label='Add GPUs']")
    protected WebElement ripplyAddGpus;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']/md-select-value/span[1]")
    protected WebElement selectValueNumberOfGpus;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    protected WebElement selectGpuType;

    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    protected WebElement selectLocalSsd;

    @FindBy(xpath = "//md-select[@placeholder='Datacenter location']/*[@id='select_value_label_44']/span[1]/div")
    protected WebElement selectDataCenterLocation;

    @FindBy(xpath= "//md-select[@placeholder='Committed usage']//span[1]/div")
    protected WebElement selectCommitedUsage;

    @FindBy(xpath = "//form/div[11]/button[@aria-label='Add to Estimate']")
    protected WebElement clickButtonAddToEstimate;

    @FindBy(xpath = "//h2[@class='md-title']/b[@class='ng-binding']")
    protected WebElement tableTotalEstimateCost;

    @FindBy(xpath = "(//div[@class='md-list-item-text ng-binding'])[2]")
    protected WebElement tatbleVMClass;

    @FindBy(xpath = "(//div[@class='md-list-item-text ng-binding'])[3]")
    protected WebElement tableInstanceType;

    @FindBy(xpath = "(//div[@class='md-list-item-text ng-binding'])[4]")
    protected WebElement tableRegin;

    @FindBy(xpath = "(//div[@class='md-list-item-text ng-binding'])[5]")
    protected WebElement tableLocalSsd;

    @FindBy(xpath = "(//div[@class='md-list-item-text ng-binding'])[6]")
    protected WebElement tableCommitmentTerm;

    @FindBy(xpath = "//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple' and @id='email_quote']")
    protected WebElement emailEstimate;

    @FindBy(xpath = "//input[@type='email']")
    protected WebElement stringEmailCalculator;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    protected WebElement buttonSendEmailCalculator;


    private  String preSelectSoftWareType="//md-option/div[text()='%s']";
    private  String preSelectVMClass="//md-option/div[text()='%s']";
    private  String preSelectInstanceType="//md-option[@value='%s']/div[1]";
    private  String preSelectNumberGPU="//md-option/div[@class='md-text ng-binding' and text()='%s']";
    private  String preSelectGPUType="//md-option/div[contains(text(),'%s')]";
    private  String preSelectlocalSSD="//md-option/div[contains(text(),'%s')]";
    private  String preSelectdataCenterLocation="//*[@class='md-overflow']//md-option/div[text()='%s']";
    private  String preSelectCommitedUsage="//md-option/div[text()='%s']";

    private CalculatorPage activateComputeEngine(){
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*")));
        computeEngineOn.click();
        return this;
    }
    private CalculatorPage setNumberOfInstances(String numberOfInstance){
        numberOfInstans.sendKeys(numberOfInstance);
        return this;
    }
    private CalculatorPage setInstacasForField(String whatInstunceFor){
       instancesForField.sendKeys(whatInstunceFor);
        return this;
    }
    private CalculatorPage setOS(String softWare){
       operatingSystem.click();
       driver.findElement(LocatorCorrector
               .masterForLocators(preSelectSoftWareType,softWare)).click();
        return this;
    }
    private CalculatorPage setVmClass(String vmClass) {
        vmClassField.click();
        List <WebElement> links = driver.findElements
                (LocatorCorrector.masterForLocators(preSelectVMClass,vmClass));
        links.get(1).click();
        return this;
    }

    private CalculatorPage setInstanceType(String instanceType){
        dropDownInstanceType.click();
        driver.findElement(LocatorCorrector
                .masterForLocators(preSelectInstanceType,instanceType)).click();
        return this;
    }
    private CalculatorPage setAddGPU(String numberGPU,String gPUType){
        ripplyAddGpus.click();
        selectValueNumberOfGpus.click();
        driver.findElement(LocatorCorrector.masterForLocators(preSelectNumberGPU,numberGPU)).click();
        selectGpuType.click();
        driver.findElement(LocatorCorrector.masterForLocators
                (preSelectGPUType,gPUType)).click();
        return this;
    }
    private CalculatorPage setLocacSSD(String localSSD ){
        selectLocalSsd.click();
        driver.findElement(LocatorCorrector.masterForLocators
                (preSelectlocalSSD,localSSD)).click();
        return this;
    }

    private CalculatorPage setDataCenter(String dataCenter){
        selectDataCenterLocation.click();
        driver.findElement(LocatorCorrector.masterForLocators
                (preSelectdataCenterLocation,dataCenter)).click();
        return this;
    }
    private CalculatorPage setCommitedUsage(String commitedUsage){
        selectCommitedUsage.click();
        List <WebElement> links = driver.findElements
                (LocatorCorrector.masterForLocators(preSelectCommitedUsage,commitedUsage));
        links.get(1).click();
        return this;
    }


    public CalculatorPage addToEstimate(){
        logger.info("Calculators page opened");
        driver.switchTo().frame("idIframe");
        this.activateComputeEngine();
        this.setNumberOfInstances(userCase.getNumberOfInstance());
        this.setInstacasForField(userCase.getWhatInstunceFor());
        this.setOS(userCase.getSoftWare());
        this.setVmClass(userCase.getvMClass());
        this.setInstanceType(userCase.getInstanceType());

        this.setAddGPU(userCase.getNumberGPU(),userCase.getgPUType());
        this.setLocacSSD(userCase.getLocalSSD());
        this.setDataCenter(userCase.getDataCenterLocation());
        this.setCommitedUsage(userCase.getCommitedUsage());
        clickButtonAddToEstimate.click();
        return new CalculatorPage(driver);
    }


    public String getTotalEstimatedCost() { return tableTotalEstimateCost.getText();    }

    public String getClassVM() {  return tatbleVMClass.getText();  }

    public String getInstataceType() {  return tableInstanceType.getText();  }

    public String getRegion() {  return tableRegin.getText(); }

    public String getLocalSsd() {  return tableLocalSsd.getText();  }

    public String getCommitmentTerm() { return tableCommitmentTerm.getText(); }



    public TenMinuteMailPage goToTenMinuteEmail() {
        emailEstimate.click();
        driver.switchTo().defaultContent();
        ( (JavascriptExecutor) driver ).executeScript("window.open()");
         switchingBetweenWindow(1);
         return new TenMinuteMailPage(driver);

    }

    public TenMinuteMailPage setEmailFromTenMinuteMailToMailForm(String emailAdress){
        switchingBetweenWindow(0);
        driver.switchTo().frame("idIframe");
        stringEmailCalculator.sendKeys(emailAdress);
        buttonSendEmailCalculator.click();
        driver.switchTo().defaultContent();
        switchingBetweenWindow(1);
        logger.info("Move to 10minute");
        return new TenMinuteMailPage(driver);
    }

    public void closeTenMinuteEmail(){
        this.driver.switchTo().defaultContent();
        this.driver.close();
        switchingBetweenWindow(0);
    }

    public void  switchingBetweenWindow(int win) {
        windowHandle = new ArrayList <String>(driver.getWindowHandles());
        driver.switchTo().window(windowHandle.get(win));
    }

      @Override
    public CalculatorPage openPage() {
        driver.navigate().to(BASE_URL);
        return new CalculatorPage(driver);
    }
}

