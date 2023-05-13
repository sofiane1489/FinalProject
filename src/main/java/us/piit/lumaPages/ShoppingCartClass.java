package us.piit.lumaPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class ShoppingCartClass extends CommonAPI {
    Logger log= LogManager.getLogger(ShoppingCartClass.class.getName());

    public ShoppingCartClass(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='actions-toolbar']/a[2]")
    WebElement trashCanIcon;

    @FindBy(xpath = " //p[text()='You have no items in your shopping cart.']")
    WebElement removeItemsConfirmationText;


    public void clickOnTrashCanIcon(){
        clickOn(trashCanIcon);
        log.info("click on trash can icon success");
    }

    public String getRemoveConfirmationText(){
        String text=getElementText(removeItemsConfirmationText);

        return text;
    }
}
