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

    @FindBy(css = "div[class='panel wrapper'] li:nth-child(1) a:nth-child(1)")
    WebElement myAccountLink;

    @FindBy(css = "div[aria-hidden='false'] li[data-label='or'] a")
    WebElement signOutLink;

    @FindBy(css = ".base")
    WebElement signOutConfirmationMess;

    @FindBy(xpath = "//body/div[@class='page-wrapper']/main[@id='maincontent']/div[@class='columns']/div[@class='sidebar sidebar-additional']/div[@class='block block-compare']/div[@class='block-content']/ol[@id='compare-items']/li[1]/a[1]")
    WebElement compareProductCassiusSparkingLink;


    @FindBy(css = ".action-primary.action-accept")
    WebElement okBtn;

//    @FindBy(css = ".message-success.success.message")
//    WebElement okBtn;

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

    public void clickOnCasiusSparking(WebDriver driver){
        clickWithJavascript(driver,compareProductCassiusSparkingLink);
        log.info("click on cassius Sparking success");
    }

    public void clickOnOKAlert(WebDriver driver){
        clickWithJavascript(driver,okBtn);
        log.info("click on ok Btn success");
    }

    public String getRemoveProductConfirmationText(){
        String text=getElementText(thanksMessage);
        log.info("sign out success");
        return text;
    }
}
