package us.piit.automationPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class WomensProductPage extends CommonAPI {
    Logger log = LogManager.getLogger(WomensProductPage.class.getName());
    public WomensProductPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[normalize-space()='Tops']")
    WebElement womenTopsProduct;

    public void clickonTops(){
        clickOn(womenTopsProduct);
        log.info("clickon tops products success");
    }
}
