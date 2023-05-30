package us.piit.tutorialsninjaPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class AccountInformationPage extends CommonAPI {
    Logger log = LogManager.getLogger(AccountInformationPage.class.getName());

    public AccountInformationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "#content form div div.pull-right input")
    WebElement submitBtn;


    public void clickOnSubmitBtn(){
        clickOn(submitBtn);
        log.info("click on submit button success");
    }

}
