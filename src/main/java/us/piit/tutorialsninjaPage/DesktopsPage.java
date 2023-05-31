package us.piit.tutorialsninjaPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class DesktopsPage extends CommonAPI {
    Logger log= LogManager.getLogger(DesktopsPage.class.getName());
    public DesktopsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#content h2")
    WebElement pageName;
    public String getPageName(){
        String text = getElementText(pageName);
        log.info("get page name success");
        return text;
    }
}
