package us.piit.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.automationPages.ContactUsPage;
import us.piit.automationPages.HomePage;
import us.piit.automationPages.LoginPage;
import us.piit.automationPages.RegistrationPage;
import us.piit.base.CommonAPI;
import us.piit.utility.Utility;
import java.util.Properties;

public class ContactsupportTest extends CommonAPI {
    Logger log = LogManager.getLogger(ContactsupportTest.class.getName());
    Properties pop = Utility.loadProperties();
    String name = Utility.decode(pop.getProperty("automation.name"));
    String validEmail = Utility.decode(pop.getProperty("automation.validEmail"));
    String subject = Utility.decode(pop.getProperty("automation.subject"));
    String message = Utility.decode(pop.getProperty("automation.message"));

    @Test
    public void contactSupportService() {
        RegistrationPage registrationPage=new RegistrationPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ContactUsPage contactSupportPage = new ContactUsPage(getDriver());
        LoginPage loginPage=new LoginPage(getDriver());

        // Verify the title of the page
        String expectedTitle = "Automation Exercise";
        String actualTitle=getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        // click on contact us,
        contactSupportPage.contactSupport();

        //verify "GET IN TOUCH" is vesible
        boolean expectedSupportHeaderPage=true;
        boolean actualSupportHeaderPage=homePage.headerpagevisibility();
        Assert.assertEquals(expectedSupportHeaderPage,actualSupportHeaderPage);

        //fill up the blank fields then click on submit
        registrationPage.enterName(name);

        loginPage.enterEmail(validEmail);

        contactSupportPage.enterSubject(subject);

        contactSupportPage.enterMessage(message);

        contactSupportPage.clickonsubmitbutton();


        //  success message validation
//        String expectedmessage="Success! Your details have been submitted successfully.";
//        String actualmessage=contactSupportPage.getMessage();
//        Assert.assertEquals(expectedmessage,actualmessage);



    }
}