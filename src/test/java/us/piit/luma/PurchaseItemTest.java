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
    Logger log= LogManager.getLogger(PurchaseItemTest.class.getName());

    Properties pro= Utility.loadProperties();

    String emailUsed=Utility.decode(pro.getProperty("luma.email")) ;
    String firstNameUsed=Utility.decode(pro.getProperty("luma.firstname")) ;
    String lastNameUsed= Utility.decode(pro.getProperty("luma.lastname")) ;
    String companyNameUsed=Utility.decode(pro.getProperty("luma.companyName"));
    String addressUsed=Utility.decode(pro.getProperty("luma.address"));
    String cityNameUsed=Utility.decode(pro.getProperty("luma.city"));
    String stateused=Utility.decode(pro.getProperty("luma.state"));
    String zipCodeUsede=Utility.decode(pro.getProperty("luma.zipcode"));
    String phoneNumberUsed=Utility.decode(pro.getProperty("luma.telephoneNumber"));

    @Test
    public void addItemToCart(){
        HomePageBeforeLogin homePageBeforeLogin=new HomePageBeforeLogin(getDriver());
        MenPage menPage=new MenPage(getDriver());
        TopsPage topsPage=new TopsPage(getDriver());
        CassiusSparringTankPage cassiusSparringTankPage=new CassiusSparringTankPage(getDriver());

        // website validation with Title
        String expextedTitle="Home Page";
        String actualTitle=getCurrentTtile();
        Assert.assertEquals(actualTitle,expextedTitle);
        // website validation with luma logo
        Assert.assertTrue(homePageBeforeLogin.homePageLogoVisibility());

        homePageBeforeLogin.clickOnMenCategory();

        menPage.clickOnTops48InMenCategory();

        topsPage.clickOnCassiusSparringTank();


        cassiusSparringTankPage.clickOnSizeLabel();

        cassiusSparringTankPage.clickOnBlueColor();


        cassiusSparringTankPage.clickOnAddToCartBtn();

        //add to car validation
        String expextedText="You added Cassius Sparring Tank to your shopping cart.";
        String actualText= cassiusSparringTankPage.getConfirmationText();
        Assert.assertEquals(actualText,expextedText);

    }

    @Test
    public void buyProduct(){
        HomePageBeforeLogin homePageBeforeLogin=new HomePageBeforeLogin(getDriver());
        FitnessEquipmentPage fitnessEquipmentPage=new FitnessEquipmentPage(getDriver());
        QuestLumaflexBandPage questLumaflexBandPage=new QuestLumaflexBandPage(getDriver());
        ShippingAddressPage shippingAddressPage=new ShippingAddressPage(getDriver());
        GearPage gearPage=new GearPage(getDriver());

        // website validation with Title
        String expextedTitle="Home Page";
        String actualTitle=getCurrentTtile();
        Assert.assertEquals(actualTitle,expextedTitle);
        // website validation with luma logo
        Assert.assertTrue(homePageBeforeLogin.homePageLogoVisibility());

        homePageBeforeLogin.clickOnGearcategory();

        gearPage.clickOnFitnessEquipment();

        fitnessEquipmentPage.clickOnQuestLumaflexBand();

       questLumaflexBandPage.clickOnAddToCartBtn();

       //add to cart validation
       String expextedText="You added Quest Lumaflex™ Band to your shopping cart.";
       String actualText= questLumaflexBandPage.getTextConfirmation();
        Assert.assertEquals(actualText,expextedText);


        //navigate to cart
        homePageBeforeLogin.clickOnShoppingCartIcon();

        homePageBeforeLogin.clickOnProceedToCheckOutBtn();

        shippingAddressPage.enterEmailAddress(emailUsed);

        shippingAddressPage.enterFirstName(firstNameUsed);

        shippingAddressPage.enterlastName(lastNameUsed);

        shippingAddressPage.entercompanyName(companyNameUsed);

        shippingAddressPage.enterStreetAddress(addressUsed);

        shippingAddressPage.enterCityName(cityNameUsed);

        shippingAddressPage.selectState(stateused);

        shippingAddressPage.enterZipCode(zipCodeUsede);

        shippingAddressPage.enterPhoneNumber(phoneNumberUsed);

        shippingAddressPage.selectShippingMethod();

        shippingAddressPage.clickOnNextBtn();

        waitFor(3);
        shippingAddressPage.clickOnPlaceOrderBtn();

        //purchase validation:
        String expectedMessage="Thank you for your purchase!";
        String actualMessage= shippingAddressPage.getPurchaseConfirmationText();
        Assert.assertEquals(actualMessage,expectedMessage);

    }
    @Test
    public void removeItemsFromTheCart(){
        HomePageBeforeLogin homePageBeforeLogin=new HomePageBeforeLogin(getDriver());
        GearPage gearPage=new GearPage(getDriver());
        WatchesPage watchesPage=new WatchesPage(getDriver());
        DashDigitalWatchPage dashDigitalWatchPage=new DashDigitalWatchPage(getDriver());
        ShoppingCartClass shoppingCartClass=new ShoppingCartClass(getDriver());

        // website validation with Title
        String expextedTitle="Home Page";
        String actualTitle=getCurrentTtile();
        Assert.assertEquals(actualTitle,expextedTitle);
        // website validation with luma logo
        Assert.assertTrue(homePageBeforeLogin.homePageLogoVisibility());

        //click on Gear section
        homePageBeforeLogin.clickOnGearcategory();

        gearPage.clickOnWatchesSection();

        watchesPage.clickOnDashDigitalWatch();

        dashDigitalWatchPage.clickOnAddToCartBtn();

        //add to car validation
        String expextedText="You added Dash Digital Watch to your shopping cart.";
        String actualText=dashDigitalWatchPage.getAddToCartConfirmationText();
        Assert.assertEquals(actualText,expextedText);

        homePageBeforeLogin.clickOnShoppingCartIcon();

        homePageBeforeLogin.clickOnviewAndEditLink();

        shoppingCartClass.clickOnTrashCanIcon();

        String expectedpageTitleWrapper="You have no items in your shopping cart.";
        String actualpageTitleWrapper=shoppingCartClass.getRemoveConfirmationText();
        Assert.assertEquals(actualpageTitleWrapper,expectedpageTitleWrapper);
        log.info("item removed success");

    }
}
