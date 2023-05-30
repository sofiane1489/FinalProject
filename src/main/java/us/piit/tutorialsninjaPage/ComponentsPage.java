package us.piit.tutorialsninjaPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class ComponentsPage extends CommonAPI {
    Logger log= LogManager.getLogger(ComponentsPage.class.getName());
    public ComponentsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#content h2")
    WebElement sectionName;
    public String getValidSectionName(){
        String text = getElementText(sectionName);
        log.info("get valid section name success");
        return text;
    }
}
