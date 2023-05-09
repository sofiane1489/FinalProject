package us.piit.luma;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.SetUp;

public class CustomerServiceTest extends SetUp {
    Logger log= LogManager.getLogger(CustomerServiceTest.class.getName());
    @Test
    public void sendEmail(){
        // website validation with luma logo
        boolean actualTitle=isVisible("//a[@aria-label='store logo']//img");
        Assert.assertTrue(actualTitle);
        log.info("landed on luma home page success");

        clickOn("//a[text()='Contact Us']");
        log.info("click on contact us success");

        type("#name","mike lee");
        log.info("type Name success");
        type("#email","Betta@gmail.com");
        log.info("type Email address success");
        type("#telephone","0123456789");
        log.info("type telephone success");
        type("#comment","order not received");
        log.info("type text in the box success");
        clickOn(".action.submit.primary");
        log.info("click on submit success");

        String expectedMessage="Thanks for contacting us with your comments and questions. We'll respond to you very soon.";
        String actualMessage=getElementText(".message-success.success.message");
        Assert.assertEquals(actualMessage,expectedMessage);
        log.info("Email sent success");

    }
}
