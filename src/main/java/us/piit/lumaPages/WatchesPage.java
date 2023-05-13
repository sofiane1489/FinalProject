package us.piit.lumaPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class WatchesPage extends CommonAPI {

    Logger log= LogManager.getLogger(WatchesPage.class.getName());

    public WatchesPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//img[@alt='Dash Digital Watch']")
    WebElement dashDigitalWatch;


    public void clickOnDashDigitalWatch(){
        clickOn(dashDigitalWatch);
        log.info("click on Dash Digital Watch success");
    }
}
