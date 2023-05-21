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
//
//    @FindBy(xpath = "//*[@id=header]/div[2]/div/div/nav/div[1]/a")
//    WebElement mainHeader;
//    @FindBy(xpath = "//span[text()='Jhon Claud']")
//    WebElement UserInfo;
//
//    @FindBy(xpath = "//p[text()='Welcome to your account. Here you can manage all of your personal information and orders.']")
//    WebElement welcomeUser;
//    @FindBy(css = "#contact-link")
//    WebElement contactBtn;
//    @FindBy(css = "#center_column div div ul li:nth-child(1) a")
//    WebElement addFirstAddressBtn;
//    @FindBy(css = "#block_top_menu ul li:nth-child(4) a")
//    WebElement blogBtn;
//    @FindBy(css = "#header div.nav div div nav div:nth-child(2)")
//    WebElement logoutBtn;

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
    public void hoverOverclickOnCheckoutBtn(){
        clickOn(searchBarField);
        log.info("click on checkout button success");
    }
//    public void clickOnSearchBoxBtn(){
//        clickOn(searchBoxBtn);
//        log.info("click on search box success");
//    }
//    public String getValidSearchMessage(){
//        String text = getElementText(validSearchMessage);
//        log.info("search message validation success");
//        return text;
//    }
//    public String getItemSearchConfirmation(){
//        String text = getElementText(itemSearchConfirmation);
//        log.info("search validation success");
//        return text;
//    }
//    public void clickOnDressesSectionBtn(){
//        clickOn(dressesSection);
//        log.info("click on dresses section success");
//    }
//    public String getHeaderText() {
//        String text = getElementText(mainHeader);
//        log.info("click on sign in success");
//        return text;
    }


