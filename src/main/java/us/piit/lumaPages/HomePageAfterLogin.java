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

    @FindBy(css = "div[class='box box-information'] p")
    WebElement accountInfo;


    public String getWelcomeMessage(){
        String message= getElementText(actualMessage);
        log.info("login success");
        return message;
    }

    public String getAccountMessageInfo(){
        String accountTextInfo=getElementText(accountInfo);
        log.info("account create success");
        return accountTextInfo;
    }
}
