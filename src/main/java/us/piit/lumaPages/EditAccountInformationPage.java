package us.piit.lumaPages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class EditAccountInformationPage extends CommonAPI {

    Logger log= LogManager.getLogger(EditAccountInformationPage.class.getName());

    public EditAccountInformationPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='lastname']")
    WebElement lastNameField;

    @FindBy(css = "button[title='Save'] span")
    WebElement saveBtn;

    @FindBy(css = "div[class='sidebar sidebar-main'] li:nth-child(2) a")
    WebElement myOrdersBtn;


    public void deleteLastName(){
        delete(lastNameField);
        log.info("delete element success");
    }

    public void enterNewLastName(String newLastName){
        type(lastNameField,newLastName);
        log.info("type last name success");
    }
    public void clickOnSaveBtn(){
        clickOn(saveBtn);
        log.info("click on save button success");
    }

    public void clickOnMyOrdersBtn(WebDriver driver){
        clickWithJavascript(driver,myOrdersBtn);
        log.info("click on my orders button success");
    }

}
