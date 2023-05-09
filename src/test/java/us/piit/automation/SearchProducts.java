package us.piit.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.SetUp;

public class SearchProducts extends SetUp {
    Logger log= LogManager.getLogger(SearchProducts.class.getName());
    @Test
    public void SearchProduct(){
        // verify the title of the homepage
        String expectedTitle = "Automation Exercise";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        // Type name of product then click on search button
        clickOn("//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/a[1]");
        log.info("click on product button success");

        // Verify user is navigated to ALL PRODUCTS page successfully
        boolean expectedPageWraperTitle=true;
        boolean actualPageWraperTitle=isVisible("#sale_image");
        Assert.assertEquals(expectedPageWraperTitle,actualPageWraperTitle);
        log.info("products visibilities validate");
        type("#search_product","GRAPHIC DESIGN MEN T SHIRT - BLUE");
        log.info("type product name success");
        clickOn("#submit_search");
        log.info("click on search button success");

        // Verify 'SEARCHED PRODUCTS' is visible
        boolean expectedPageHeaderTitle=true;
        boolean actualPageHeaderTitle=isVisible("//h2[contains(text(),'Searched Products')]");
        Assert.assertEquals(expectedPageHeaderTitle,actualPageHeaderTitle);
        log.info("searched product displayed success");



    }
}
