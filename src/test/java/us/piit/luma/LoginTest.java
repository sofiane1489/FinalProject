package us.piit.luma;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.SetUp;

public class LoginTest extends SetUp {
    Logger log= LogManager.getLogger(LoginTest.class.getName());
    @Test
    public void validCred(){
          //website validation
           String expectedTitle="Home Page";
           String actualTitle=getCurrentTtile();
           Assert.assertEquals(expectedTitle,actualTitle);
           log.info("landed on luma home page success");

         clickOn("body > div.page-wrapper > header > div.panel.wrapper > div > ul > li.authorization-link > a");
         log.info("click on sign in success");

         type("#email","sof@gmail.com");
         log.info("email enter success");

         type("#pass","1234Abcd$");
          log.info("password enter success");

         clickOn("#send2");
         log.info("click on sign in success");

         //check user logged in
         String expectedWelcomeMess="Welcome, john lost!";
         String actualWelcomeMess=getElementText("//div[@class='panel header']//span[@class='logged-in'][normalize-space()='Welcome, john lost!']");
         Assert.assertEquals(expectedWelcomeMess,actualWelcomeMess);
         log.info("login success");
    }

    @Test
    public void invalidEmail(){
        //website validation
        String expectedTitle="Home Page";
        String actualTitle=getCurrentTtile();
        Assert.assertEquals(expectedTitle,actualTitle);
        log.info("landed on luma home page success");

        clickOn("body div.page-wrapper header div.panel.wrapper div ul li.authorization-link a");
        log.info("click on sign in success");

        type("#email","@gmail.com");
        log.info("email enter success");

        type("#pass","1234Abcd$");
        log.info("password enter success");

        clickOn("#send2");
        log.info("click on sign in success");

        //validate error
        String expectedWelcomeMess="Please enter a valid email address (Ex: johndoe@domain.com).";
        String actualWelcomeMess=getElementText("#email-error");
        Assert.assertEquals(expectedWelcomeMess,actualWelcomeMess);
        log.info("validate error success");
    }

    @Test
    public void missingPassword(){
        //website validation
        String expectedTitle="Home Page";
        String actualTitle=getCurrentTtile();
        Assert.assertEquals(expectedTitle,actualTitle);
        log.info("landed on luma home page success");

        clickOn("body div.page-wrapper header div.panel.wrapper div ul li.authorization-link a");
        log.info("click on sign in success");

        type("#email","sof@gmail.com");
        log.info("email enter success");

        type("#pass","");
        log.info("password enter success");

        clickOn("#send2");
        log.info("click on sign in success");

        //validate error
        String expectedWelcomeMess="This is a required field.";
        String actualWelcomeMess=getElementText("#pass-error");
        Assert.assertEquals(expectedWelcomeMess,actualWelcomeMess);
        log.info("validate error success");
    }
}
