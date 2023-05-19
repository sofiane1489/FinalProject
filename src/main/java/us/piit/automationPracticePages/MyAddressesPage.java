package us.piit.automationPracticePages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class MyAddressesPage extends CommonAPI {
    Logger log = LogManager.getLogger(MyAddressesPage.class.getName());

    public MyAddressesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#center_column div.addresses p:nth-child(1) strong")
    WebElement validationMessage;

    public String getValidationMessage() {
        String text = getElementText(validationMessage);
        log.info("get text success");
        return text;
    }
}
