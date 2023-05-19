package us.piit.luma;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.lumaPages.*;
import us.piit.utility.Utility;

import java.util.Properties;

public class PurchaseItemTest extends CommonAPI {


    @Test(priority=1)
    public void unableToAddToCartWithNoSelectedAttribute(){
        HomePageBeforeLogin homePageBeforeLogin=new HomePageBeforeLogin(getDriver());
        MenCategoryPage menPage=new MenCategoryPage(getDriver());
        TopsPage topsPage=new TopsPage(getDriver());
        CassiusSparringTankPage cassiusSparringTankPage=new CassiusSparringTankPage(getDriver());

        // website validation with Title
        String expextedTitle="Home Page";
        String actualTitle=getCurrentTtile();
        Assert.assertEquals(actualTitle,expextedTitle);
        // website validation with luma logo
        Assert.assertTrue(homePageBeforeLogin.checkHomePageLogoVisibility());

        homePageBeforeLogin.clickOnMenCategory();

        menPage.clickOnTops48InMenCategory();

        topsPage.clickOnCassiusSparringTank();

        cassiusSparringTankPage.clickOnAddToCartBtn();

        String expectedErrorText="This is a required field.";
        Assert.assertEquals(expectedErrorText,cassiusSparringTankPage.getErrorMessage());

    }

    @Test(priority=3)
    public void addItemToCart(){
        HomePageBeforeLogin homePageBeforeLogin=new HomePageBeforeLogin(getDriver());
        MenCategoryPage menPage=new MenCategoryPage(getDriver());
        TopsPage topsPage=new TopsPage(getDriver());
        CassiusSparringTankPage cassiusSparringTankPage=new CassiusSparringTankPage(getDriver());

        // website validation with Title
        String expextedTitle="Home Page";
        String actualTitle=getCurrentTtile();
        Assert.assertEquals(actualTitle,expextedTitle);
        // website validation with luma logo
        Assert.assertTrue(homePageBeforeLogin.checkHomePageLogoVisibility());

        homePageBeforeLogin.clickOnMenCategory();

        menPage.clickOnTops48InMenCategory();

        topsPage.clickOnCassiusSparringTank();

        cassiusSparringTankPage.clickOnSizeLabel();

        cassiusSparringTankPage.clickOnBlueColor();

        cassiusSparringTankPage.scrollToAddToCartBtn(getDriver());

        cassiusSparringTankPage.clickOnAddToCartBtn();

        //add to car validation
        String expextedText="You added Cassius Sparring Tank to your shopping cart.";
        String actualText= cassiusSparringTankPage.getConfirmationText();
        Assert.assertEquals(actualText,expextedText);

    }

    @Test(priority=2)
    public void buyProduct(){
        HomePageBeforeLogin homePageBeforeLogin=new HomePageBeforeLogin(getDriver());
        FitnessEquipmentPage fitnessEquipmentPage=new FitnessEquipmentPage(getDriver());
        QuestLumaflexBandPage questLumaflexBandPage=new QuestLumaflexBandPage(getDriver());
        ShippingAddressPage shippingAddressPage=new ShippingAddressPage(getDriver());
        GearCategoryPage gearCategoryPage =new GearCategoryPage(getDriver());

        // website validation with Title
        String expextedTitle="Home Page";
        String actualTitle=getCurrentTtile();
        Assert.assertEquals(actualTitle,expextedTitle);
        // website validation with luma logo
        Assert.assertTrue(homePageBeforeLogin.checkHomePageLogoVisibility());

        homePageBeforeLogin.hoverOverGearCategory(getDriver());

        gearCategoryPage.clickOnFitnessEquipment();

        fitnessEquipmentPage.ScrollToItem(getDriver());

        fitnessEquipmentPage.clickOnQuestLumaflexBand();

       questLumaflexBandPage.clickOnAddToCartBtn();

       //add to cart validation
       String expextedText="You added Quest Lumaflex™ Band to your shopping cart.";
       String actualText= questLumaflexBandPage.getTextConfirmation();
        Assert.assertEquals(actualText,expextedText);


        //navigate to cart
        homePageBeforeLogin.clickOnShoppingCartIcon();
        waitFor(1);
        homePageBeforeLogin.clickOnProceedToCheckOutBtn();

        shippingAddressPage.enterEmailAddress(useFakeEmail());

        shippingAddressPage.enterFirstName(useFakeFirstName());

        shippingAddressPage.enterlastName(useFakeLastName());

        shippingAddressPage.entercompanyName(useFakeCompany());

        shippingAddressPage.enterStreetAddress(useFakeAddress());

        shippingAddressPage.enterCityName(useFakeCity());

        shippingAddressPage.selectState(useFakeState());

        shippingAddressPage.enterZipCode(useFakeZipcode());

        shippingAddressPage.enterPhoneNumber(useFakePhoneNumber());

        shippingAddressPage.selectShippingMethod();

        shippingAddressPage.clickOnNextBtn();

        waitFor(3);
        shippingAddressPage.clickOnPlaceOrderBtn();

        //purchase validation:
        String expectedMessage="Thank you for your purchase!";
        String actualMessage= shippingAddressPage.getPurchaseConfirmationText();
        Assert.assertEquals(actualMessage,expectedMessage);
        captureScreenshot();

    }
    @Test(priority=4)
    public void removeItemsFromTheCart(){
        HomePageBeforeLogin homePageBeforeLogin=new HomePageBeforeLogin(getDriver());
        GearCategoryPage gearCategoryPage =new GearCategoryPage(getDriver());
        WatchesPage watchesPage=new WatchesPage(getDriver());
        DashDigitalWatchPage dashDigitalWatchPage=new DashDigitalWatchPage(getDriver());
        ShoppingCartPage shoppingCartPage =new ShoppingCartPage(getDriver());

        // website validation with Title
        String expextedTitle="Home Page";
        String actualTitle=getCurrentTtile();
        Assert.assertEquals(actualTitle,expextedTitle);
        // website validation with luma logo
        Assert.assertTrue(homePageBeforeLogin.checkHomePageLogoVisibility());

        //click on Gear section
        homePageBeforeLogin.clickOnGearcategory();

        gearCategoryPage.clickOnWatchesSection();

        watchesPage.clickOnDashDigitalWatch();

        dashDigitalWatchPage.clickOnAddToCartBtn();

        //add to car validation
        String expextedText="You added Dash Digital Watch to your shopping cart.";
        String actualText=dashDigitalWatchPage.getAddToCartConfirmationText();
        Assert.assertEquals(actualText,expextedText);

        homePageBeforeLogin.clickOnShoppingCartIcon();

        homePageBeforeLogin.clickOnviewAndEditLink();

        shoppingCartPage.clickOnTrashCanIcon();

        String expectedpageTitleWrapper="You have no items in your shopping cart.";
        String actualpageTitleWrapper= shoppingCartPage.getRemoveConfirmationText();
        Assert.assertEquals(actualpageTitleWrapper,expectedpageTitleWrapper);

    }
}
