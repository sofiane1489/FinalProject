package us.piit.freecrm;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;

public class signUpTest extends CommonAPI {
    Logger log= LogManager.getLogger(signUpTest.class.getName());

    @Test
    public void validCredentials(){
        // website validation with login button
        boolean actualTitle=isVisible("btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left");
        Assert.assertTrue(actualTitle);
        log.info("landed on freecrm home page success");

        clickOn("btn btn-sm btn-white btn-icon btn-icon-left btn-shadow btn-border btn-rect offset-sm-top-60 offset-top-30");
        log.info("click Sign up  success");

        type("#email","bestfred00@gmail.com");
        log.info("enter email  success");

        type("#firstname","john");
        log.info("enter name  success");

        clickOn("checkbox");
        log.info("click on checkbox  success");

        clickOn("recaptcha-checkbox-border");
        log.info("click recaptcha checkbox  success");

        clickOn("action");
        log.info("click Signup  success");
// after validate your email


        type("#account_name","gost");
        log.info("enter company name success");

        type("#first_name","farid");
        log.info("enter first name success");

        type("#last_name","oularbi");
        log.info("enter last name success");

        type("#password","Abcd@1234");
        log.info("enter password success");

        type("#password_confirm","Abcd@1234");
        log.info("reenter password success");

        clickOn("ui fluid primary button");
        log.info("click on Sign up success");

        type("#text","bestfred00@gmail.com");
        log.info("enter email  success");

        type("#Password","Abcd@1234");
        log.info("enter password success");


        clickOn("ui fluid large blue submit button");
        log.info("click on Login success");


        //check user is logged in
        String expectedHomePageHeader = "Contacts activity stream";
        String actualHomePageHeader = getElementText("#header");
        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
        log.info("user logged in success");

    }

    private String getElementText(String s) {
        return s;
    }

    private void type(String s, String oularbi) {

    }

    private void clickOn(String s) {

    }

    private boolean isVisible(String s) {
        return false;
    }


}

//    @Test
//  public void invalidEmail() {
//        boolean actualTitle = isVisible("btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left");
//        Assert.assertTrue(actualTitle);
//        log.info("landed on freecrm home page success");
//
//        //enter  email, password, and click on login button
//        clickOn("icon icon-xs mdi-chart-bar");
//        log.info("landed to login page success");
//
//        type("email", "abc123@gmail.com");
//        log.info("enter email success");
//
//        type("password", "Abcd@1234");
//        log.info("enter password success");
//
//        clickOn("ui fluid large blue submit button");
//        log.info("click on login button Success");
//
//        //validate error email
//        String expectedHomePageHeader = "Something went wrong...\n" +
//                "Invalid login";
//        String actualHomePageHeader = getElementText("Something went wrong...");
//        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
//        log.info("error validate wrong email success");
//    }
//   }