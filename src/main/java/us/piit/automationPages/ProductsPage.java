package us.piit.automationPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class ProductsPage extends CommonAPI {
    Logger log = LogManager.getLogger(ProductsPage.class.getName());

    public ProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/a[1]")
    WebElement clickonproductbtn;
    @FindBy(xpath = "//body/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/a[1]")
    WebElement clickonviewproduct;

    @FindBy(xpath = "//input[@id='quantity']")
    WebElement typeenterquantity;

    @FindBy(xpath = "//body/section[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/span[1]/button[1]")
    WebElement clickonaddtocart;
    @FindBy(xpath = "//u[contains(text(),'View Cart')]")
    WebElement clickonviewcart;

    @FindBy(xpath = "//input[@id='search_product']")
    WebElement entervalidproduct;
    @FindBy(xpath = "//button[@id='submit_search']")
    WebElement clickonsearchbutton;
    @FindBy(xpath = "//textarea[@id='review']")
    WebElement productReview;
    @FindBy(xpath = "//input[@id='name']")
    WebElement name2Field;
    @FindBy(xpath = "//input[@id='email']")
    WebElement email2Field;
    @FindBy(xpath = "//button[@id='button-review']")
    WebElement clicksubmitbutton;
    @FindBy(xpath = "//h2[contains(text(),'Category')]")
    WebElement categoryText;
    @FindBy(xpath = "//a[normalize-space()='Women']")
    WebElement womenCategory;
    @FindBy(xpath = "//h2[contains(text(),'Brands')]")
    WebElement brandText;



    public void productButton() {
        clickOn(clickonproductbtn);
        log.info("click on product button success");
    }

    public void viewProduct() {
        clickOn(clickonviewproduct);
        log.info("click on view product success");
    }

    public void addToCart() {
        clickOn(clickonaddtocart);
        log.info("click on add to cart  success");
    }

    public void viewCart() {
        clickOn(clickonviewcart);
        log.info("click on view cart  success");
    }

    public void enterproduct(String productName) {
        type(entervalidproduct, productName);
        log.info("enter products name success");
    }

    public void submitsearch() {
        clickOn(clickonsearchbutton);
        log.info("click on search button success");
    }

    public void updateQuantity() {
        typeEnter(typeenterquantity, "1");


    }

    public void name2(String name2) {
        type(name2Field, name2);
        log.info("name enter success");
    }

    public void email2(String email2) {
        type(email2Field, email2);
        log.info("email enter success");
    }

    public void review() {
        type(productReview, "what a good item");
        log.info("write review success");
    }

    public void submitreview() {
        clickOn(clicksubmitbutton);
        log.info("click on submit review success");
    }

    public boolean getCtegoryText() {
        boolean text = isVisible(categoryText);
        log.info("category text visible success");
        return text;
    }

    public void clickonwomencategory() {
        clickOn(womenCategory);
        log.info("click on women category success");
    }

    public boolean getBrandText() {
        boolean text = isVisible(brandText);
        log.info("brand text visible success");
        return text;

    }

}

