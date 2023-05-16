package us.piit.automationPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class ProductsPage extends CommonAPI {
    Logger log= LogManager.getLogger(ProductsPage.class.getName());
    public ProductsPage(WebDriver driver){
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath = "//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/a[1]")
    WebElement clickonproductbtn;
    @FindBy(xpath = "//body/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/a[1]")
    WebElement clickonviewproduct;
    @FindBy(xpath = "//body/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]")
    WebElement clickonaddtocart;
    @FindBy(xpath = "//u[contains(text(),'View Cart')]")
    WebElement clickonviewcart;
    @FindBy(xpath = "//a[contains(text(),'Proceed To Checkout')]")
    WebElement proceedtocheckout;
    @FindBy(xpath = "")
    WebElement validText;
    @FindBy(xpath = "//input[@id='search_product']")
    WebElement entervalidproduct;
    @FindBy(xpath = "//button[@id='submit_search']")
    WebElement clickonsearchbutton;


    public void productButton(){
        clickOn(clickonproductbtn);
        log.info("click on product button success");
    }
    public void viewProduct(){
        clickOn(clickonviewproduct);
        log.info("click on view product success");
    }
    public void addToCart(){
        clickOn(clickonaddtocart);
        log.info("click on add to cart  success");
    }
    public void viewCart(){
        clickOn(clickonviewcart);
        log.info("click on view cart  success");
    }
    public void enterproduct(String productName){
        type(entervalidproduct,productName);
        log.info("enter products name success");
    }
    public void submitsearch(){
        clickOn(clickonsearchbutton);
        log.info("click on search button success");
    }


    }

