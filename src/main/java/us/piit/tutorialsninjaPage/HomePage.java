package us.piit.tutorialsninjaPage;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class HomePage extends CommonAPI {
    Logger log= LogManager.getLogger(HomePage.class.getName());
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#content")
    WebElement userTableOfContentField;
    @FindBy(css = "#content h2:nth-child(1)")
    WebElement userAccountField;
    @FindBy(css = "#search input")
    WebElement searchBarField;
    @FindBy(css = "#search span")
    WebElement searchBtn;
    @FindBy(css = "#menu div.collapse.navbar-collapse.navbar-ex1-collapse ul li:nth-child(6) a")
    WebElement phonesAndPDAsSection;
    @FindBy(xpath = "//*[@id=cart]")
    WebElement shoppingCartField;
    @FindBy(css = "#cart ul li:nth-child(2) div p a:nth-child(2)")
    WebElement checkoutBtn;
    @FindBy(css = "#column-right div a:nth-child(13)")
    WebElement logoutBtn;
    @FindBy(css = "#column-right div a:nth-child(2)")
    WebElement editAccountBtn;
    @FindBy(xpath = "//*[@id=\"account-account\"]/div[1]/text()")
    WebElement editMessageConfirmation;
    @FindBy(css = "#menu div.collapse.navbar-collapse.navbar-ex1-collapse ul li:nth-child(5) a")
    WebElement softwareBtn;
    @FindBy(css = "#menu div.collapse.navbar-collapse.navbar-ex1-collapse ul li:nth-child(4) a")
    WebElement tabletsBtn;
    @FindBy(css = "#menu div.collapse.navbar-collapse.navbar-ex1-collapse ul li:nth-child(6) a")
    WebElement phonesAndPDAsBtn;

    public boolean checkPresenceOfUserTableOfContent(){
        boolean tableContentIsDisplayed =  isVisible(userTableOfContentField);
        log.info("table if content is displayed");
         return tableContentIsDisplayed;
    }
    public String getMyAccountText (){
        String text = getElementText(userAccountField);
        log.info("get message success");
        return text;
    }
    public void clickOnSearchBarAndType(String searchItem){
        typeEnter(searchBarField,searchItem);
        log.info("click on search bar and type  success");
    }
    public void clickOnSearchBtn(){
        clickOn(searchBtn);
        log.info("click on search button success");
    }
    public void clickOnPhonesAndPDAsSectionBtn(){
        clickOn(phonesAndPDAsSection);
        log.info("click on phones section button success");
    }

    public void clickOnShowItemsAddedBtn(){
        clickOn(shoppingCartField);
        log.info("click on item added button success");
    }
    public void hoverOverAndClickOnCheckoutBtn(){
        clickOn(checkoutBtn);
        log.info("click on checkout button success");
    }
    public void clickOnLogoutBtn(){
        clickOn(logoutBtn);
        log.info("click on logout button success");
    }
    public void clickOnEditAccountBtn(){
        clickOn(editAccountBtn);
        log.info("click on logout button success");
    }
    public String getEditAccountConfirmationMessage(){
        String text = getElementText(editMessageConfirmation);
        log.info("get text success");
        return  text;
    }
    public void clickOnSoftwareSectionBtn(){
        clickOn(softwareBtn);
        log.info("click software section button success");
    }
    public void clickOnTabletsSectionBtn(){
        clickOn(tabletsBtn);
        log.info("click stablets section button success");
    }
    public void clickOnPhonesAndPDAsBtn(){
        clickOn(phonesAndPDAsBtn);
        log.info("click phones and PDAs section button success");
    }
}


