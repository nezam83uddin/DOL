package commonapi;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
/**
 * Created by mdalam on 2/1/16.
 */
public class Base {
    public DesiredCapabilities cap = new DesiredCapabilities();
    public WebDriver driver = null;
    public Logger log = Logger.getLogger(Base.class.getName());
    @Parameters({"useSauceLab","userName", "key","appUrl","os","browserName","browserVersion"})
    @BeforeMethod
    public void setUp(boolean useSauceLab,String userName,String key,String appUrl, String os,
                      String browserName,String browserVersion )throws IOException{

        if(useSauceLab == true){
            getSauceLabDriver(userName, key, os, browserName, browserVersion);
        }else{
            getLocalDriver(os, browserName);
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(appUrl);
        driver.manage().window().maximize();
        log.info("browser loaded with App");
    }

    @AfterMethod
    public void cleanUp(ITestResult result)throws InterruptedException{
        if (ITestResult.FAILURE == result.getStatus()) {
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            try {
                TakesScreenshot ts = (TakesScreenshot) driver;
                File source = ts.getScreenshotAs(OutputType.FILE);

//                FileUtils.copyFile(source, new File("C:\\Users\\nd0ma3\\Desktop\\Selenium\\My Workspace\\DOL\\TWC\\Data\\Screenshots\\" + "Test_002_" + timeStamp + ".png"));
                FileUtils.copyFile(source, new File(".\\Data\\Screenshots\\" + result.getName() + "_" + timeStamp + ".png"));
                System.out.println("Screenshot taken");
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
        log.info("driver is quiting");
        //sleepfor(2);
        driver.quit();
    }
    //get local driver
    public WebDriver getLocalDriver(String os, String browserName){

        if(browserName.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }else if(browserName.equalsIgnoreCase("chrome")){
            if(os.equalsIgnoreCase("windows")){
                System.setProperty("webdriver.chrome.driver","selenium-browser-driver\\chromedriver.exe");
            }else{
                System.setProperty("webdriver.chrome.driver", "Generic/selenium-browser-driver/chromedriver");
            }
            driver = new ChromeDriver();
        }else if(browserName.equalsIgnoreCase("safari")){
            driver = new SafariDriver();
        }else if(browserName.equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver","selenium-browser-driver\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }else if(browserName.equalsIgnoreCase("htmlunit")){
            driver = new HtmlUnitDriver();
        }

        return driver;
    }

    //get cloud driver
    public WebDriver getSauceLabDriver(String userName, String key, String os, String browserName,
                                       String browserVersion )throws IOException{

//        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platform", os);
        cap.setBrowserName(browserName);
        cap.setCapability("version", browserVersion);

        driver = new RemoteWebDriver(new URL("http://"+ userName + ":" +  key +
                "@ondemand.saucelabs.com:80/wd/hub"), cap);
        return driver;
    }

    public void sleepfor(int value)throws InterruptedException{
        int initvalue = (value *1000);
        Thread.sleep(initvalue);
    }

    public void getElementByCss(String locator, String text){
        driver.findElement(By.cssSelector(locator)).clear();
        driver.findElement(By.cssSelector(locator)).sendKeys(text);
    }

    public void getElementByXpath(String locator,String text){
        driver.findElement(By.xpath(locator)).sendKeys(text);
    }

    public void getElementByid(String locator){
        driver.findElement(By.id(locator));
    }

    public void getElementByname(String locator){
        driver.findElement(By.name(locator));
    }

    public void tonavBack(){
        driver.navigate().back();
    }

    public void tonavForward(){
        driver.navigate().forward();
    }

    public void clickByCss(String locator){
        driver.findElement(By.cssSelector(locator)).click();}

    public void clickByXpath(String locator){
        driver.findElement(By.xpath(locator)).click();}

    public void findByXpath(String locator){
        driver.findElement(By.xpath(locator));
    }

    public void getTitle(){
        driver.getTitle();
    }

    public void typeByCssThenEnter(String locator, String value ) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);

    }

    public void typeByXpathThenEnter(String locator, String value ) {
        driver.findElement(By.xpath(locator)).sendKeys(value, Keys.ENTER);

    }

    public void typeByXpath(String locator, String text){
        driver.findElement(By.xpath(locator)).sendKeys(text);
    }


    public void typeByCss(String locator, String text){
        //driver.findElement(By.cssSelector(locator)).clear();
        driver.findElement(By.cssSelector(locator)).sendKeys(text);
    }

    public void clickCheckBox(String i) {
        driver.findElement(By.id(i)).click();
    }

    public void switchWindow() {
        for(String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
            driver.manage().window().maximize();
        }
    }

    public void clearField(String locator){
        driver.findElement(By.xpath(locator)).clear();}


    public String getTodaysDate() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public String getDateOfChoose(Date date, int days) {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
        //Date date = new Date();
       // dateFormat.format(date);
        return "" + dateFormat.format(DateUtils.addDays(date, days));
    }

    public String getAttributeByXpath(String locator) {
        return driver.findElement(By.xpath(locator)).getAttribute("value");
    }

    public String getTextByXpath(String locator) {
        return driver.findElement(By.xpath(locator)).getText();
    }

    public String getCurrentMonth() {
        return "" + LocalDateTime.now().getMonthValue();
    }

    public String getCurrentDate(){
        return "" + LocalDateTime.now().getDayOfMonth();
    }

    public String getCurrentYear() {
        return "" + LocalDateTime.now().getYear();
    }

    public int increment() {
        steady = ++count;
        return count;
    }

    public int count=1000;
    public int steady;

    public void selectFromDropdown(String locator, int index) {
        Select dropdown = new Select(driver.findElement(By.xpath(locator)));
        dropdown.selectByIndex(index);
    }

    public boolean findStringIgnoreCase(String s1, String s2) {
        return StringUtils.containsIgnoreCase(s1, s2);
    }
}