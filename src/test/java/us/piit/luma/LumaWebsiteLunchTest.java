package us.piit.luma;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.lumaPages.HomePageBeforeLogin;

public class LumaWebsiteLunchTest extends CommonAPI {

    @Test
    public void lumaWebsiteTest(){
        HomePageBeforeLogin homePageBeforeLogin=new HomePageBeforeLogin(getDriver());

        // website validation with Title
        String expextedTitle="Home Page";
        String actualTitle=getCurrentTtile();
        Assert.assertEquals(actualTitle,expextedTitle);

        //website validation with luma logo
        Assert.assertTrue(homePageBeforeLogin.checkHomePageLogoVisibility());

        Assert.assertTrue(homePageBeforeLogin.checkPresenceOfHomePageImg());
    }
}
