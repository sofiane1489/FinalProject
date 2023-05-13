package us.piit.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;

public class ViewCategoryProducts extends CommonAPI {
    Logger log = LogManager.getLogger(ViewCategoryProducts .class.getName());
    @Test
    public void viewCategoryProduct(){

        clickOn("//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/a[1]");
        log.info("click on product button success");
        // Verify that categories are visible on left side bar
//        boolean actualCategoryproductVisible=isVisible("//h2[contains(text(),'Category')]");
//        Assert.assertTrue(actualCategoryproductVisible);
//        log.info("category product is visible");
//        waitFor(2);

        // click on women category,click on Tops,
        clickOn("//div[@id='Men']");
        log.info("click on men category success");



    }
}
