package us.piit.luma;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.lumaPages.*;

public class NavigationMenuTest extends CommonAPI {

    @Test
    public void navigationMenu(){
        HomePageBeforeLogin homePageBeforeLogin=new HomePageBeforeLogin(getDriver());
        WhatsNewCategoryPage whatsNewCategoryPage=new WhatsNewCategoryPage(getDriver());
        WomenCategoryPage womenCategoryPage=new WomenCategoryPage(getDriver());
        MenCategoryPage menCategoryPage=new MenCategoryPage(getDriver());
        GearCategoryPage gearCategoryPage=new GearCategoryPage(getDriver());
        TrainingCategoryPage trainingCategoryPage=new TrainingCategoryPage(getDriver());
        SaleCategoryPage saleCategoryPage=new SaleCategoryPage(getDriver());


        // website validation with Title
        String expextedTitle="Home Page";
        String actualTitle=getCurrentTtile();
        Assert.assertEquals(actualTitle,expextedTitle);
        // website validation with luma logo
        Assert.assertTrue(homePageBeforeLogin.checkHomePageLogoVisibility());

        Assert.assertTrue(homePageBeforeLogin.checkNavigateMenuVisibility());

        Assert.assertTrue(homePageBeforeLogin.checkNavigateMenuInteractability());

        //what's new category validation
        homePageBeforeLogin.clickOnWhatsNewCategory();
        Assert.assertTrue(whatsNewCategoryPage.checkWhatsNewBackgroungImgVisivility());
        Assert.assertTrue(whatsNewCategoryPage.checkWhatsNewSidebarMenuVisivility());

        //Women category validation
        homePageBeforeLogin.clickOnWomenCategory();
        Assert.assertTrue(womenCategoryPage.checkWomenSideBarMenuVisibility());
        Assert.assertTrue(womenCategoryPage.checkWomenBackgroungImgVisibility());

        //Men category validation
        homePageBeforeLogin.clickOnMenCategory();
        Assert.assertTrue(menCategoryPage.checkMenSideBarMenuVisibility());
        Assert.assertTrue(menCategoryPage.checkMenBackgroungImgVisibility());

        //Gear category validation
        homePageBeforeLogin.clickOnGearcategory();
        Assert.assertTrue(gearCategoryPage.checkGearSideBarMenuVisibility());
        Assert.assertTrue(gearCategoryPage.checkGearBackgroungImgVisibility());

        //Training category validation
        homePageBeforeLogin.clickOnTrainingCategory();
        Assert.assertTrue(trainingCategoryPage.checkTrainingSideBarMenuVisibility());
        Assert.assertTrue(trainingCategoryPage.checkTrainingBackgroungImgVisibility());

        //Sale category validation
        homePageBeforeLogin.clickOnSaleCategory();
        Assert.assertTrue(saleCategoryPage.checkSaleSideBarMenuVisibility());
        Assert.assertTrue(saleCategoryPage.checkSaleBackgroungImgVisibility());
    }
}
