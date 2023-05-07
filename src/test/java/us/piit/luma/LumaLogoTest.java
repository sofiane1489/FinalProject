package us.piit.luma;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.SetUp;

public class LumaLogoTest extends SetUp{
    Logger log= LogManager.getLogger(LumaLogoTest.class.getName());
    @Test
    public void lumaLogo(){
        // website validation
        String expectedTitle="Home Page";
        String actualTitle=getCurrentTtile();
        Assert.assertEquals(expectedTitle,actualTitle);
        log.info("landed on luma home page success");

        //check the intractability of luma logo
        boolean actualResult= isInteractable("//a[@class='logo']/img");
        Assert.assertTrue(actualResult);
        log.info("luma logo is interactable");

        clickOn("#ui-id-3 span");
        log.info("click on what's new success");

        clickOn("//ul[2]//li[2]//a[1]");
        log.info("click on jackets in NEW in men's success");

        clickOn("//a[@class='logo']/img");
        log.info("click on luma logo success");

        // home page validation
        boolean actualHomePageImg=isVisible("//div[@class='blocks-promo']/a/img");
        Assert.assertTrue(actualHomePageImg);
        log.info("landed in home page success");

    }

}
