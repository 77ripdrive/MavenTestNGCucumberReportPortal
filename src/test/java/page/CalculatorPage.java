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
import service.UserCaseCreator;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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
    public WebElement computeEngineOn;
    @FindBy(id = "input_46")
    public WebElement numberOfInstans;
    @FindBy(xpath = "//input[@id='input_47']")
    public WebElement instancesForField;
    @FindBy(xpath = "//*[@id='select_value_label_40']")
    public WebElement operatingSystem;
    @FindBy(xpath = "//*[@id='select_value_label_41']/span[2]")
    public WebElement vmClassField;
    @FindBy(xpath = "//*[@id='select_option_60']/div[1]")
    public WebElement choiceRegular;
    @FindBy(id = "select_value_label_42")
    public WebElement popUpInstanceType;
    @FindBy(xpath = "//*[@aria-label='Add GPUs']")
    public WebElement ripplyAddGpus;
    @FindBy(xpath = "//md-select-value[@id='select_value_label_327']")
    public WebElement selectValueNumberOfGpus;
    @FindBy(xpath = "//*[@id='select_value_label_328']/span[1]")
    public WebElement selectGpuType;
    @FindBy(id = "select_value_label_43")
    public WebElement selectLocalSsd;
    @FindBy(id = "select_value_label_44")
    public WebElement selectDataCenterLocation;
    @FindBy(id = "select_value_label_45")
    public WebElement selectCommitedUsage;
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



    private By choiceFree=By.xpath("//*[@id='select_option_48']/div[1]");
    private By selectInstanceTypeNOneStandard = By.xpath("//*[@id='select_option_70']/div[1]");
    private By selectValueNumberOfGpus1 = By.xpath("//*[@id='select_option_334']/div");
    private By selectGpuTypeV100 = By.xpath("//*[@id='select_option_341']/div");
    private By selectLocalSsd2x375 = By.xpath("//*[@id='select_option_182']");
    private By selectDataCenterLocationEW3 = By.id("select_option_196");
    private By selectCommitedUsageOneYear = By.xpath("//*[@id='select_option_100']");



    private CalculatorPage activateComputeEngine(){
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
    private CalculatorPage setInstanceOS(){
       operatingSystem.click();
       if (userCase.getInstanceType().equals("Free:_Debian_CentOS_CoreOS_Ubuntu_Or_Other_User_Provided_OS")){
           driver.findElement(choiceFree).click();}

        return this;
    }
    private CalculatorPage setClassVM(By by){
        popUpInstanceType.click();
        driver.findElement(by).click();
        return this;
    }
    private CalculatorPage setAddGPU(By by,By by1){
        ripplyAddGpus.click();
        selectValueNumberOfGpus.click();
        driver.findElement(by).click();
        selectGpuType.click();
        driver.findElement(by1).click();
        return this;
    }
    private CalculatorPage setLocacSSD(By by){
        selectLocalSsd.click();
        driver.findElement(by).click();
        return this;
    }

    private CalculatorPage setDataCenter(By by){
        selectDataCenterLocation.click();
        driver.findElement(by).click();
        return this;
    }
    private CalculatorPage setCommitedUsage(By by){
        selectCommitedUsage.click();
        driver.findElement(by).click();
        return this;
    }

    public CalculatorPage addToEstimate(){
        this.activateComputeEngine();
        this.setNumberOfInstances(userCase.getNumberOfInstance());
        this.setInstacasForField(userCase.getWhatInstunceFor());
        this.setInstanceOS();
        this.setClassVM();
        this.setAddGPU();
        this.setLocacSSD();
        this.setDataCenter();
        this.setCommitedUsage();
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
      @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Pricing page opened");
    }
}

