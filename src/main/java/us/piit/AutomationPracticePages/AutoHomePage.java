package us.piit.AutomationPracticePages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class AutoHomePage extends CommonAPI {
    Logger log= LogManager.getLogger(AutoHomePage.class.getName());
    public AutoHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id=\"searchbox\"]/button")
    WebElement searchBoxBtn;
    @FindBy(css = "#search_query_top")
    WebElement searchBarField;
    @FindBy(xpath = "//*[@id=\"center_column\"]/h1/span[2]")
    WebElement validSearchMessage;
    @FindBy(xpath = "//*[@id=\"center_column\"]/h1/span[1]")
    WebElement itemSearchConfirmation;
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
    WebElement dressesSection;


    public void searchQueryItem(String itemName){
        type(searchBarField,"itemName");
        log.info("enter item_name success");
    }
    public void clickOnSearchBarBtn(){
        clickOn(searchBarField);
        log.info("click on search button success");
    }
    public void clickOnSearchBoxBtn(){
        clickOn(searchBoxBtn);
        log.info("click on search box success");
    }
    public String getValidSearchMessage(){
        String text = getElementText(validSearchMessage);
        log.info("message validation success");
        return text;
    }
    public String getItemSearchConfirmation(){
        String text = getElementText(itemSearchConfirmation);
        log.info("search validation success");
        return text;
    }
    public void clickOnDressesSectionBtn(){
        clickOn(dressesSection);
        log.info("click on dresses section success");
    }

}
