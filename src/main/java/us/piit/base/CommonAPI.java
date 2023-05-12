package us.piit.base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
public class CommonAPI {
    Logger log= LogManager.getLogger(CommonAPI.class.getName());
    WebDriver driver;
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
    @BeforeMethod
    public void setup(@Optional("false") String useCloudEnv, @Optional("browserstack") String envName, @Optional("windows")  String os,
                      @Optional("11") String osversion, @Optional("chrome") String browserName,
                      @Optional("111") String browservesion, @Optional("https://www.google.com/") String url) throws MalformedURLException {
        if(useCloudEnv.equalsIgnoreCase("true")){
            getCloudDriver(envName,os,osversion,browserName,browservesion,"sofianesehad_ClW76g","2f3G7QUqgScR9c7bbahr");
        } else if (useCloudEnv.equalsIgnoreCase("false")) {
            getLocalDriver(browserName);
        }
        //open the browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);
    }
    @AfterMethod
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
            element.sendKeys(Keys.DELETE);
    }
    public void hoverOver(WebElement element){
        Actions action=new Actions(driver);
            action.moveToElement(element).build().perform();
    }
    public void doubleClickOn(WebElement element){
        Actions action=new Actions(driver);
            action.doubleClick(element).build().perform();
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
        try{
            return element.isSelected();
        }catch (Exception e){
            return element.isSelected();
        }
    }

}
