package us.piit.luma;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.lumaPages.ContactUsPage;
import us.piit.lumaPages.HomePageBeforeLogin;

public class CustomerServiceTest extends CommonAPI {
    Logger log= LogManager.getLogger(CustomerServiceTest.class.getName());

    String fullName="mike lee";
    String emailAddress="Betta@gmail.com";
    String telephoneNumber="0123456789";
    String message="order not received";

    @Test
    public void sendEmail(){
        HomePageBeforeLogin homePageBeforeLogin=new HomePageBeforeLogin(getDriver());
        ContactUsPage contactUsPage=new ContactUsPage(getDriver());

        // website validation with Title
        String expextedTitle="Home Page";
        String actualTitle=getCurrentTtile();
        Assert.assertEquals(actualTitle,expextedTitle);

        // website validation with luma logo
        Assert.assertTrue( homePageBeforeLogin.homePageLogoVisibility());

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
