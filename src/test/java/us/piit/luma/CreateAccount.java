package us.piit.luma;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;

public class CreateAccount extends CommonAPI {
    Logger log= LogManager.getLogger(CreateAccount.class.getName());
//    @Test
//    public void createNewAccount(){
//         // website validation with luma logo
//           boolean actualTitle=isVisible("//a[@aria-label='store logo']//img");
//           Assert.assertTrue(actualTitle);
//           log.info("landed on luma login page success");
//
//        clickOn("//div[@class='panel header']//a[normalize-space()='Create an Account']");
//               log.info("click create account success");
//        type("#firstname","mike");
//               log.info("enter name  success");
//
//        type("#lastname","lee");
//        log.info("enter lastname success");
//
//        type("#email_address","Bettta@gmail.com");
//        log.info("enter email success");
//
//        type("#password","1234Abcd$");
//        log.info("enter password success");
//
//        type("#password-confirmation","1234Abcd$");
//        log.info("reenter password success");
//
//        clickOn("//form[@class='form create account form-create-account']/div/div/button/span");
//        log.info("click on create account success");
//
//        //create account validation
//        String expectedContInfor="mike lee\n" +
//                "Bettta@gmail.com";
//        String actualContInfor=getElementText("div[class='box box-information'] p");
//        Assert.assertEquals(expectedContInfor,actualContInfor);
//        log.info("account create success");
//}
    @Test
    public void emailAlreadyTaken(){
        // website validation with luma logo
        boolean actualTitle=isVisible("//a[@aria-label='store logo']//img");
        Assert.assertTrue(actualTitle);
        log.info("landed on luma login page success");

        clickOn("//div[@class='panel header']//a[normalize-space()='Create an Account']");
               log.info("click create account success");

        type("#firstname","john");
               log.info("enter name  success");

        type("#lastname","lost");
        log.info("enter lastname success");

        type("#email_address","Betta@gmail.com");
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
