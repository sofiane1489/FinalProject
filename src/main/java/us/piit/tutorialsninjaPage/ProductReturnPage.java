package us.piit.tutorialsninjaPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class ProductReturnPage extends CommonAPI {
    Logger log= LogManager.getLogger(ProductReturnPage.class.getName());
    public ProductReturnPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#content ul:nth-child(4) li:nth-child(1) a")
    WebElement myOrderField;
    @FindBy(css = "#content div.table-responsive table tbody tr:nth-child(1) td:nth-child(7) a")
    WebElement viewBtn;
    @FindBy(css = "#content div.table-responsive table tbody tr td:nth-child(6) a.btn.btn-danger")
    WebElement returnBtn;
    @FindBy(css = "#content form fieldset:nth-child(2) div:nth-child(5) div div:nth-child(5) label input[type=radio]")
    WebElement reasonOfReturn;
    @FindBy(css = "#content form fieldset:nth-child(2) div:nth-child(6) div label:nth-child(1) input[type=radio]")
    WebElement yesBox;
    @FindBy(css = "#content form div div.pull-right input")
    WebElement submitBtn;
    @FindBy(css = "#content p:nth-child(3)")
    WebElement RequestConfirmationMessage;
    public void clickOnViewOrderHistory(){
        clickOn(myOrderField);
        log.info("click on view order history button success");
    }
    public void clickOnViewOrderBtn(){
        clickOn(viewBtn);
        log.info("click on view order summary button success");
    }
    public void ClickOnReturnBtn(){
        clickOn(returnBtn);
        log.info("click on return button success");
    }
    public void clickOnReceivedWrongItem(){
        clickOn(reasonOfReturn);
        log.info("click on wrong item box success");
    }
    public void clickOnOpenedProductStatus(){
        clickOn(yesBox);
        log.info("click on yes box success");
    }
    public void clickOnSubmitBtn(){
        clickOn(submitBtn);
        log.info("click on submit button success");
    }
    public String getRequestConfirmationSubmission(){
        String text = getElementText(RequestConfirmationMessage);
        log.info("get request confirmation success");
        return text;
    }
}
