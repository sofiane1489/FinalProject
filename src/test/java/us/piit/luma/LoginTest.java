package us.piit.luma;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.SetUp;

public class LoginTest extends SetUp {
    Logger log= LogManager.getLogger(SetUp.class.getName());
    @Test
    public void validCred(){
          //website validation
           String expectedTitle="Home Page";
           String actualTitle=getCurrentTtile();
           Assert.assertEquals(expectedTitle,actualTitle);
           log.info("landed on luma home page success");

         clickOn("body > div.page-wrapper > header > div.panel.wrapper > div > ul > li.authorization-link > a");
         log.info("click on sign in success");

         type("#email","so@gmail.com");
         log.info("email enter success");

         type("#pass","1234Abcd$");
          log.info("password enter success");

         clickOn("#send2");

         String expectedWelcomeMess="Welcome, accene lost!";
         String actualWelcomeMess=getElementText("//div[@class='panel header']//span[@class='logged-in'][normalize-space()='Welcome, accene lost!']");
         Assert.assertEquals(expectedWelcomeMess,actualWelcomeMess);
         log.info("login success");
    }

}
