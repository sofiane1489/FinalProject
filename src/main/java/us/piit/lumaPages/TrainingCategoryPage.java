package us.piit.lumaPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class TrainingCategoryPage extends CommonAPI {

    Logger log= LogManager.getLogger(TrainingCategoryPage.class.getName());

    public TrainingCategoryPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

     @FindBy(xpath = "//div[@class=\"sidebar sidebar-main\"] ")
     WebElement trainingCategorySideBarMenu;

    @FindBy(xpath = "//img[@src='https://magento.softwaretestingboard.com/pub/media/wysiwyg/training/training-main.jpg']")
    WebElement trainingCategoryBackgroungImg;



    public boolean checkTrainingSideBarMenuVisibility(){
        boolean barMenu=isVisible(trainingCategorySideBarMenu);
        log.info("Training category side bar menu visibility success");
        return barMenu;
    }

    public boolean checkTrainingBackgroungImgVisibility(){
        boolean imgVisibility=isVisible(trainingCategoryBackgroungImg);
        log.info("Training category Backgroung Img Visibility success");
        return imgVisibility;
    }



}
