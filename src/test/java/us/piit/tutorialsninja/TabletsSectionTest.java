package us.piit.tutorialsninja;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.tutorialsninjaPage.*;
import us.piit.utility.Utility;

import java.util.Properties;

public class TabletsSectionTest extends CommonAPI {
    Properties pro = Utility.loadProperties();

    String validEmail = Utility.decode(pro.getProperty("tutorialsninja.email"));
    String userPassword = Utility.decode(pro.getProperty("tutorialsninja.password"));

    String userComment = Utility.decode(pro.getProperty("tutorialsninja.comment"));
   // @Test
    public void tabletsSection() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        TabletsPage tabletsPage = new TabletsPage(getDriver());
        String expectedTitle = "Your Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        //enter  username, password, and click on login button
        welcomePage.clickOnMyAccountBtn();
        welcomePage.hoverOverAndClickOnHeaderLoginBtn();
        loginPage.enterValidEmail(validEmail);
        loginPage.enterValidPassword(userPassword);
        loginPage.clickOnLoginBtn();

        //click on tablets section
        homePage.clickOnTabletsSectionBtn();

        //tablets section validation
        String expectedValidTabSection = "Tablets";
        String actualValidTabSection = tabletsPage.getTabSectionValidation();
        Assert.assertEquals(expectedValidTabSection, actualValidTabSection);
        captureScreenshot();

    }

    @Test
    public void writeReview() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        TabletsPage tabletsPage = new TabletsPage(getDriver());
        TabletsProductPage tabletsProductPage = new TabletsProductPage(getDriver());
        String expectedTitle = "Your Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        //enter  username, password, and click on login button
        welcomePage.clickOnMyAccountBtn();
        welcomePage.hoverOverAndClickOnHeaderLoginBtn();
        loginPage.enterValidEmail(validEmail);
        loginPage.enterValidPassword(userPassword);
        loginPage.clickOnLoginBtn();

        //navigate to review form
        homePage.clickOnTabletsSectionBtn();
        tabletsPage.clickOnProductImg();
        tabletsProductPage.scrollToAddReviewBtn(getDriver());
        tabletsProductPage.enterComment(userComment);
        tabletsProductPage.clickOnStarCheckBox();
        tabletsProductPage.clickOnContinueBtn();

        //review validation
        String expectedNotificationMessage = "Thank you for your review. It has been submitted to the webmaster for approval.";
        String actualNotificationMessage = tabletsProductPage.getSubmissionConfirmationMessage();
        Assert.assertEquals(expectedNotificationMessage, actualNotificationMessage);
    }
}
