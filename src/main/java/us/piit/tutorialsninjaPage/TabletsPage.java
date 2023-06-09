package us.piit.tutorialsninjaPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class TabletsPage extends CommonAPI {
    Logger log= LogManager.getLogger(TabletsPage.class.getName());
    public TabletsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#content  h2")
    WebElement sectionTabValidation;
    @FindBy(css = "#content div:nth-child(3) div div div.image a img")
    WebElement productImg;
    public String getTabSectionValidation(){
        String text = getElementText(sectionTabValidation);
        log.info("get message success");
        return text;
    }
    public void clickOnProductImg(){
        clickOn(productImg);
        log.info("click on product success");
    }
}
