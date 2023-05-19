package us.piit.automation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.automationPages.HomePage;
import us.piit.automationPages.WomensProductPage;
import us.piit.base.CommonAPI;
import us.piit.utility.Utility;

import java.util.Properties;

public class CategoryProducts extends CommonAPI {
    Logger log = LogManager.getLogger(CategoryProducts.class.getName());


    @Test
    public void womenCategory(){
        HomePage homePage=new HomePage(getDriver());
        WomensProductPage womensProductPage= new WomensProductPage(getDriver());


        //Verify that categories are visible on left sidebar
        boolean expectedTitle=true;
        boolean actualtitle2=homePage.categorynamevisibility();
        Assert.assertEquals(expectedTitle,actualtitle2);

        // click on womens category then click on sub category "TOPS"
        homePage.clickonWomenCategory();
        womensProductPage.clickonWomenTops();



        // verify the title "women tops" is visible
        boolean expectedTitle3=true;
        boolean actualtitle3= womensProductPage.getwomentopsTitle();
        Assert.assertEquals(expectedTitle3,actualtitle3);



    }
}
