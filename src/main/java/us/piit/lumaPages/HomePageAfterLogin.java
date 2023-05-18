package us.piit.lumaPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class HomePageAfterLogin extends CommonAPI {
    Logger log= LogManager.getLogger(HomePageAfterLogin.class.getName());

    public HomePageAfterLogin(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='panel header']//span[@class='logged-in'][normalize-space()='Welcome, mike lee!']")
    WebElement actualMessage;

    @FindBy(css = ".message-success.success.message")
    WebElement thanksMessage;

    @FindBy(css = ".panel.header ul li:nth-child(2) span button")
    WebElement dropDownArrow;

    @FindBy(xpath = "//div[@aria-hidden='false']//a[normalize-space()='My Account']")
    WebElement myAccountLink;

    @FindBy(css = "div[aria-hidden='false'] li[data-label='or'] a")
    WebElement signOutLink;

    @FindBy(css = ".base")
    WebElement signOutConfirmationMess;


    public boolean checkDropDownVisibility(){
        boolean isDropDownVisible=isVisible(dropDownArrow);
        log.info("drop down is visible success");
        return isDropDownVisible;
    }

    public boolean checkDropDownInteractibility(){
        boolean isDropDownInteratable=isInteractable(dropDownArrow);
        log.info("drop down is interactable success");
        return isDropDownInteratable;
    }

    public void clickOnDropDown(){
        clickOn(dropDownArrow);
        log.info("click on drop down list success");
    }

    public void clickOnMyAccount(){
        clickOn(myAccountLink);
        log.info("click on My Account success");
    }

    public String getWelcomeMessage(){
        String message= getElementText(actualMessage);
        log.info("login success");
        return message;
    }

    public String getThanksMessage(){
        String accountTextInfo=getElementText(thanksMessage);
        log.info("account create success");
        return accountTextInfo;
    }

    public void clickOnSignOutLink(){
        clickOn(signOutLink);
        log.info("click on sign out link success");
    }

    public String getSignOutConfirmationText(){
        String text=getElementText(signOutConfirmationMess);
        log.info("sign out success");
        return text;
    }
}
