package us.piit.automationpractice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.SetUp;

public class LogingTest extends  SetUp{
    Logger log= LogManager.getLogger(LogingTest.class.getName());
    @Test
    public void validCredential() {
        String expectedTitle = "My Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);
        //enter  username, password, and click on login button
        clickOn("#header > div.nav > div > div > nav > div.header_user_info > a");
        type("#email","yaya@gmail.com");
        log.info("enter email success");

        type("#passwd","1234abcd$");
        log.info("enter password success");

        clickOn("#SubmitLogin");
        log.info("click on login button Success");

        //check user is logged in
        String expectedHomePageHeader = "your logo";
        String actualHomePageHeader = getElementText("#header_logo > a > img");
        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
        log.info("user logged in success");
    }
//
//    @Test
//  public void invalidEmail() {
//       String expectedTitle = "nopCommerce demo store";
//      String actualTitle = getCurrentTtile();
//       Assert.assertEquals(expectedTitle, actualTitle);
//        //enter  username, password, and click on login button
//        clickOn(".ico-login");
//        type("#Email","yay@gmail.com");
//        log.info("enter email success");
//
//        type("#Password","abcd1234$");
//        log.info("enter password success");
//
//        clickOn(".button-1.login-button");
//        log.info("click on login button Success");
//
//       //validate error
//        String expectedHomePageHeader = "Login was unsuccessful. Please correct the errors and try again.\n" +
//                "No customer account found";
//        String actualHomePageHeader = getElementText(".message-error.validation-summary-errors");
//        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
//        log.info("error validate success");
//   }
//
//    @Test
//    public void missingidEmail() {
//       String expectedTitle = "nopCommerce demo store";
//       String actualTitle = getCurrentTtile();
//        Assert.assertEquals(expectedTitle, actualTitle);
//        //enter  username, password, and click on login button
//       clickOn(".ico-login");
//
//        type("#Email","");
//        log.info("enter email success");
//
//        type("#Password","abcd1234$");
//       log.info("enter password success");
//
//       clickOn(".button-1.login-button");
//        log.info("click on login button Success");
//
//       //validate error
//       String expectedHomePageHeader = "Please enter your email";
//        String actualHomePageHeader = getElementText("#Email-error");
//        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
//        log.info("error validate success");
//   }

}