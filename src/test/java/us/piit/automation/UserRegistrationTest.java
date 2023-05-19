package us.piit.automation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.automationPages.HomePage;
import us.piit.automationPages.RegistrationPage;
import us.piit.base.CommonAPI;
import us.piit.utility.Utility;

import java.util.Properties;

public class UserRegistrationTest extends CommonAPI {
    Logger log= LogManager.getLogger(UserRegistrationTest.class.getName());
    Properties pop= Utility.loadProperties();
    String name= Utility.decode(pop.getProperty("automation.name"));
    String emailAddress = Utility.decode(pop.getProperty("automation.emailAdress"));
    String password1=Utility.decode(pop.getProperty("automation.password1"));
    String firstName= Utility.decode(pop.getProperty("automation.firstName"));
    String lastName=Utility.decode(pop.getProperty("automation.lastName"));
    String company=Utility.decode(pop.getProperty("automation.company"));
    String address=Utility.decode(pop.getProperty("automation.address"));
    String country=Utility.decode(pop.getProperty("automation.country"));
    String state=Utility.decode(pop.getProperty("automation.state"));
    String city=Utility.decode(pop.getProperty("automation.city"));
    String zipCode=Utility.decode(pop.getProperty("automation.zipCode"));
    String mobileNumber=Utility.decode(pop.getProperty("automation.mobileNumber"));

    //registration to an account validation
//    String expected welcomingmessage="Congratulations! Your new account has been successfully created!";
//    String actual welcomingmessage=

    @Test
    public void registration (){
        RegistrationPage registrationPage=new RegistrationPage(getDriver());
        HomePage homePage=new HomePage(getDriver());

        registrationPage.clickonsignupbutton();
        registrationPage.enterName(name);
        registrationPage.enterEmail(emailAddress);
        registrationPage.clickonsignupbtn();
        registrationPage.enterPassword(password1);
        registrationPage.enterfirstName(firstName);
        registrationPage.enterLastName(lastName);
        registrationPage.entercompany(company);
        registrationPage.enteraddress(address);
        registrationPage.entercountry(country);
        registrationPage.enterState(state);
        registrationPage.entercity(city);
        registrationPage.enterzipcode(zipCode);
        registrationPage.entermobilenumber(mobileNumber);
        registrationPage.clickonregisterbtn();


    }

    //user register with existing email
    @Test
    public void existingEmail(){
        RegistrationPage registrationPage=new RegistrationPage(getDriver());
        HomePage homePage=new HomePage(getDriver());
        // Enter Email, password then clickon login button

        registrationPage.clickonsignupbutton();
        registrationPage.enterName(name);
        registrationPage.enterEmail(emailAddress);
        registrationPage.clickonsignupbtn();
        log.info("error message displayed ");

        // validate error
        String expectederrormessage="Email Address already exist!";
        String actualerrormessage=registrationPage.getErrorMessage();
        Assert.assertEquals(expectederrormessage,actualerrormessage);



    }




}