package us.piit.base;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import us.piit.reporting.ExtentManager;
import us.piit.reporting.ExtentTestManager;
import us.piit.utility.Utility;
import com.github.javafaker.Faker;
public class CommonAPI {
    Logger log= LogManager.getLogger(CommonAPI.class.getName());
    Properties pro= Utility.loadProperties();

    String browserstackUsername=Utility.decode(pro.getProperty("browserstack.username"));
    String browserstackPassword=Utility.decode(pro.getProperty("browserstack.password"));
    String implicitWait=pro.getProperty("implicit.wait","5");
    String browserMaximize=pro.getProperty("browser.maximize","true");
    String takeScreenshots=pro.getProperty("take.screenshots","false");

    WebDriver driver;
    Faker faker = new Faker();


    //extent report setup from line 48 to 105
    public static com.relevantcodes.extentreports.ExtentReports extent;

    @BeforeSuite(groups="group1")
    public void extentSetup(ITestContext context) {
        ExtentManager.setOutputDirectory(context);
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod(groups="group1")
    public void startExtent(Method method) {
        String className = method.getDeclaringClass().getSimpleName();
        String methodName = method.getName().toLowerCase();
        ExtentTestManager.startTest(method.getName());
        ExtentTestManager.getTest().assignCategory(className);
    }
    protected String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }

    @AfterMethod(groups="group1")
    public void afterEachTestMethod(ITestResult result) {
        ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));
        ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));

        for (String group : result.getMethod().getGroups()) {
            ExtentTestManager.getTest().assignCategory(group);
        }

        if (result.getStatus() == 1) {
            ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
        } else if (result.getStatus() == 2) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, getStackTrace(result.getThrowable()));
        } else if (result.getStatus() == 3) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
        }
        ExtentTestManager.endTest();
        extent.flush();
        if (takeScreenshots.equalsIgnoreCase("true")){
            if (result.getStatus() == ITestResult.FAILURE) {
                takeScreenshot(result.getName());
            }
        }
        driver.quit();
    }
    @AfterSuite(groups="group1")
    public void generateReport() {
        extent.close();
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

    public void getCloudDriver(String envName,String os,String osVersion,String browserName,String browserVersion,String username,String password) throws MalformedURLException, MalformedURLException {
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability("os",os);
        cap.setCapability("os_version",osVersion);
        cap.setCapability("browser",browserName);
        cap.setCapability("browser_version",browserVersion);
        if(envName.equalsIgnoreCase("browserstack")) {
            cap.setCapability("resulution","1024x768");
            driver = new RemoteWebDriver(new URL("http://"+username+":"+password+"@hub-cloud.browserstack.com:80/wd/hub"),cap);
        }else if(envName.equalsIgnoreCase("saucelabs")){
            driver=new RemoteWebDriver(new URL("http://"+username+":"+password+"@ondemand.saucelabs.com:80/wd/hub"),cap);
        }
    }


    @Parameters("browserName")
    public void getLocalDriver(String browserName){
        if(browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            log.info("chrome browser open success");
        }else if(browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            log.info("firefox browser open success");
        } else if(browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            log.info("edge browser open success");
        }
    }
    @Parameters({"useCloudEnv","envName","os","osversion","browserName","browservesion","url"})
    @BeforeMethod(groups="group1")
    public void setup(@Optional("false") String useCloudEnv, @Optional("browserstack") String envName, @Optional("windows")  String os,
                      @Optional("11") String osversion, @Optional("chrome") String browserName,
                      @Optional("111") String browservesion, @Optional("https://www.google.com/") String url) throws MalformedURLException {
        if(useCloudEnv.equalsIgnoreCase("true")){
            getCloudDriver(envName,os,osversion,browserName,browservesion,browserstackUsername,browserstackPassword);
        } else if (useCloudEnv.equalsIgnoreCase("false")) {
            getLocalDriver(browserName);
        }
        //open the browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(implicitWait)));
        if(browserMaximize.equalsIgnoreCase("true")){
            driver.manage().window().maximize();
        }
        driver.get(url);
    }
    @AfterMethod(groups="group1")
    public void teardown(){
        //close browser
        driver.quit();
        log.info("browser close success");
    }

    /*----------------------------------------------------------------------------------------------------------------*/
    /*                                         Selenium methods                                                       */
    /*----------------------------------------------------------------------------------------------------------------*/

    public WebDriver getDriver() {
        return driver;
    }

    public String getCurrentTtile(){
        return driver.getTitle();
    }

    public String getElementText(WebElement element){
        return element.getText();
    }
    public void clickOn(WebElement element){
        element.click();
    }
    public void type(WebElement element, String text){
        element.sendKeys(text);
    }
    public void typeEnter(WebElement element,String text){
        element.sendKeys(text,Keys.ENTER);
    }

    public void select(WebElement element){
        Select select = new Select(element);
        select.getAllSelectedOptions();
    }
    public void selectBy(WebElement element,String value){
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }
    public void selectByIn(WebElement element,int value){
        Select select = new Select(element);
        select.selectByIndex(value);
    }
    public void selectByVal(WebElement element,String value){
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void delete(WebElement element){
        element.clear();
    }
    public void hoverOver(WebDriver driver,WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }


    public void hoverOverAndClickOn(WebDriver driver,WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }
    public void doubleClick(WebDriver driver,WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).doubleClick().build().perform();
    }

    public void waitFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean isVisible(WebElement element){
        return element.isDisplayed();
    }
    public boolean isInteractable(WebElement element){
        return element.isEnabled();
    }

    public boolean isChecked(WebElement element){
        return element.isSelected();
    }

    public WebElement findElement(WebDriver driver,WebElement element){
        return element;
    }

    //methods for fake credentials

    public String useFakeEmail(){
        return faker.internet().emailAddress();
    }
    public String useFakeAddress(){
        return faker.address().streetAddress();
    }
    public String useFakeCity(){
        return  faker.address().city();
    }
    public String useFakeState(){
        return faker.address().state();
    }
    public String useFakeFirstName(){
        return faker.name().firstName();
    }

    public String useFakeLastName(){
        return faker.name().lastName();
    }
    public String useFakeZipcode(){
        return faker.address().zipCode();
    }
    public String useFakePhoneNumber(){
        return faker.phoneNumber().phoneNumber();
    }
    public String useFakeCompany(){
        return faker.company().name();
    }
    public String useFakePaaword(){
        return faker.internet().password();
    }
    public String useFakeFullName(){
        return faker.name().fullName();
    }
    public String useFakeParagraph(){
        return faker.lorem().paragraph();
    }
    public String useFakeSentence(){
        return faker.lorem().sentence();
    }


//javascript methods

    public void clickWithJavascript(WebDriver driver,WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);
    }
    public void scrollToElement(WebDriver driver,WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
    }
    public void scrollToBottom(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }


    public void captureScreenshot() {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("screenshots"+File.separator+"screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void takeScreenshot(String screenshotName){
        DateFormat df = new SimpleDateFormat("MMddyyyyHHmma");
        Date date = new Date();
        df.format(date);

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(Utility.currentDir+ File.separator +"screenshots"+ File.separator + screenshotName+" "+df.format(date)+".jpeg"));
            System.out.println("Screenshot captured");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot "+e.getMessage());
        }
    }


}
