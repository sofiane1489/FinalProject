package us.piit.luma;

import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.lumaPages.HomePageBeforeLogin;
import us.piit.lumaPages.WhatsNewCategoryPage;

public class HomePageTest extends CommonAPI {


    @Test
     public void checkLumaLogoInteractivityAndVisibility(){
        HomePageBeforeLogin homePageBeforeLogin=new HomePageBeforeLogin(getDriver());
        WhatsNewCategoryPage whatsNewCategoryPage=new WhatsNewCategoryPage(getDriver());

        // website validation with Title
        String expextedTitle="Home Page";
        String actualTitle=getCurrentTtile();
        Assert.assertEquals(actualTitle,expextedTitle);
        // website validation with luma logo
        Assert.assertTrue( homePageBeforeLogin.checkHomePageLogoVisibility());


        //check the intractability of luma logo
        Assert.assertTrue( homePageBeforeLogin.checkIntractabilityOfTheLogo());

        homePageBeforeLogin.clickOnWhatsNewCategory();

        whatsNewCategoryPage.clickOnJacketsINNewInMens();

        homePageBeforeLogin.clickOnLumaLogo();

        // home page validation
        Assert.assertTrue(homePageBeforeLogin.checkPresenceOfHomePageImg());

    }


    @Test
    public void checkMainHomePageImageInteractivityAndVisibility(){
        HomePageBeforeLogin homePageBeforeLogin=new HomePageBeforeLogin(getDriver());

        // website validation with Title
        String expextedTitle="Home Page";
        String actualTitle=getCurrentTtile();
        Assert.assertEquals(actualTitle,expextedTitle);
        // website validation with luma logo
        Assert.assertTrue(homePageBeforeLogin.checkHomePageLogoVisibility());


        //home page main image Visibility and Interactivity validation
        Assert.assertTrue(homePageBeforeLogin.checkHomePageMainImgVisibility());
        Assert.assertTrue(homePageBeforeLogin.checkHomePageMainImgInteractivity());



    }
}
