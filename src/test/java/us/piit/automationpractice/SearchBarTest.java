package us.piit.automationpractice;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.AutomationPracticePages.AutoHomePage;
import us.piit.AutomationPracticePages.AutoLoginPage;
import us.piit.base.CommonAPI;
import us.piit.utility.Utility;

import java.util.Properties;

public class SearchBarTest extends CommonAPI {
    Properties pro= Utility.loadProperties();
    String validUsername=Utility.decode(pro.getProperty("automationpractice.email")) ;
    String validPassword=Utility.decode(pro.getProperty("automationpractice.password")) ;
    String itemName=Utility.decode(pro.getProperty("automationpractice.searchText")) ;


    @Test
    public void searchItem(){
        AutoLoginPage autoLoginPage = new AutoLoginPage(getDriver());
        AutoHomePage autoHomePage = new AutoHomePage(getDriver());

        String expectedTitle = "My Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        //enter  username, password, and click on login button
        autoLoginPage.ClickOnSignInBtn();
        autoLoginPage.enterUsername(validUsername);
        autoLoginPage.enterPassword(validPassword);
        autoLoginPage.clickOnLoginBtn();

        //check search bar
        autoHomePage.searchQueryItem(itemName);
        autoHomePage.clickOnSearchBoxBtn();

        //search item validation
        String expectedValidSearchMessage="1 result has been found.";
        String actualValidSearchMessage=autoHomePage.getValidSearchMessage();
        Assert.assertEquals(actualValidSearchMessage,expectedValidSearchMessage);

        String expectedSearchItem="\"T-SHIRT\"";
        String actualSearchItem=autoHomePage.getItemSearchConfirmation();
        Assert.assertEquals(actualSearchItem,expectedSearchItem);

    }


}