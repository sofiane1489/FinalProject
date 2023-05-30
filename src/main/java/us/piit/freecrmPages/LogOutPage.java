package us.piit.freecrmPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class LogOutPage extends CommonAPI {
    Logger log = LogManager.getLogger(LogOutPage.class.getName());

    public LogOutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"top-header-menu\"]/div[2]/div[2]/div/i")
    WebElement clickonsettingbtn;
    @FindBy(xpath = "//*[@id=\"top-header-menu\"]/div[2]/div[2]/div/div/a[7]/span")
    WebElement clickonLogOutbtn;
    @FindBy(xpath = "//*[@id=\"ui\"]/div/div/form/div/div[3]")
    WebElement lougoutSucces;

    public void settingbtn() {
        clickOn(clickonsettingbtn);
        log.info("click on setting success");
    }

    public void logoutbtn() {
        clickOn(clickonLogOutbtn);
        log.info("click on logout success");}
        public String validationLogoutMessage () {

        String text = getElementText(lougoutSucces);
        log.info("user logout success");
        return text;
    }
}