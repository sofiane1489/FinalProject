package us.piit.luma;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.lumaPages.HomePageAfterLogin;
import us.piit.lumaPages.HomePageBeforeLogin;
import us.piit.lumaPages.LoginPage;
import us.piit.lumaPages.SearchResultPage;
import us.piit.utility.Utility;

import java.util.Properties;

public class SearchBarTest extends CommonAPI {
    Logger log= LogManager.getLogger(SearchBarTest.class.getName());

    Properties pro= Utility.loadProperties();
    String searchFor= Utility.decode(pro.getProperty("luma.searchText"));

       @Test
       public void searchTest(){
           HomePageBeforeLogin homePageBefore=new HomePageBeforeLogin(getDriver());
           SearchResultPage searchResultPage=new SearchResultPage(getDriver());

           // website validation with Title
           String expextedTitle="Home Page";
           String actualTitle=getCurrentTtile();
           Assert.assertEquals(actualTitle,expextedTitle);

           //website validation with luma logo
           Assert.assertTrue(homePageBefore.homePageLogoVisibility());

          homePageBefore.typeInSearchBarAndClickEnter(searchFor);

          //search result validation
          String expectedPageWraperTitle="Search results for: 'bag pack for man'";
          String actualPageWraperTitle=searchResultPage.PageSearchTitle();
          Assert.assertEquals(actualPageWraperTitle,expectedPageWraperTitle);

   }
}
