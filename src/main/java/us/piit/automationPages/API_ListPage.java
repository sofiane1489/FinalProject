package us.piit.automationPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;

public class API_ListPage extends CommonAPI {
    Logger log = LogManager.getLogger(API_ListPage.class.getName());

    public API_ListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(),'Below is the list of APIs for you to practice the ')]")
    WebElement RedText;
    @FindBy(xpath = "//a[normalize-space()='Home']")
    WebElement homePage;

    public boolean getRedText() {
        boolean text=isVisible(RedText);
        log.info("Red Text is visible success");
        return text;

    }
    public void clickonhomePage(){
        clickOn(homePage);
        log.info("click on homepage success");


    }
}




