package us.piit.luma;

import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.lumaPages.*;

public class AddReviewTest extends CommonAPI {

    @Test
    public void addCustomerReview() {
        HomePageBeforeLogin homePageBeforeLogin = new HomePageBeforeLogin(getDriver());
        FitnessEquipmentPage fitnessEquipmentPage = new FitnessEquipmentPage(getDriver());
        QuestLumaflexBandPage questLumaflexBandPage = new QuestLumaflexBandPage(getDriver());
        ShippingAddressPage shippingAddressPage = new ShippingAddressPage(getDriver());
        GearCategoryPage gearCategoryPage = new GearCategoryPage(getDriver());

        // website validation with Title
        String expextedTitle = "Home Page";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(actualTitle, expextedTitle);
        // website validation with luma logo
        Assert.assertTrue(homePageBeforeLogin.checkHomePageLogoVisibility());

        homePageBeforeLogin.hoverOverGearCategory(getDriver());

        gearCategoryPage.clickOnFitnessEquipment();

        fitnessEquipmentPage.ScrollToItem(getDriver());

        fitnessEquipmentPage.clickOnQuestLumaflexBand();

        questLumaflexBandPage.clickOnAddReviewLink();

        questLumaflexBandPage.selectRating(getDriver());

        questLumaflexBandPage.enterNickname(useFakeFullName());

        questLumaflexBandPage.enterSummary(useFakeSentence());

        questLumaflexBandPage.enterReviewText(useFakeParagraph());

        questLumaflexBandPage.clickOnSubmit(getDriver());

        String expectedConfirmationText="You submitted your review for moderation.";
        Assert.assertEquals(expectedConfirmationText,questLumaflexBandPage.getSubmitTextConfirmation());

    }

    @Test
       public void unableToCustomerReviewWithunselectedRating() {
        HomePageBeforeLogin homePageBeforeLogin = new HomePageBeforeLogin(getDriver());
        FitnessEquipmentPage fitnessEquipmentPage = new FitnessEquipmentPage(getDriver());
        QuestLumaflexBandPage questLumaflexBandPage = new QuestLumaflexBandPage(getDriver());
        ShippingAddressPage shippingAddressPage = new ShippingAddressPage(getDriver());
        GearCategoryPage gearCategoryPage = new GearCategoryPage(getDriver());

        // website validation with Title
        String expextedTitle = "Home Page";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(actualTitle, expextedTitle);
        // website validation with luma logo
        Assert.assertTrue(homePageBeforeLogin.checkHomePageLogoVisibility());

        homePageBeforeLogin.hoverOverGearCategory(getDriver());

        gearCategoryPage.clickOnFitnessEquipment();

        fitnessEquipmentPage.ScrollToItem(getDriver());

        fitnessEquipmentPage.clickOnQuestLumaflexBand();

        questLumaflexBandPage.clickOnAddReviewLink();

        questLumaflexBandPage.enterNickname(useFakeFullName());

        questLumaflexBandPage.enterSummary(useFakeSentence());

        questLumaflexBandPage.enterReviewText(useFakeParagraph());

        questLumaflexBandPage.clickOnSubmit(getDriver());

        String expectedConfirmationText="Please select one of each of the ratings above.";
        Assert.assertEquals(expectedConfirmationText,questLumaflexBandPage.getErrorMessage());

    }

}
