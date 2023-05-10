package us.piit.automation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;

public class UserRegistration extends CommonAPI {
    Logger log= LogManager.getLogger(UserRegistration.class.getName());
    @Test
    public void registration (){
        clickOn("//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/a[1]");
        log.info("click on register success");

        type("//input[@name='name']","adam");
        log.info("enter name  success");

        type("//body/section[@id='form']/div[1]/div[1]/div[3]/div[1]/form[1]/input[3]","adam20023@outlook.com");
        log.info("enter email  success");

        clickOn("//button[contains(text(),'Signup')]");
        log.info("click first signup button success");

        clickOn("//input[@id='id_gender1']");
        log.info("enter gender success");
        waitFor(4);

        type("#password","Adana2023#");
        log.info("enter password success");

        type("#first_name","adam");
        log.info("enter firstname success");

        type("#last_name","izem");
        log.info("enter lastname success");

        type("#company","Izem-inc");
        log.info("enter company success");

        type("#address1","1001 ouad souf blvd");
        log.info("enter address success");

        clickOn("#country");
        log.info("enter country success");

        type("#state","ALG");
        log.info("enter state success");

        type("#city","ouad souf");
        log.info("enter city success");

        type("#zipcode","14534");
        log.info("enter zipcode success");

        type("#mobile_number","0566478382");
        log.info("enter phone number success");

        clickOn("//button[contains(text(),'Create Account')]");
        log.info("click on create account success");
        waitFor(4);
    }
    // user register with existing email
    @Test
    public void existingEmail(){
        // Enter Email, password then clickon login button
        clickOn("//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/a[1]");
        log.info("click on register success");

        type("//input[@name='name']","adam");
        log.info("enter name  success");

        type("//body/section[@id='form']/div[1]/div[1]/div[3]/div[1]/form[1]/input[3]","adam2023@outlook.com");
        log.info("enter email  success");

        clickOn("//button[contains(text(),'Signup')]");
        log.info("error message displayed ");

        // validate error
        String expectedText="Email Address already exist!";
        String actualText=getElementText("//p[contains(text(),'Email Address already exist!')]");
        Assert.assertEquals(expectedText,actualText);
        log.info("validate error success");


    }




}
