package us.piit.freecrmPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class NewTaskPage extends CommonAPI {

    Logger log = LogManager.getLogger(NewTaskPage.class.getName());
    public NewTaskPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"main-nav\"]/div[6]/a/span")
    WebElement tasksBtn;

    @FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[2]/div/a[2]/button/i")
    WebElement CreateButn;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div[2]/form/div[1]/div[1]/div/div/input")
    WebElement nameField;

    @FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[2]")
    WebElement saveBtn;

    @FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[2]")
    WebElement tasktext;


    public void tasksBtn(){
        clickOn(tasksBtn);
        log.info("click on tasks success");
    }
    public void CreateBtn() {
        clickOn(CreateButn);
        log.info("click on create success");
    }
    public void nameFielddbox (String name) {
        type(nameField);
        log.info("enter name success");
    }

    private void type(WebElement nameField) {
    }

    public void ssaveBtn() {
        clickOn(saveBtn);
        log.info("click on save success");
    }
    public boolean getecampaignText() {
        boolean text = isVisible(tasktext);
        log.info("task text visible success");
        return text;

    }





}
