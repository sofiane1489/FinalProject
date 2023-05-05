package us.piit.automationpractice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.SetUp;
public class UserRegistration extends SetUp {
  Logger log= LogManager.getLogger(UserRegistration.class.getName());
   @Test
    public void validCredential() {
        String expectedTitle = "nopCommerce demo store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);
        //enter  username, password, and click on login button
        clickOn(".ico-register");
        clickOn("#gender-male");

        type("#FirstName","Jhon");
        log.info("enter firstname success");

        type("#LastName","Cloud");
        log.info("enter lastname success");

        clickOn("//div[@class='date-picker-wrapper']/select");
        log.info("click on day Success");
        clickOn("5");
        log.info("choose day success");
//        clickOn(".valid");
//        log.info("cl");


        //check user is logged in
        String expectedHomePageHeader = "My account";
        String actualHomePageHeader = getElementText("//div[@class='header-links-wrapper']/div/ul/li/a");
        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
        log.info("user logged in success");
    }

}

