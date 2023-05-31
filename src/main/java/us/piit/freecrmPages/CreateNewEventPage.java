package us.piit.freecrmPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class CreateNewEventPage extends CommonAPI {
    Logger log = LogManager.getLogger(CreateNewEventPage.class.getName());
    public CreateNewEventPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"main-nav\"]/div[2]/a/i")
    WebElement calandarBtn;

    @FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[2]/div/a[2]/button")
    WebElement createBtn;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div[2]/form/div[1]/div[1]/div/div/input")
    WebElement titleField;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div[2]/form/div[1]/div[1]/div/div/input")
    WebElement categoryBtn;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div[2]/form/div[3]/div[1]/div/div/div[2]/div[6]/span")
    WebElement meetingBtn;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div[2]/form/div[3]/div[1]/div/div/div[2]/div[6]/span")
    WebElement descriptionfield;

    @FindBy(xpath = "    //*[@id=\"dashboard-toolbar\"]/div[2]/div/button[2]\n")
    WebElement saveBtn;

    @FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[1]/span/span")
    WebElement evenText;


    public void calandar(){
        clickOn(calandarBtn);
        log.info("click on calandar success");
    }
    public void CreateBtnt() {
        clickOn(createBtn);
        log.info("click on create success");
    }
            public void TitleField (String title) {
                type(titleField);
                log.info("enter title success");
            }
            public void CategoryBtn () {
            clickOn(categoryBtn);
            log.info("click on category success");
        }
            public void meeting() {
                clickOn(meetingBtn);
                log.info("click on meeting success");
            }
    public void descriptionField (String description) {
        type(descriptionfield);
        log.info("enter description success");
    }
    public void setSaveBtn() {
        clickOn(saveBtn);
        log.info("click on save success");
    }
    public boolean getevenText() {
        boolean text = isVisible(evenText);
        log.info("even text visible success");
        return text;

    }



    private void type(WebElement titleField) {
    }}