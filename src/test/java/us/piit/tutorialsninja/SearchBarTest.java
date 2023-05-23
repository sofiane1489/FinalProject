package us.piit.tutorialsninja;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.tutorialsninjaPage.HomePage;
import us.piit.tutorialsninjaPage.LoginPage;
import us.piit.base.CommonAPI;
import us.piit.tutorialsninjaPage.SearchResultPage;
import us.piit.tutorialsninjaPage.WelcomePage;
import us.piit.utility.Utility;

import java.util.Properties;

public class SearchBarTest extends CommonAPI {
    Properties pro= Utility.loadProperties();
    String validEmail=Utility.decode(pro.getProperty("tutorialsninja.email")) ;
    String userPassword=Utility.decode(pro.getProperty("tutorialsninja.password")) ;
    String typeItem=Utility.decode(pro.getProperty("tutorialsninja.item")) ;

    @Test
    public void searchItemTest(){
        WelcomePage welcomePage = new WelcomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        SearchResultPage searchResultPage = new SearchResultPage(getDriver());
        String expectedTitle = "Your Store.com";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        // enter  username, password, and click on login button
        welcomePage.clickOnMyAccountBtn();
        welcomePage.hoverOverAndClickOnHeaderLoginBtn();
        loginPage.enterValidEmail(validEmail);
        loginPage.enterValidPassword(userPassword);
        loginPage.clickOnLoginBtn();
        //check search bar
        homePage.clickOnSearchBarAndType(typeItem);
        homePage.clickOnSearchBtn();
        searchResultPage.scrollToItemImg(getDriver());

        //search item validation
        String expectedValidSearchMessage="Products meeting the search criteria";
        String actualValidSearchMessage=searchResultPage.getSearchValidationMessage();
        Assert.assertEquals(actualValidSearchMessage,expectedValidSearchMessage);
        captureScreenshot();
    }
}