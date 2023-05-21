package us.piit.tutorialsninjaPage;

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
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath = "//h2[text()='Products meeting the search criteria']")
    WebElement itemResultField;
    @FindBy(css = "#content div:nth-child(8) div div div.image")
    WebElement imgField;
    public String getSearchValidationMessage(){
        String text = getElementText(itemResultField);
        return text;
    }
    public void scrollToItemImg(WebDriver driver){
        scrollToElement(driver,imgField);
    }
}
