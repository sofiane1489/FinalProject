package us.piit.lumaPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class FitnessEquipmentPage extends CommonAPI {

    Logger log= LogManager.getLogger(FitnessEquipmentPage.class.getName());

    public FitnessEquipmentPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css=".item.product.product-item:nth-child(6) div a span span")
    WebElement questLumaflexBand;


    public void clickOnQuestLumaflexBand(){
        clickOn(questLumaflexBand);
        log.info("click on Quest Lumaflex™ Band success");
    }

    public void ScrollToItem(WebDriver driver){
        scrollToElement(driver,questLumaflexBand);
    }
}
