package us.piit.lumaPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class DashDigitalWatchPage extends CommonAPI {

    Logger log= LogManager.getLogger(DashDigitalWatchPage.class.getName());

    public DashDigitalWatchPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[normalize-space()='Add to Cart']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//main[@id='maincontent']/div/div[2]/div/div/div")
    WebElement addToCartConfirmation;

    public void clickOnAddToCartBtn(){
        clickOn(addToCartBtn);
        log.info("click on Add To cart success");
    }

    public String getAddToCartConfirmationText(){
        String text=getElementText(addToCartConfirmation);
        log.info("added to cart success");
        return text;
    }


}
