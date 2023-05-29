package us.piit.freecrmPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class DeleteContactPage extends CommonAPI {
    Logger log = LogManager.getLogger(DeleteContactPage.class.getName());
    public DeleteContactPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div/div[1]/div/div[2]/div/div/div[2]/div/div[2]/div[2]/div[1]/span/a")
    WebElement contactName;
    @FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[4]/i")
    WebElement trashBtn;
    @FindBy(xpath = "/html/body/div[3]/div/div[3]/button[2]")
    WebElement contactDeleteSucces;
    public void contact(){
        clickOn(contactName);
        log.info("click on contact succes");
    }
    public void TrashBtn(){
        clickOn(trashBtn);
        log.info("click on trash icon success");
    }
    public void deleteBtn(){
        clickOn(contactDeleteSucces);
        log.info("contact delete succes");
    }

}
