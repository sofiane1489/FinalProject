package us.piit.freecrmPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class AddProductPage extends CommonAPI {
    Logger log = LogManager.getLogger(AddProductPage.class.getName());

    public AddProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//*[@id=\"top-header-menu\"]/div[2]/div[2]/div/i")
    WebElement clickonsettingbtn;
    @FindBy(xpath = "//*[@id=\"top-header-menu\"]/div[2]/div[2]/div/div/a[2]/span")
    WebElement clickonproduct;

    @FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[2]/div/a/button/i")
    WebElement clickonNew;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div[2]/form/div[1]/div[1]/div/div/input")
    WebElement enternameField;
    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div[2]/form/div[1]/div[2]/div/textarea")
    WebElement enterdescriptionField;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div[2]/form/div[3]/div[2]/div/div/input")
    WebElement enterSalePrice;
    @FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[2]/i")
    WebElement clickonsaveBtn;
    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div[2]/div/div[1]/div/div[11]/div[2]/div/div[2]/div[1]")
    WebElement CreatedAt;





    public void settingButton() {
        clickOn(clickonsettingbtn);
        log.info("click setting button success");
    }

    public void ProductBtn() {
        clickOn(clickonproduct);
        log.info("click on product success");
    }

    public void NewButton() {
        clickOn(clickonNew);
        log.info("click on new add a product  success");
    }

    public void nameField() {
        type(enternameField, "shoes");
        log.info("enter product name  success");
    }

    public void enterprice(String productName) {
        type(enterSalePrice,"45" );
        log.info("enter products price success");
    }

    public void description() {
       type(enterdescriptionField,"brand new");
        log.info("enter description text success");
    }



    public void saveProduct() {
        clickOn(clickonsaveBtn);
        log.info("click on save product success");
    }


    public boolean confirmationText() {
        boolean text = isVisible(CreatedAt);
        log.info("created confirmation text success");
        return text;

    }

}



