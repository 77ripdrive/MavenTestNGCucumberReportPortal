package page;

import model.UserCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import service.UserCaseCreator;

import java.util.ArrayList;

public  class CalculatorPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
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

    @FindBy(id = "select_value_label_42")
    protected WebElement dropDownInstanceType;

    @FindBy(xpath = "//*[@aria-label='Add GPUs']")
    protected WebElement ripplyAddGpus;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_327']")
    protected WebElement selectValueNumberOfGpus;

    @FindBy(xpath = "//*[@id='select_value_label_328']/span[1]")
    protected WebElement selectGpuType;

    @FindBy(id = "select_value_label_43")
    protected WebElement selectLocalSsd;

    @FindBy(id = "select_value_label_44")
    protected WebElement selectDataCenterLocation;

    @FindBy(id = "select_value_label_45")
    protected WebElement selectCommitedUsage;

    @FindBy(id = "select_option_100")
    protected WebElement selectCommitedUsageOneYear;

    @FindBy(id = "select_option_101")
     protected WebElement selectCommitedUsageThreeYear;

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

    @FindBy(xpath = "//*[@class='cp-header']//iframe")
    protected WebElement switchOnIframe;

    @FindBy(xpath = "//*[@id='idIframe']")
    protected WebElement switchOnIframeCalculator;

    @FindBy(xpath = "//button[@id='email_quote']")
    protected WebElement emailEstimate;

    @FindBy(xpath = "//*[@id='input_380']")
    protected WebElement stringEmailCalculator;

    @FindBy(xpath = "//form[@name='emailForm']//button[@aria-label='Send Email']")
    protected WebElement buttonSendEmailCalculator;


    private final String preSelectSoftWareType="//div[text()='%s']";
    private final String preSelectVMClass="//*[@id='select_value_label_41']/span[1]/div[contains(text(),'%s')]";
    private final String preSelectInstanceType="//md-option[@value='%s']/div[1]";
    private final String preSelectNumberGPU="//div[@class='md-text ng-binding' and contains(text(),'%s')]";
    private final String preSelectGPUType="//*[@id='select_option_341']/div[contains(text(),'%s')]";
    private final String preSelectlocalSSD="//*[@id='select_option_182']/div[contains(text(),'%s')]";
    private final String preSelectdataCenterLocation="//*[@id='select_container_98']//div[ contains(text(),'%s')]";




    private CalculatorPage activateComputeEngine(){
        new  WebDriverWait(driver,WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(computeEngineOn));
        driver.switchTo().frame(switchOnIframe);
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
       driver.findElement(masterForLocators(preSelectSoftWareType,softWare)).click();
        return this;
    }
    private CalculatorPage setVmClass(String vmClass) {
        vmClassField.click();
        driver.findElement(masterForLocators(preSelectVMClass,vmClass)).click();
        return this;
    }

    private CalculatorPage setInstanceType(String instanceType){
        dropDownInstanceType.click();
        driver.findElement(masterForLocators(preSelectInstanceType,instanceType)).click();
        return this;
    }
    private CalculatorPage setAddGPU(String numberGPU,String gPUType){
        ripplyAddGpus.click();
        selectValueNumberOfGpus.click();
        driver.findElement(masterForLocators(preSelectNumberGPU,numberGPU)).click();
        selectGpuType.click();
        driver.findElement(masterForLocators(preSelectGPUType,gPUType)).click();
        return this;
    }
    private CalculatorPage setLocacSSD(String localSSD ){
        selectLocalSsd.click();
        driver.findElement(masterForLocators(preSelectlocalSSD,localSSD)).click();
        return this;
    }

    private CalculatorPage setDataCenter(String dataCenter){
        selectDataCenterLocation.click();
        driver.findElement(masterForLocators(preSelectdataCenterLocation,dataCenter)).click();
        return this;
    }
    private CalculatorPage setCommitedUsage(String commitedUsage){
        selectCommitedUsage.click();
        if(commitedUsage.equals(1)){   selectCommitedUsageOneYear.click();}
        if(commitedUsage.equals(3)){   selectCommitedUsageThreeYear.click();}
        return this;
    }

    public CalculatorPage addToEstimate(){
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

    public TenMinuteMailPage setEmailFromTenMinuteMailToMailForm(String emailFromTenMinuteMail){
        switchingBetweenWindow(0);
        driver.switchTo().frame(switchOnIframeCalculator);
        stringEmailCalculator.sendKeys(emailFromTenMinuteMail);
        buttonSendEmailCalculator.click();
        driver.switchTo().defaultContent();
        switchingBetweenWindow(1);
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

    private   By masterForLocators(String target,  String values)
    { values=values.replace("_"," ");
        String selector=String.format(target,values);
      By  locator = By.xpath(selector);
        return locator;
    }
      @Override
    public CalculatorPage openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Pricing page opened");
        return new CalculatorPage(driver);
    }
}

