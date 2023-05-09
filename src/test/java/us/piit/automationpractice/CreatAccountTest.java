package us.piit.automationpractice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.SetUp;

public class CreatAccountTest extends SetUp {
    Logger log = LogManager.getLogger(CreatAccountTest.class.getName());

    @Test
    public void validCred() {
        clickOn("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");
        log.info("click on sign in success");
        //enter  username, password, and click on login button
        type("#email_create","malik@gmail.com");
        log.info("enter email success");

        clickOn("#SubmitCreate");
        log.info("click on create an account success");

        clickOn("#id_gender1");
        log.info("enter gender success");

        type("#customer_firstname", "Jhon");
        log.info("enter first name success");

        type("#customer_lastname","Claud");
        log.info("enter last name success");

        type("#email","Claud");
        log.info("enter emai success");

        type("#passwd","abcd1234$");
        log.info("enter password success");

        selectByIn("//select[@id='days']",5);
        log.info("select day success");

        selectByIn("select[id='months']",4);
        log.info("select month success");

        selectByVal("select[id='years']","1991");
        log.info("select year success");

        clickOn("#submitAccount");
        log.info("click on register button success");
        //check user is logged in
        String expectedAccountInformation = "Jhon Claud";
        String actualAccountInformation = getElementText("//div[@class='header_user_info']//a[@class='account']/span");
        Assert.assertEquals(expectedAccountInformation, actualAccountInformation);
        log.info("user logged in success");


    }

    @Test
    public void ExistingEmail() {
        clickOn("#header  div.nav  div  div  nav  div.header_user_info > a");
        log.info("click on sign in success");
        // enter existing email
        type("#email_create","yaya@gmail.com");
        log.info("enter email success");
        clickOn("#SubmitCreate");
        log.info("click on create an account success");
        //error validation
        String expectedError = "An account using this email address has already been registered. Please enter a valid password or request a new one.";
        String actualError = getElementText("#create_account_error ol li");
        Assert.assertEquals(actualError, expectedError);
        log.info("error validation success");
    }
}
