package us.piit.luma;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.lumaPages.CreateAccountPage;
import us.piit.lumaPages.HomePageAfterLogin;
import us.piit.lumaPages.HomePageBeforeLogin;
import us.piit.lumaPages.LoginPage;

public class CreateAccountTest extends CommonAPI {
    Logger log= LogManager.getLogger(CreateAccountTest.class.getName());

    String firstname="mike";
    String lastname="lee";
    String createEmail="Bettta@gmail.com";
    String createPassword="1234Abcd$";

//    @Test
//    public void createNewAccount(){
//        HomePageBeforeLogin homePageBeforeLogin=new HomePageBeforeLogin(getDriver());
//        CreateAccountPage createAccountPage=new CreateAccountPage(getDriver());
//        HomePageAfterLogin homePageAfterLogin=new HomePageAfterLogin(getDriver());
//
//              // website validation with Title
//              String expextedTitle="Home Page";
//              String actualTitle=getCurrentTtile();
//              Assert.assertEquals(actualTitle,expextedTitle);
//
//         // website validation with luma logo
//           Assert.assertTrue(homePageBeforeLogin.homePageLogoVisibility());
//
//           homePageBeforeLogin.clickOnCreateAnAccountLink();
//
//           createAccountPage.enterFirstName(firstname);
//
//           createAccountPage.enterLastName(lastname);
//
//           createAccountPage.enterEmail(createEmail);
//
//           createAccountPage.enterPassword(createPassword);
//
//           createAccountPage.enterConfirmationPassword(password);
//
//           createAccountPage.clickOnCreateAccountBtn();
//
//        //create account validation
//        String expectedContInfor="mike lee\n" +
//                "Bettta@gmail.com";
//        String actualContInfor=homePageAfterLogin.getAccountMessageInfo();
//        Assert.assertEquals(expectedContInfor,actualContInfor);
//}

    String firstName="john";
    String lastName="lost";
    String email="Betta@gmail.com";
    String password="1234Abcd$";
    @Test
    public void emailAlreadyTaken(){
        HomePageBeforeLogin homePageBeforeLogin=new HomePageBeforeLogin(getDriver());
        CreateAccountPage createAccountPage=new CreateAccountPage(getDriver());

        // website validation with Title
        String expextedTitle="Home Page";
        String actualTitle=getCurrentTtile();
        Assert.assertEquals(actualTitle,expextedTitle);
        // website validation with luma logo
        Assert.assertTrue(homePageBeforeLogin.homePageLogoVisibility());

        homePageBeforeLogin.clickOnCreateAnAccountLink();

        createAccountPage.enterFirstName(firstName);

        createAccountPage.enterLastName(lastName);

        createAccountPage.enterEmail(email);

        createAccountPage.enterPassword(password);

        createAccountPage.enterConfirmationPassword(password);

        createAccountPage.clickOnCreateAccountBtn();

        //error validation
        String expectedErrorMessage="There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.";
        String actualErrorMessage = createAccountPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);

    }
}
