package us.piit.automationpractice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.AutomationPracticePages.AutoHomePage;
import us.piit.AutomationPracticePages.AutoLoginPage;
import us.piit.AutomationPracticePages.CreateAccountAuthenticationPage;
import us.piit.base.CommonAPI;
import us.piit.utility.Utility;

import java.util.Properties;

public class CreatAccountTest extends CommonAPI {
    Properties pro= Utility.loadProperties();
    String validUsername=Utility.decode(pro.getProperty("automationpractice.email")) ;
    String customerFirstName=Utility.decode(pro.getProperty("automationpractice.firstname")) ;
    String customerLastName=Utility.decode(pro.getProperty("automationpractice.lastname")) ;
    String newEmail=Utility.decode(pro.getProperty("automationpractice.newEmail")) ;
    String customerPassword=Utility.decode(pro.getProperty("automationpractice.newpassword")) ;
    String customerGender=Utility.decode(pro.getProperty("automationpractice.gender")) ;
    String customerMonth=Utility.decode(pro.getProperty("automationpractice.customerMonth")) ;
    String customerDay=Utility.decode(pro.getProperty("automationpractice.customerDay")) ;
    String customerYear=Utility.decode(pro.getProperty("automationpractice.customerYear")) ;



//    @Test
//    public void validCred() {
//        AutoLoginPage autoLoginPage = new AutoLoginPage(getDriver());
//        CreateAccountAuthenticationPage CreateAccountAuthenticationPage = new CreateAccountAuthenticationPage(getDriver());
//        AutoHomePage autoHomePage = new AutoHomePage(getDriver());
//        String expectedTitle = "My Store";
//        String actualTitle = getCurrentTtile();
//        Assert.assertEquals(expectedTitle, actualTitle);
//        //click on sign in, enter  username, password, and click on login button
//        autoLoginPage.ClickOnSignInBtn();
//        autoLoginPage.emailAccountCreation(newEmail);
//        autoLoginPage.clickOnCreateAccountBtn();
//        CreateAccountAuthenticationPage.selectGender();
//        CreateAccountAuthenticationPage.enterFirstName(customerFirstName);
//        CreateAccountAuthenticationPage.enterLasrName(customerLastName);
//        CreateAccountAuthenticationPage.enterPassword(customerPassword);
//        waitFor(2);
//        CreateAccountAuthenticationPage.selectDay(Integer.parseInt(customerDay));
//
//        CreateAccountAuthenticationPage.selectMonth(Integer.parseInt(customerMonth));
//
//
//        CreateAccountAuthenticationPage.selectYear(customerYear);
//
//        CreateAccountAuthenticationPage.clickOnRegister();
//
//        //create account validation
//        String expectedAccountInformation = "Jhon Claud";
//        String actualAccountInformation = autoHomePage.getWelcomeMessage();
//        Assert.assertEquals(expectedAccountInformation, actualAccountInformation);
//
//
//
//
//    }

    @Test
    public void ExistingEmail() {
        AutoLoginPage autoLoginPage = new AutoLoginPage(getDriver());

        String expectedTitle = "My Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        // enter existing
        autoLoginPage.ClickOnSignInBtn();
        autoLoginPage.enterUsername(validUsername);
        autoLoginPage.clickOnCreateAccountBtn();

        //error validation
         waitFor(1);
        Assert.assertTrue(autoLoginPage.checkPresenceOfErrorMessage());

    }
}