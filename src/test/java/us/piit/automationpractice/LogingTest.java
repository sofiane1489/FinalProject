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

        type("#passwd","abcd1234$");
        log.info("enter password success");

        clickOn("#SubmitLogin");
        log.info("click on login button Success");

        //check user is logged in
        String expectedAccountInformation = "Jhon Claud";
        String actualAccountInformation = getElementText("//div[@class='header_user_info']//a[@class='account']/span");
        Assert.assertEquals(expectedAccountInformation, actualAccountInformation);
        log.info("user logged in success");
    }
    @Test
    public void invalidEmail() {
        String expectedTitle = "My Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);
        //enter  username, password, and click on login button
        clickOn("#header > div.nav > div > div > nav > div.header_user_info > a");
        log.info("click on sign in success");

        type("#email","yay@gmail.com");
        log.info("enter email success");

        type("#passwd","abcd1234$");
        log.info("enter password success");

        clickOn("#SubmitLogin");
        log.info("click on login button Success");

        //error validation
        boolean expectError = true;
        boolean actualError = isVisible("//div[@class='alert alert-danger']");
        Assert.assertEquals(actualError, expectError);
        log.info("validate error success");
    }
    @Test
    public void missingPassword() {
        String expectedTitle = "My Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);
        //enter  username, password, and click on login button
        clickOn("#header > div.nav > div > div > nav > div.header_user_info > a");
        log.info("cilck on singn in success");

        type("#email","yaya@gmail.com");
        log.info("enter email success");

        type("#passwd","");
        log.info("enter password success");

        clickOn("#SubmitLogin");
        log.info("click on login button Success");

        //error validation
        boolean expectresult = true;
        boolean actualresult = isVisible("//div[@class='alert alert-danger']");
        Assert.assertEquals(actualresult, expectresult);
        log.info("validate error success");
    }

}