package us.piit.lumaPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class CassiusSparringTankPage extends CommonAPI {

    Logger log= LogManager.getLogger(CassiusSparringTankPage.class.getName());

    public CassiusSparringTankPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="#option-label-size-143-item-167")
    WebElement sizeSLabel;

    @FindBy(css="#option-label-color-93-item-50")
    WebElement blueColorLabel;

    @FindBy(xpath="//button[@id='product-addtocart-button']")
    WebElement addToCartBtn;

    @FindBy(xpath=" //main[@id='maincontent']/div/div[2]/div/div/div")
    WebElement confirmationText;

    @FindBy(css=".base")
    WebElement itemTitle;

    @FindBy(css = "body > div:nth-child(4) > main:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > form:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(5)")
    WebElement addToCartErrorMessage;


    public void clickOnSizeLabel(){
        clickOn(sizeSLabel);
        log.info("click on size S success");
    }

    public void clickOnBlueColor(){
        clickOn(blueColorLabel);
        log.info("click on blue color success");
    }
    public void clickOnAddToCartBtn(){
        clickOn(addToCartBtn);
        log.info("click on add To cart button success");
     }

     public String getConfirmationText(){
        String text=getElementText(confirmationText);
         log.info("Add to cart item success");
        return text;
     }
     public String getErrorMessage(){
        String text=getElementText(addToCartErrorMessage);
        log.info("error meessage display success");
        return text;
     }

     public void scrollToAddToCartBtn(WebDriver driver){
        scrollToElement(driver,itemTitle);
     }


}
