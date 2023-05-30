package us.piit.tutorialsninja;

import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.tutorialsninjaPage.HomePage;
import us.piit.tutorialsninjaPage.LoginPage;
import us.piit.tutorialsninjaPage.ProductReturnPage;
import us.piit.tutorialsninjaPage.WelcomePage;
import us.piit.utility.Utility;

import java.util.Properties;

public class ReturnPurchasedProductTest extends CommonAPI {
    Properties pro = Utility.loadProperties();

    String validEmail = Utility.decode(pro.getProperty("tutorialsninja.email"));
    String userPassword = Utility.decode(pro.getProperty("tutorialsninja.password"));

    @Test
    public void returnItemTest() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProductReturnPage productReturnPage = new ProductReturnPage(getDriver());
        String expectedTitle = "Your Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        //enter  username, password, and click on login button
        welcomePage.clickOnMyAccountBtn();
        welcomePage.hoverOverAndClickOnHeaderLoginBtn();
        loginPage.enterValidEmail(validEmail);
        loginPage.enterValidPassword(userPassword);
        loginPage.clickOnLoginBtn();

        //return product
        productReturnPage.clickOnViewOrderHistory();
        productReturnPage.clickOnViewOrderBtn();
        productReturnPage.ClickOnReturnBtn();
        productReturnPage.clickOnReceivedWrongItem();
        productReturnPage.clickOnOpenedProductStatus();
        productReturnPage.clickOnSubmitBtn();

        //request confirmation
        String expectedRequestConfirmationMessage = "You will be notified via e-mail as to the status of your request.";
        String actualRequestConfirmationMessage = productReturnPage.getRequestConfirmationSubmission();
        Assert.assertEquals(expectedRequestConfirmationMessage, actualRequestConfirmationMessage);
    }
}
