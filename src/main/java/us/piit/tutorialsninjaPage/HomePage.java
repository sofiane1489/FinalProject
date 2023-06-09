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
    @FindBy(xpath = "//h2[text()='My Account']")
    WebElement userAccountField;
    @FindBy(css = "#search input")
    WebElement searchBarField;
    @FindBy(css = "#search span")
    WebElement searchBtn;
    @FindBy(css = "#menu div.collapse.navbar-collapse.navbar-ex1-collapse ul li:nth-child(6) a")
    WebElement phonesAndPDAsSection;
    @FindBy(css = "#cart button")
    WebElement itemCartCount;
    @FindBy(css = "#cart ul li:nth-child(2) div p a:nth-child(2)")
    WebElement checkoutBtn;
    @FindBy(css = "#column-right div a:nth-child(13)")
    WebElement logoutBtn;
    @FindBy(css = "#column-right div a:nth-child(2)")
    WebElement editAccountBtn;
    @FindBy(css = "#account-account div.alert.alert-success.alert-dismissible")
    WebElement editMessageConfirmation;
    @FindBy(css = "#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(5) > a")
    WebElement softwareBtn;
    @FindBy(css = "#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(4) > a")
    WebElement tabletsBtn;
    @FindBy(css = "#menu div.collapse.navbar-collapse.navbar-ex1-collapse ul li:nth-child(3) a")
    WebElement componentsSection;
    @FindBy(css = "#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li.dropdown.open > div > a")
    WebElement showAllComponentsBtn;
    @FindBy(css = "#menu div.collapse.navbar-collapse.navbar-ex1-collapse ul li:nth-child(7) a")
    WebElement camerasSection;
    @FindBy(css = "#wishlist-total span")
    WebElement mainHeader;
    @FindBy(css = "#content ul:nth-child(8) li a")
    WebElement newsLetter;
    @FindBy(css = "#account-account div.alert.alert-success.alert-dismissible")
    WebElement subscriptionValidation;

    @FindBy(css = "#content ul:nth-child(4) li:nth-child(1) a")
    WebElement myOrderField;
    @FindBy(css = "body footer div div div:nth-child(2) ul li:nth-child(1) a")
    WebElement contactUsBtn;
    @FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[2]/a")
    WebElement laptopsAndNotebooksBtn;
    @FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[2]/div/a")
    WebElement laptopsAndNotebooksSection;
    @FindBy(css = "#cart ul li:nth-child(2) div p a:nth-child(1)")
    WebElement viewCartBtn;
    @FindBy(css = "#menu div.collapse.navbar-collapse.navbar-ex1-collapse ul li:nth-child(1) a")
    WebElement desktopsBtn;
    @FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[1]/div/a")
    WebElement showAllDesktopsBtn;
    @FindBy(css = "body footer div div div:nth-child(3) ul li:nth-child(4) a")
    WebElement specialsBtn;

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

    public void clickOnSItemCartCount(){
        clickOn(itemCartCount);
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
        log.info(text);
        return  text;
    }
    public void clickOnSoftwareSectionBtn(){
        clickOn(softwareBtn);
        log.info("click software section button success");
    }
    public void clickOnTabletsSectionBtn(){
        clickOn(tabletsBtn);
        log.info("click tablets section button success");
    }
   public void hoverOverAndClickOnComponentsSection(){
        clickOn(componentsSection);
        log.info("hover over and click on components section success");
   }
   public void clickOnShowAllComponentsBtn(){
        clickOn(showAllComponentsBtn);
        log.info("click on show all components button success");
   }
   public void clickOnViewYourOrderHistory(){
        clickOn(myOrderField);
        log.info("click on view order history success");
   }

   public void clickOnCamerasSectionBtn(){
        clickOn(camerasSection);
        log.info("click on cameras section button success");
   }
   public boolean checkPresenceOfNumberOfItemInWishList(){
        boolean NumberOfItemInWishListIsDisplayed = isVisible(mainHeader);
        log.info("number of items added to wish list is visible");
        return NumberOfItemInWishListIsDisplayed;
   }
   public void clickOnSubscribeOrUnsubscribe(){
        clickOn(newsLetter);
        log.info("click on subscribe or unsubscribe success");
   }
   public String getSubscriptionConfirmationMessage(){
        String text = getElementText(subscriptionValidation);
        log.info("get text message success");
        return text;
   }
    public void scrollToContactUsBtn(WebDriver driver){
        scrollToElement(driver,contactUsBtn);
        contactUsBtn.click();
        log.info("scroll down success");
    }
    public void hoverOverAndclickOnLaptopsAndNotebooksBtn(){
        clickOn(laptopsAndNotebooksBtn);
        log.info("click on laptops&notebooks success");
    }
    public void clickOnShowAllLaptopsAndNotebooks(){
        clickOn(laptopsAndNotebooksSection);
        log.info("click on show all laptops&notebooks success");
    }

    public boolean checkCountOfItemsAddedToCart(){
        boolean countOfItemsAddedToCartIsDisplayed = isVisible(itemCartCount);
        log.info("count of items added to cart is visible");
        return countOfItemsAddedToCartIsDisplayed;
    }
    public boolean checkQuantityOfItemsAddedToCart(){
        boolean quantityOfItemsAddedToCartIsDisplayed = isVisible(itemCartCount);
        log.info("quantity of item added to cart is visible");
        return quantityOfItemsAddedToCartIsDisplayed;
    }
    public void clickOnViewCartBtn(){
        clickOn(viewCartBtn);
        log.info("click on view cart button success");
    }
    public void hoverOverAndClickOnDesktopsBtn(){
        clickOn(desktopsBtn);
        log.info("click on desktops button");
    }
    public void clickOnShowAllDesktopsBtn(){
        clickOn(showAllDesktopsBtn);
        log.info("click on show all desktops success");
    }
    public void scrollToSpecialsBtn(WebDriver driver){
        scrollToElement(driver,specialsBtn);
        specialsBtn.click();
        log.info("click on specials button success");
    }
}


