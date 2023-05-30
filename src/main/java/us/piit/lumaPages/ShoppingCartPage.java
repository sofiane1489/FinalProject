package us.piit.lumaPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class ShoppingCartPage extends CommonAPI {
    Logger log= LogManager.getLogger(ShoppingCartPage.class.getName());

    public ShoppingCartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".action.action-delete")
    WebElement trashCanIcon;

    @FindBy(xpath = " //p[text()='You have no items in your shopping cart.']")
    WebElement removeItemsConfirmationText;


    public void clickOnTrashCanIcon(){
        clickOn(trashCanIcon);
        log.info("click on trash can icon success");
    }

    public String getRemoveConfirmationText(){
        String text=getElementText(removeItemsConfirmationText);
        log.info("item removed success");
        return text;
    }
}
