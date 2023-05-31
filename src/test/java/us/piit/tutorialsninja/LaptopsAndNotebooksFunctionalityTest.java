package us.piit.tutorialsninja;

import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.tutorialsninjaPage.HomePage;
import us.piit.tutorialsninjaPage.LaptopsAndNotebooksPage;
import us.piit.tutorialsninjaPage.LoginPage;
import us.piit.tutorialsninjaPage.WelcomePage;
import us.piit.utility.Utility;

import java.util.Properties;

public class LaptopsAndNotebooksFunctionalityTest extends CommonAPI {
    Properties pro = Utility.loadProperties();

    String validEmail = Utility.decode(pro.getProperty("tutorialsninja.email"));
    String userPassword = Utility.decode(pro.getProperty("tutorialsninja.password"));


    @Test(priority = 1)
    public void laptopsAndNotebooksBtnTest() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage(getDriver());
        String expectedTitle = "Your Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        //enter  username, password, and click on login button
        welcomePage.clickOnMyAccountBtn();
        welcomePage.hoverOverAndClickOnHeaderLoginBtn();
        loginPage.enterValidEmail(validEmail);
        loginPage.enterValidPassword(userPassword);
        loginPage.clickOnLoginBtn();

        //land to laptops&notebooks section
        homePage.hoverOverAndclickOnLaptopsAndNotebooksBtn();
        homePage.clickOnShowAllLaptopsAndNotebooks();
        //validate section
        String expectedSectionPageName = "Laptops & Notebooks";
        String actualSectionPageName = laptopsAndNotebooksPage.getSectionPageName();
        Assert.assertEquals(expectedSectionPageName, actualSectionPageName);
    }

    @Test(priority = 2)
    public void ListViewBtnTest() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage(getDriver());
        String expectedTitle = "Your Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        //enter  username, password, and click on login button
        welcomePage.clickOnMyAccountBtn();
        welcomePage.hoverOverAndClickOnHeaderLoginBtn();
        loginPage.enterValidEmail(validEmail);
        loginPage.enterValidPassword(userPassword);
        loginPage.clickOnLoginBtn();

        //land to laptops&notebooks section
        homePage.hoverOverAndclickOnLaptopsAndNotebooksBtn();
        homePage.clickOnShowAllLaptopsAndNotebooks();
        laptopsAndNotebooksPage.clickOnListViewBtn();
        //validate the display in list
        Assert.assertTrue(laptopsAndNotebooksPage.areProductsDisplayedAsList());
    }

    @Test
    public void GridViewBtnTest() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage(getDriver());
        String expectedTitle = "Your Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        //enter  username, password, and click on login button
        welcomePage.clickOnMyAccountBtn();
        welcomePage.hoverOverAndClickOnHeaderLoginBtn();
        loginPage.enterValidEmail(validEmail);
        loginPage.enterValidPassword(userPassword);
        loginPage.clickOnLoginBtn();

        //land to laptops&notebooks section
        homePage.hoverOverAndclickOnLaptopsAndNotebooksBtn();
        homePage.clickOnShowAllLaptopsAndNotebooks();
        laptopsAndNotebooksPage.clickOnGridViewBtn();
        //validate the display in grid
        Assert.assertTrue(laptopsAndNotebooksPage.areProductsDisplayedAsGrid());
    }

    @Test
    public void sortByTest() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage(getDriver());
        String expectedTitle = "Your Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        //enter  username, password, and click on login button
        welcomePage.clickOnMyAccountBtn();
        welcomePage.hoverOverAndClickOnHeaderLoginBtn();
        loginPage.enterValidEmail(validEmail);
        loginPage.enterValidPassword(userPassword);
        loginPage.clickOnLoginBtn();

        //land to laptops&notebooks section
        homePage.hoverOverAndclickOnLaptopsAndNotebooksBtn();
        homePage.clickOnShowAllLaptopsAndNotebooks();
        laptopsAndNotebooksPage.scrollToSorByField(getDriver());

        //laptopsAndNotebooksPage.clickOnSortByField();
        laptopsAndNotebooksPage.clickOnSortByPrice();
        //sortBy validation
        Assert.assertTrue(laptopsAndNotebooksPage.areProductsSortedAsSelectedSortBy());
    }
}
