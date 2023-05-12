package us.piit.lumaPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class SearchResultPage extends CommonAPI {
    Logger log= LogManager.getLogger(SearchResultPage.class.getName());

    public SearchResultPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='page-title-wrapper']")
    WebElement actualPageSearchTitle;

    public String PageSearchTitle(){
        String result=getElementText(actualPageSearchTitle);
        log.info("serach bar result success");
        return result;
    }
}
