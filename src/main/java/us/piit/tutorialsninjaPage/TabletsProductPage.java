package us.piit.tutorialsninjaPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class TabletsProductPage extends CommonAPI {
    Logger log= LogManager.getLogger(TabletsProductPage.class.getName());
    public TabletsProductPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#content div div.col-sm-4 div.rating p a:nth-child(7)")
    WebElement writeReviewBtn;
    @FindBy(css = "#input-review")
    WebElement reviewForm;
    @FindBy(css = "#form-review div:nth-child(5) div input[type=radio]:nth-child(6)")
    WebElement starRatingField;
    @FindBy(css = "#button-review")
    WebElement continueBtn;
    @FindBy(css = "#form-review > div.alert.alert-success.alert-dismissible")
    WebElement reviewConfirmationNotification;
    public void scrollToAddReviewBtn(WebDriver driver){
        scrollToElement(driver,writeReviewBtn);
        writeReviewBtn.click();
        log.info("click on add review button success");

    }
    public void enterComment(String comment) {
        type(reviewForm, comment);
        log.info("center comment success");
    }
    public void clickOnStarCheckBox(){
        clickOn(starRatingField);
        log.info("rate product success");
    }
    public void clickOnContinueBtn(){
        clickOn(continueBtn);
        log.info("click on continue button success");
    }
    public String getSubmissionConfirmationMessage(){
        String text = getElementText(reviewConfirmationNotification);
        log.info("get text message success");
        return text;
    }
}
