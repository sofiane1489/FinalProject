package us.piit.tutorialsninjaPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class ContactUsPage extends CommonAPI {
    Logger log = LogManager.getLogger(ContactUsPage.class.getName());

    public ContactUsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#content div div div div:nth-child(2)")
    WebElement phoneNumber;

    public boolean checkPresenceOfValidContactService() {
        boolean phoneNumberIsDisplayed = isVisible(phoneNumber);
        log.info("get text success");
        return phoneNumberIsDisplayed;
    }
}
