package us.piit.lumaPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class HomePageBeforeLogin extends CommonAPI {
    Logger log= LogManager.getLogger(HomePageBeforeLogin.class.getName());

    public HomePageBeforeLogin(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@aria-label='store logo']//img")
    WebElement logoVisibility;

    @FindBy(css="body div.page-wrapper header div.panel.wrapper div ul li.authorization-link a")
    WebElement signinBtn;

    @FindBy(css="#search")
    WebElement searchBarField;

    @FindBy(xpath = "//a[@class='logo']/img")
    WebElement logo;

    @FindBy(xpath = "//div[@class='panel header']//a[normalize-space()='Create an Account']")
      WebElement createAnAccount;

    @FindBy(css = "#ui-id-3 span")
    WebElement whatsNewCategory;

    @FindBy(xpath = "//div[@class='blocks-promo']/a/img")
    WebElement homePageImg;

    @FindBy(xpath = "//a[text()='Contact Us']")
    WebElement contactUsBtn;

    @FindBy(css = ".panel.header ul li:nth-child(2) span button")
    WebElement dropDownArrow;

    @FindBy(xpath = "//div[@aria-hidden='false']//a[normalize-space()='My Account']")
    WebElement myAccountLink;

    @FindBy(css = "#ui-id-5 > span:nth-child(2)")
    WebElement menCategory;

    @FindBy(css = "#ui-id-6")
    WebElement gearCategory;

    @FindBy(css="span[data-bind=\"css: { empty: !!getCartParam('summary_count') == false && !isLoading() }, blockLoader: isLoading\"]")
    WebElement shoppingCartIcon;

    @FindBy(css = "#top-cart-btn-checkout")
    WebElement proceedToCheckOutBtn;

    @FindBy(xpath = "//span[text()='View and Edit Cart']")
    WebElement viewAndEditLink;

    @FindBy(xpath = "//ul[@id='ui-id-2']")
    WebElement navigaetMenuBar;

    @FindBy(css = "#ui-id-4")
    WebElement womenCategory;

    @FindBy(css = "#ui-id-7")
    WebElement trainingCategory;

    @FindBy(css = "#ui-id-8")
    WebElement saleCategory;


    public boolean checkHomePageLogoVisibility(){
        boolean title= isVisible(logoVisibility);
        log.info("landed on luma login page success");
        return title;
    }
    public void clickOnSigninBtn(){
        clickOn(signinBtn);
        log.info("click on sign in success");
    }
    public void typeInSearchBarAndClickEnter(String searchItem){
        typeEnter(searchBarField,searchItem);
        log.info("type text and hit enter success");
    }

    public void clickOnCreateAnAccountLink(){
        clickOn(createAnAccount);
        log.info("click on create account success");
    }

    public boolean checkIntractabilityOfTheLogo(){
        boolean check=isInteractable(logo);
        log.info("luma logo is interactable");
        return check;
    }
    public void clickOnLumaLogo(){
        clickOn(logo);
        log.info("click on luma logo success");
    }

    public void clickOnWhatsNewCategory(){
        clickOn(whatsNewCategory);
        log.info("click on what's new success");
    }

    public boolean checkPresenceOfHomePageImg(){
        boolean img=isVisible(homePageImg);
        log.info("home page image displayed"+img);
        return img;
    }
    public void clickOnContactUsBnt(){
        clickOn(contactUsBtn);
        log.info("click on contact us success");

    }

    public boolean checkDropDownVisibility(){
        boolean isDropDownVisible=isVisible(dropDownArrow);
        log.info("drop down is visible success");
        return isDropDownVisible;
    }

    public boolean checkDropDownInteractibility(){
        boolean isDropDownInteratable=isInteractable(dropDownArrow);
        log.info("drop down is interactable success");
        return isDropDownInteratable;
    }

    public void clickOnDropDown(){
        clickOn(dropDownArrow);
        log.info("click on drop down list success");
    }

    public void clickOnMyAccount(){
        clickOn(myAccountLink);
        log.info("click on My Account success");
    }

    public void clickOnMenCategory(){
        clickOn(menCategory);
        log.info("click on men category success");
    }

    public void clickOnGearcategory(){
        clickOn(gearCategory);
        log.info("click over Gear category success");
    }


    public void clickOnShoppingCartIcon(){
        clickOn(shoppingCartIcon);
        log.info("click on shopping cart success");
    }

    public void clickOnProceedToCheckOutBtn(){
        clickOn(proceedToCheckOutBtn);
        log.info("click on proceed to checkout  cart success");
    }

    public void clickOnviewAndEditLink(){
        clickOn(viewAndEditLink);
        log.info("click on view and edit success");
    }

    public boolean checkNavigateMenuVisibility(){
        boolean menu=isVisible(navigaetMenuBar);
        log.info("navigate menu is visible");
        return menu;
    }

    public boolean checkNavigateMenuInteractability(){
        boolean interatable=isInteractable(navigaetMenuBar);
        log.info("navigate menu is interactable");
        return interatable;
    }

    public void clickOnWomenCategory(){
        clickOn(womenCategory);
        log.info("click on women category succcess");
    }
    public void clickOnTrainingCategory(){
        clickOn(trainingCategory);
        log.info("click on Training category succcess");
    }
    public void clickOnSaleCategory(){
        clickOn(saleCategory);
        log.info("click on sale category succcess");
    }

}
