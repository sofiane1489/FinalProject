package us.piit.lumaPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class TopsPage extends CommonAPI {
    Logger log= LogManager.getLogger(TopsPage.class.getName());

    public TopsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

   @FindBy(css="img[alt='Cassius Sparring Tank']")
    WebElement cassiusSparringTankLink;

    public void clickOnCassiusSparringTank(){
        clickOn(cassiusSparringTankLink);
        log.info("click on Cassius Sparring Tank success");
    }


}
