package stepDef;

import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class SetUp {

    WebDriver driver;

    @Before
    public void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterStep
    public void takeScreenShoots(Scenario scenario){
        final byte [] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot,"image/png","image");
    }

    @After
    public void tearDown(){
        driver.quit();
    }

//........................................................................


    public void waitFor(int second) throws InterruptedException {
        Thread.sleep(second* 1000L);
    }

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

}
