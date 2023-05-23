package us.piit.luma;

import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.lumaPages.*;

public class AddToCompareTest extends CommonAPI {

    @Test
    public void unableToAddToWishList() {
        HomePageBeforeLogin homePageBeforeLogin = new HomePageBeforeLogin(getDriver());
        MenCategoryPage menPage = new MenCategoryPage(getDriver());
        TopsPage topsPage = new TopsPage(getDriver());
        CassiusSparringTankPage cassiusSparringTankPage = new CassiusSparringTankPage(getDriver());

        // website validation with Title
        String expextedTitle = "Home Page";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(actualTitle, expextedTitle);
        // website validation with luma logo
        Assert.assertTrue(homePageBeforeLogin.checkHomePageLogoVisibility());

        homePageBeforeLogin.clickOnMenCategory();

        menPage.clickOnTops48InMenCategory();

        topsPage.clickOnCassiusSparringTank();

        cassiusSparringTankPage.clickOnSizeLabel();

        cassiusSparringTankPage.clickOnBlueColor();

        cassiusSparringTankPage.scrollToAddToCartBtn(getDriver());

        cassiusSparringTankPage.clickOnAddToCompareLink();


        //add to compare validation
        String expectedTextConfirmation="You added product Cassius Sparring Tank to the comparison list.";
        Assert.assertEquals(cassiusSparringTankPage.getConfirmationText(),expectedTextConfirmation);

    }
}
