package page;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reporting.MyLogger;
import service.LocatorCorrector;

import java.util.ArrayList;
import java.util.List;


public  class CalculatorPage extends AbstractPage {

    private Actions actions = new Actions(driver);
    private final String BASE_URL = "https://cloud.google.com/products/calculator/";

    ArrayList <String> windowHandle;

    public CalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }




    @FindBy(xpath = "//div[@class='tab-holder compute' and @title='Compute Engine']")
    protected WebElement computeEngineOn;

    @FindBy(xpath ="//input[@ng-model='listingCtrl.computeServer.quantity']" )
    protected WebElement numberOfInstans;

    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.label']")
    protected WebElement instancesForField;

    @FindBy(xpath = "//*[@id='select_value_label_43']/span[1]/div")
    protected WebElement operatingSystem;

    @FindBy(xpath = "//*[@id='select_value_label_44']/span[1]/div")
    protected WebElement vmClassField;

    @FindBy(xpath ="//md-select[@placeholder='Instance type']")
    protected WebElement dropDownInstanceType;

    @FindBy(xpath = "//*[@aria-label='Add GPUs']")
    protected WebElement ripplyAddGpus;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']/md-select-value/span[1]")
    protected WebElement selectValueNumberOfGpus;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    protected WebElement selectGpuType;

    @FindBy(xpath = "//*[@id='select_value_label_47']/span[1]/div")
    protected WebElement selectLocalSsd;

    @FindBy(xpath = "//*[@id='select_value_label_85']/span[1]/div")
    protected WebElement selectDataCenterLocation;

    @FindBy(xpath= "//*[@id='select_value_label_49']/span[1]/div")
    protected WebElement selectCommitedUsage;

    @FindBy(xpath = "//*[@id='mainForm']//div[13]/button[@aria-label='Add to Estimate']")
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


    private  String preSelectSoftWareType="//md-option/div[contains(text(),'%s')]";
    private  String preSelectVMClass="//md-option/div[contains(text(),'%s')]";
    private  String preSelectInstanceType="//md-option[@value='%s']/div[1]";
    private  String preSelectNumberGPU="//*[@id='select_option_339']/div[contains(text(),'%s')]";
    private  String preSelectGPUType="//md-option/div[contains(text(),'%s')]";
    private  String preSelectlocalSSD="//div[contains(text(),'%s')]";
    private  String preSelectdataCenterLocation="//*[@class='md-overflow']//md-option/div[text()='%s']";
    private  String preSelectCommitedUsage=".//md-option/div[text()='%s']";

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
       waitUntilElementPresent(LocatorCorrector
               .masterForLocators(preSelectSoftWareType,softWare)).click();
       MyLogger.info("OS is :" + softWare);

        return this;
    }
    private CalculatorPage setVmClass(String vmClass) {
        vmClassField.click();

        List <WebElement> links = driver.findElements
                (LocatorCorrector.masterForLocators(preSelectVMClass,vmClass));
        links.get(1).click();
        MyLogger.info("VmClass is : " + vmClass);
        return this;
    }

    private CalculatorPage setInstanceType(String instanceType){
        dropDownInstanceType.click();
        waitUntilElementPresent(LocatorCorrector
                .masterForLocators(preSelectInstanceType,instanceType)).click();
        MyLogger.info("InstanceType is : " + instanceType);
        return this;
    }
    private CalculatorPage setAddGPU(String numberGPU,String gPUType){
        ripplyAddGpus.click();
        selectValueNumberOfGpus.click();
        MyLogger.info("numberGPU is : " + numberGPU);
        waitUntilElementPresent(LocatorCorrector.masterForLocators(preSelectNumberGPU,numberGPU)).click();
        selectGpuType.click();
        waitUntilElementPresent(LocatorCorrector.masterForLocators
                (preSelectGPUType,gPUType)).click();
        MyLogger.info("gPUType : " + gPUType);
        return this;
    }
    private CalculatorPage setLocacSSD(String localSSD ){
        selectLocalSsd.click();
        MyLogger.info("setLocacSSD");

        actions.moveToElement(driver.findElement(LocatorCorrector.masterForLocators
                (preSelectlocalSSD,localSSD))).click();

                MyLogger.info("localSSD is :  " + localSSD);
        return this;
    }

    private CalculatorPage setDataCenter(String dataCenter){
        actions.moveToElement(selectDataCenterLocation).click();
        MyLogger.info("dataCenter");
        actions.moveToElement(driver.findElement(LocatorCorrector.masterForLocators
                (preSelectlocalSSD,dataCenter))).click();
        MyLogger.info("DataCenter is :" + dataCenter);

        return this;
    }
    private CalculatorPage setCommitedUsage(String commitedUsage){
        selectCommitedUsage.click();
        MyLogger.info("setCommitedUsage");
        List <WebElement> links = driver.findElements
                (LocatorCorrector.masterForLocators(preSelectCommitedUsage,commitedUsage));
        links.get(1).click();
        MyLogger.info("CommitedUsage is :" + commitedUsage);
        return this;
    }


    public CalculatorPage fillFirstAND
            (String numberOfInstance,String whatInstunceFor,String softWare) {
        MyLogger.info("Calculators page opened is :" + BASE_URL);
        driver.switchTo().frame("idIframe");
        this.activateComputeEngine();
        this.setNumberOfInstances(numberOfInstance);
        this.setInstacasForField(whatInstunceFor);
        this.setOS(softWare);
        return new CalculatorPage(driver);

    }
    public CalculatorPage fillSecondAND
            ( String vMClass,String instanceType,String numberGPU,String gPUType){
        this.setVmClass(vMClass);
        this.setInstanceType(instanceType);
        this.setAddGPU(numberGPU,gPUType);

        return new CalculatorPage(driver);
    }
    public CalculatorPage fillThiredAND
            (String localSSD,String dataCenterLocation,String commitedUsage) {
        this.setLocacSSD(localSSD);
        this.setDataCenter(dataCenterLocation);
        this.setCommitedUsage(commitedUsage);
        clickButtonAddToEstimate.click();
        MyLogger.info("Estimate is complete");
        return new CalculatorPage(driver);
    }
    public String getTotalEstimatedCost() {
        return waitUntilElementPresent(tableTotalEstimateCost).getText();    }

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
        MyLogger.info("Move to 10minute : " + emailAdress);
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

