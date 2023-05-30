package us.piit.freecrmPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class CreateCompanyPage extends CommonAPI {

    Logger log = LogManager.getLogger(CreateCompanyPage.class.getName());
    public CreateCompanyPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"main-nav\"]/div[4]/a/span")
    WebElement companiesBtn;

    @FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[2]/div/a/button")
    WebElement createButton;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div[2]/form/div[1]/div[1]/div/div/div/input")
    WebElement enterNameField;

    @FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[2]")
    WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[1]/span")
    WebElement companyText;



    public void companies(){
        clickOn(companiesBtn);
        log.info("click on companies success");
    }
    public void setCreateButton(){
        clickOn(createButton);
        log.info("click on create success");
    }



    public void enterName(String name){
        type(enterNameField);
        log.info("enter company name success");
    }

    private void type(WebElement enterNameField) {
    }

    public void setSaveButton(){
        clickOn(saveButton);
        log.info("click on save button success");
    }
    public String getNameText(){
        String text=getElementText(companyText);
        log.info("success name displayed");
        return  text;

    }











}
