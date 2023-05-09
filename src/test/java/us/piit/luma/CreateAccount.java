package us.piit.luma;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.SetUp;

public class CreateAccount extends SetUp {
    Logger log= LogManager.getLogger(CreateAccount.class.getName());
    @Test
    public void createNewAccount(){

        clickOn("//div[@class='panel header']//a[normalize-space()='Create an Account']");
               log.info("click create account success");
        type("#firstname","mike");
               log.info("enter name  success");

        type("#lastname","lee");
        log.info("enter lastname success");

        type("#email_address","sos@gmail.com");
        log.info("enter email success");

        type("#password","1234Abcd$");
        log.info("enter password success");

        type("#password-confirmation","1234Abcd$");
        log.info("reenter password success");

        clickOn("//form[@class='form create account form-create-account']/div/div/button/span");
        log.info("click on create account success");

        //create account validation
        String expectedContInfor="mike lee\n" +
                "sos@gmail.com";
        String actualContInfor=getElementText("div[class='box box-information'] p");
        Assert.assertEquals(expectedContInfor,actualContInfor);
        log.info("account create success");
}

    @Test
    public void createWithExistingEmail(){
        clickOn("//div[@class='panel header']//a[normalize-space()='Create an Account']");
               log.info("click create account success");

        type("#firstname","john");
               log.info("enter name  success");

        type("#lastname","lost");
        log.info("enter lastname success");

        type("#email_address","sof@gmail.com");
        log.info("enter email success");

        type("#password","1234Abcd$");
        log.info("enter password success");

        type("#password-confirmation","1234Abcd$");
        log.info("reenter password success");

        clickOn("//form[@class='form create account form-create-account']/div/div/button/span");
        log.info("click on create account success");

        //error validation
        String expectedErrorMessage="There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.";
        String actualErrorMessage = getElementText(".message-error.error.message");
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
        log.info("error message validation success");

    }
}
