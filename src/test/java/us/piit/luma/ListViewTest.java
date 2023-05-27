package us.piit.luma;

import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.lumaPages.HomePageBeforeLogin;
import us.piit.lumaPages.MenCategoryPage;
import us.piit.lumaPages.TopsPage;

public class ListViewTest extends CommonAPI{

    @Test
    public void checkListView(){
        HomePageBeforeLogin homePageBeforeLogin=new HomePageBeforeLogin(getDriver());
        MenCategoryPage menPage=new MenCategoryPage(getDriver());
        TopsPage topsPage=new TopsPage(getDriver());

        // website validation with Title
        String expextedTitle="Home Page";
        String actualTitle=getCurrentTtile();
        Assert.assertEquals(actualTitle,expextedTitle);
        // website validation with luma logo
        Assert.assertTrue(homePageBeforeLogin.checkHomePageLogoVisibility());

        homePageBeforeLogin.clickOnMenCategory();

        menPage.clickOnTops48InMenCategory();

        topsPage.clickOnListModeBtn();

        //list view mode validation
        String expectedToolbarAmountText="Items 1-10 of 48";
        Assert.assertEquals(topsPage.getToolabarAmountText(),expectedToolbarAmountText);



    }
}
