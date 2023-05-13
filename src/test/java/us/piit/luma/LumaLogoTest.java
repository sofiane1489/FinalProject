package us.piit.luma;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.lumaPages.HomePageBeforeLogin;
import us.piit.lumaPages.WhatsNewCategoryPage;

public class LumaLogoTest extends CommonAPI {
    Logger log= LogManager.getLogger(LumaLogoTest.class.getName());
    @Test
    public void lumaLogo(){
        HomePageBeforeLogin homePageBeforeLogin=new HomePageBeforeLogin(getDriver());
        WhatsNewCategoryPage whatsNewCategoryPage=new WhatsNewCategoryPage(getDriver());

        // website validation with Title
        String expextedTitle="Home Page";
        String actualTitle=getCurrentTtile();
        Assert.assertEquals(actualTitle,expextedTitle);


        // website validation with luma logo
        Assert.assertTrue( homePageBeforeLogin.homePageLogoVisibility());

        //check the intractability of luma logo
        Assert.assertTrue( homePageBeforeLogin.checkIntractabilityOfTheLogo());

        homePageBeforeLogin.clickOnWhatsNewCategory();

        whatsNewCategoryPage.clickOnJacketsINNewInMens();

        homePageBeforeLogin.clickOnLumaLogo();

        // home page validation
        Assert.assertTrue(homePageBeforeLogin.checkPresenceOfHomePageImg());

    }
}
