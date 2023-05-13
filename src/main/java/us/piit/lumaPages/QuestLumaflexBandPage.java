package us.piit.lumaPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class QuestLumaflexBandPage extends CommonAPI {
    Logger log= LogManager.getLogger(QuestLumaflexBandPage.class.getName());

    public QuestLumaflexBandPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    @FindBy(css="#product-addtocart-button")
    WebElement addToCartBtn;

    @FindBy(css="div[role='alert']")
    WebElement textConfirmation;


    public void clickOnAddToCartBtn(){
        clickOn(addToCartBtn);
        log.info("click on add to cart button success");
    }

    public String getTextConfirmation(){
        String text=getElementText(textConfirmation);
        log.info("item added to cart success");
        return text;
    }

}
