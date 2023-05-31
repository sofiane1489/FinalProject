package us.piit.tutorialsninjaPage;

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
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#content form div table tbody tr td:nth-child(4) div span button.btn.btn-danger")
    WebElement removeBtn;
    @FindBy(css = "#content p")
    WebElement productRemoveConfirmation;
    @FindBy(css = "#content form div table tbody tr td:nth-child(4) div span button.btn.btn-primary")
    WebElement updateBtn;
    @FindBy(css = "#checkout-cart div.alert.alert-success.alert-dismissible")
    WebElement updateConfirmation;
    public void clickOnRemoveBtn(){
        clickOn(removeBtn);
        log.info("click on remove button success");
    }
    public String getRemoveConfirmationMessage(){
        String text = getElementText(productRemoveConfirmation);
        log.info("get text success");
        return text;
    }
    public void clickOnUpdateBtn(){
        clickOn(updateBtn);
        log.info("click on update button success");
    }
    public String getShoppingCartUpdateConfirmation(){
        String text = getElementText(updateConfirmation);
        log.info("get update tex message success");
        return text;
    }
}
