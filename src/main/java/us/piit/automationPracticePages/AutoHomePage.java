package us.piit.automationPracticePages;


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
    @FindBy(css = "#searchbox button")
    WebElement searchBoxBtn;
    @FindBy(css = "#search_query_top")
    WebElement searchBarField;
    @FindBy(css = "#center_column h1 span.heading-counter")
    WebElement validSearchMessage;
    @FindBy(css = "#center_column > h1 > span.lighter")
    WebElement itemSearchConfirmation;
    @FindBy(xpath = "//*[@id=block_top_menu]/ul/li[2]/a")
    WebElement dressesSection;

    @FindBy(xpath = "//*[@id=header]/div[2]/div/div/nav/div[1]/a")
    WebElement mainHeader;

    @FindBy(css = "#header > div.nav > div > div > nav > div:nth-child(1) > a")
    WebElement welcomeUser;
    @FindBy(css = "#contact-link")
    WebElement contactBtn;
    @FindBy(css = "#center_column > div > div > ul > li:nth-child(1) > a")
    WebElement addFirstAddressBtn;
    @FindBy(css = "#block_top_menu > ul > li:nth-child(4) > a")
    WebElement blogBtn;
    @FindBy(css = "#header > div.nav > div > div > nav > div:nth-child(2)")
    WebElement logoutBtn;
    public void clickOnLogoutBtn(){
        clickOn(logoutBtn);
        log.info("click on logout button success");
    }
    public void clickOnBlogBtn(){
        clickOn(blogBtn);
        log.info("click on blog button success");
    }
    public void clickOnAddFirstAddressBtn(){
        clickOn(addFirstAddressBtn);
        log.info("click on add first address button success");
    }

    public void clickOnContactBtn(){
        clickOn(contactBtn);
        log.info("click on contact button success");
    }

    public void searchQueryItem(String itemName){
        type(searchBarField,itemName);
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
    public String getHeaderText() {
        String text = getElementText(mainHeader);
        log.info("click on sign in success");
        return text;
    }

    public String getWelcomeMessage(){
        String text=getElementText(welcomeUser);
        log.info("get text success");
        return text;
    }
}
