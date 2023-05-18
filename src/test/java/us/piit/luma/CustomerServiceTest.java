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

        //scrolling  down To element
        homePageBeforeLogin.scrollToContactUsBtn(getDriver());

        homePageBeforeLogin.clickOnContactUsBnt();

        contactUsPage.enterNameInContactUs(useFakeFullName());

        contactUsPage.enterEmailAddress(useFakeEmail());

        contactUsPage.enterTelephoneNumber(useFakePhoneNumber());

        contactUsPage.enterYourTextMessage(useFakeParagraph());

        contactUsPage.clickOnSubmitBtn();


        //send message validation
        String expectedMessage="Thanks for contacting us with your comments and questions. We'll respond to you very soon.";
        String actualMessage=contactUsPage.getConfirmationMessage();
        Assert.assertEquals(actualMessage,expectedMessage);

    }
}
