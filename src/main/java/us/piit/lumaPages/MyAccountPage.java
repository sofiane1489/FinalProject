package us.piit.lumaPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class MyAccountPage extends CommonAPI {

    Logger log= LogManager.getLogger(MyAccountPage.class.getName());

    public MyAccountPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@href='https://magento.softwaretestingboard.com/customer/account/edit/']//span[contains(text(),'Edit')]")
    WebElement editLink;

    @FindBy(css = "div[data-bind='html: $parent.prepareMessageForHtml(message.text)']")
    WebElement editTextConfirmation;

    public void clickOnEdit(){
        clickOn(editLink);
        log.info("click on edit success");
    }

    public String getEditTextConfirmation(){
        String textConfirmation=getElementText(editTextConfirmation);
        log.info("account edit success");
        return textConfirmation;
    }

}
