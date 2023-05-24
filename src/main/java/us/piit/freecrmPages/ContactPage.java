package us.piit.freecrmPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class ContactPage extends CommonAPI {
    Logger log = LogManager.getLogger(ContactPage.class.getName());
    public ContactPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[@id=\"main-nav\"]/div[2]/a/span")
    WebElement contactBtn;
    @FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[2]/div/a[2]/button/i")
    WebElement createBtn;
    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div[2]/form/div[1]/div[1]/div/div/input")
    WebElement titleField;
    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div[2]/form/div[4]/div[1]/div/textarea")
    WebElement descriptionField;

    @FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[2]/div")
    WebElement saveBtn;


    @FindBy(xpath = "//body/div[@id='contact-page']/div[2]/div[1]/div[1]/div")
    WebElement contactSavedSucces;
    public void contact(){
        clickOn(contactBtn);
        log.info("click on contact success");
    }
    public void NewBtnt(){
        clickOn(createBtn);
        log.info("click on newt success");
    }
    public void enterSubject(String subject) {
        type(titleField,"son");
        log.info("enter title success");
    }
    public void enterdescription(String description){
        type(descriptionField,description);
        log.info("enter text description success");
    }
    public void clickonsavebutton(){
        clickOn(saveBtn);
        log.info("click on save button success");
    }
    public String getMessage(){
        String text=getElementText(contactSavedSucces);
        log.info("success message displayed");
        return  text;

    }



}






