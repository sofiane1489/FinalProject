package us.piit.automationpractice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.AutomationPracticePages.AutoHomePage;
import us.piit.AutomationPracticePages.AutoLoginPage;
import us.piit.base.CommonAPI;

public class SearchBarTest extends CommonAPI {
    Logger log = LogManager.getLogger(SearchBarTest.class.getName());
    String validUsername = "yaya@gmail.com";
    String validPassword = "abcd1234$";
    String itemName = "T-shirt";
    @Test
    public void searchItem(){
        AutoLoginPage loginPage = new AutoLoginPage(getDriver());
        AutoHomePage homePage = new AutoHomePage(getDriver());
        String expectedTitle = "My Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);
        //enter  username, password, and click on login button
        loginPage.ClickOnSignInBtn();
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginBtn();

        //check search bar
        homePage.searchQueryItem(itemName);
        homePage.clickOnSearchBarBtn();
        homePage.clickOnSearchBoxBtn();

        //search item validation
        String expectedValidSearchMessage="1 result has been found.";
        String actualValidSearchMessage=homePage.getValidSearchMessage();
        Assert.assertEquals(actualValidSearchMessage,expectedValidSearchMessage);

        String expectedSearchItem="\"T_SHIRTS\"";
        String actualSearchItem=homePage.getItemSearchConfirmation();
        Assert.assertEquals(actualSearchItem,expectedSearchItem);

    }

}