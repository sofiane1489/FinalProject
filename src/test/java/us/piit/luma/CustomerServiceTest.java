package us.piit.luma;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.lumaPages.ContactUsPage;
import us.piit.lumaPages.HomePageBeforeLogin;
import us.piit.utility.Utility;

import java.util.Properties;

public class CustomerServiceTest extends CommonAPI {
    Logger log= LogManager.getLogger(CustomerServiceTest.class.getName());

    Properties pro= Utility.loadProperties();

    String fullName=Utility.decode(pro.getProperty("luma.fullName")) ;
    String emailAddress=Utility.decode(pro.getProperty("luma.email")) ;
    String telephoneNumber=Utility.decode(pro.getProperty("luma.telephoneNumber")) ;
    String message=Utility.decode(pro.getProperty("luma.message")) ;

    @Test
    public void sendEmail(){
        HomePageBeforeLogin homePageBeforeLogin=new HomePageBeforeLogin(getDriver());
        ContactUsPage contactUsPage=new ContactUsPage(getDriver());

        // website validation with Title
        String expextedTitle="Home Page";
        String actualTitle=getCurrentTtile();
        Assert.assertEquals(actualTitle,expextedTitle);

        // website validation with luma logo
        Assert.assertTrue( homePageBeforeLogin.checkHomePageLogoVisibility());

        homePageBeforeLogin.clickOnContactUsBnt();

        contactUsPage.enterNameInContactUs(fullName);

        contactUsPage.enterEmailAddress(emailAddress);

        contactUsPage.enterTelephoneNumber(telephoneNumber);

        contactUsPage.enterYourTextMessage(message);

        contactUsPage.clickOnSubmitBtn();


        //send message validation
        String expectedMessage="Thanks for contacting us with your comments and questions. We'll respond to you very soon.";
        String actualMessage=contactUsPage.getConfirmationMessage();
        Assert.assertEquals(actualMessage,expectedMessage);

    }
}
