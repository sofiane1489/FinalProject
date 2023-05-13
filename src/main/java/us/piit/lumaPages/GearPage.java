package us.piit.lumaPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class GearPage extends CommonAPI {

    Logger log= LogManager.getLogger(GearPage.class.getName());

    public GearPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "div[class='sidebar sidebar-main'] div[class='widget block block-static-block'] li:nth-child(2) a:nth-child(1)")
    WebElement fitnessEquipmentSection;

    @FindBy(xpath = "//ol[@class='items']//a[normalize-space()='Watches']")
    WebElement watchesSection;


    public void clickOnFitnessEquipment(){
        clickOn(fitnessEquipmentSection);
        log.info("click on Fitness Equipment success");
    }

    public void clickOnWatchesSection(){
        clickOn(watchesSection);
        log.info("click on Watches success");
    }

}
