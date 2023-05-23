package us.piit.tutorialsninja;

import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.tutorialsninjaPage.HomePage;
import us.piit.tutorialsninjaPage.LoginPage;
import us.piit.tutorialsninjaPage.OrderHistoryPage;
import us.piit.tutorialsninjaPage.WelcomePage;
import us.piit.utility.Utility;

import java.util.Properties;

public class OrdersHistoryTest extends CommonAPI {
    Properties pro = Utility.loadProperties();

    String validEmail = Utility.decode(pro.getProperty("tutorialsninja.email"));
    String userPassword = Utility.decode(pro.getProperty("tutorialsninja.password"));


    @Test
    public void viewOrderHistory() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        OrderHistoryPage orderHistoryPage = new OrderHistoryPage(getDriver());
        String expectedTitle = "Your Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        //enter  username, password, and click on login button
        welcomePage.clickOnMyAccountBtn();
        welcomePage.hoverOverAndClickOnHeaderLoginBtn();
        loginPage.enterValidEmail(validEmail);
        loginPage.enterValidPassword(userPassword);
        loginPage.clickOnLoginBtn();

        //view order history
        homePage.clickOnViewYourOrderHistory();
        orderHistoryPage.clickOnViewOrderBtn();
        orderHistoryPage.scrollToReturnBtn(getDriver());

        //view order history validation
        
    }
}
