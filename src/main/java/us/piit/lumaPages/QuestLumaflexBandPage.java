package us.piit.lumaPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class QuestLumaflexBandPage extends CommonAPI {
    Logger log= LogManager.getLogger(QuestLumaflexBandPage.class.getName());

    public QuestLumaflexBandPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    @FindBy(css="#product-addtocart-button")
    WebElement addToCartBtn;

    @FindBy(css="div[role='alert']")
    WebElement textConfirmation;

    @FindBy(css=" a[href='https://magento.softwaretestingboard.com/quest-lumaflex-trade-band.html#review-form']")
    WebElement addReviewLink;

    @FindBy(css="#Rating_5_label")
    WebElement ratingField;

    @FindBy(css="#nickname_field")
    WebElement nicknameField;

    @FindBy(css=" #summary_field")
    WebElement summaryField;

    @FindBy(css="#review_field")
    WebElement reviewField;

    @FindBy(css="button[class='action submit primary']")
    WebElement submitReviewBtn;

    @FindBy(css=".message-success.success.message")
    WebElement submitReviewConfirmationText;

    @FindBy(xpath="//div[@id='ratings[4]-error']")
    WebElement errorText;



    public void clickOnAddToCartBtn(){
        clickOn(addToCartBtn);
        log.info("click on add to cart button success");
    }

    public String getTextConfirmation(){
        String text=getElementText(textConfirmation);
        log.info("item added to cart success");
        return text;
    }
    public void clickOnAddReviewLink(){
        clickOn(addReviewLink);
        log.info("click on review success");
    }


    public void selectRating(WebDriver driver){
        doubleClick(driver,ratingField);
        log.info("hover over rating success");
    }

    public void enterNickname(String text){
        type(nicknameField,text);
        log.info("enter nick name success");
    }

    public void enterSummary(String summary){
        type(summaryField,summary);
        log.info("enter summary success");
    }
    public void enterReviewText(String review){
        type(reviewField,review);
        log.info("enter review success");

    }
    public String getSubmitTextConfirmation(){
        String text=getElementText(submitReviewConfirmationText);
        log.info("submit review success");
        return text;
    }

    public void clickOnSubmit(WebDriver driver){
        clickWithJavascript(driver,submitReviewBtn);
    }

    public String getErrorMessage(){
        String text=getElementText(errorText);
        log.info("review not submitted success");
        return text;
    }
}
