package us.piit.tutorialsninjaPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class WelcomePage extends CommonAPI {
    Logger log= LogManager.getLogger(WelcomePage.class.getName());
    public WelcomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#top-links ul li.dropdown a")
    WebElement mainHeader;
    @FindBy(css = "#top-links ul li.dropdown.open ul li:nth-child(2) a")
    WebElement headerLoginBtn;
    @FindBy(css = "#logo h1 a")
    WebElement logoField;
    public void clickOnMyAccountBtn(){
        clickOn(mainHeader);
        log.info("click on my account button success");
    }
    public void hoverOverAndClickOnHeaderLoginBtn(){
        clickOn(headerLoginBtn);
        log.info("click on header login button success");
    }
    public boolean checkPresenceOfTutorialsninjaWebsiteLogo(){
        boolean websiteLogoIsDisplayed = isVisible(logoField);
        log.info("website logo is visible");
        return websiteLogoIsDisplayed;
    }
}
