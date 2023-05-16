package us.piit.automationPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class HomePage extends CommonAPI {
    Logger log = LogManager.getLogger(HomePage.class.getName());
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(css ="div.container div.row div.col-sm-12 div.carousel.slide div.carousel-inner div.item.active:nth-child(1) div.col-sm-6:nth-child(1) > h2:nth-child(2)")
    WebElement mainHeader;
    @FindBy(xpath = "//p[contains(text(),'Congratulations! Your order has been confirmed!')]")
    WebElement welcomeMessage;
    @FindBy(xpath = "//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/a[1]")
    WebElement logoutbtn;
    @FindBy(xpath = "//b[contains(text(),'Cart is empty!')]")
    WebElement emptyCart;
    @FindBy(css = "#sale_image")
    WebElement productsvisibility;
    @FindBy(xpath = "//h2[contains(text(),'Searched Products')]")
    WebElement searchedproductvisible;



    public String getHeaderText() {
        log.info("user logged in success");
        String text=getElementText(mainHeader);
        return text;
    }
    public void clickonlogout(){
        clickOn(logoutbtn);
        log.info("click on logout success");
    }
    public String welcomingMessage(){
        String text=getElementText(welcomeMessage);
        log.info("order pay and confirm success");
        return text;
    }
    public String emtyCart(){
        String text=getElementText(emptyCart);
        log.info("product is deleted success");
        return text;
    }
    public boolean visibility(){
        boolean wraperTitle=isVisible(productsvisibility);
        log.info("products visibilities validate");
        return wraperTitle;
    }
    public boolean searchProduct(){
        boolean pageheadertitle=isVisible(searchedproductvisible);
        log.info("searched product displayed success");
        return pageheadertitle;
    }

    }

