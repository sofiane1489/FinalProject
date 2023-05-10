package us.piit.automationpractice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;

public class SearchBarTest extends CommonAPI {
    Logger log = LogManager.getLogger(SearchBarTest.class.getName());
    @Test
    public void searchItem(){
        String expectedTitle = "My Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);
        //enter  username, password, and click on login button
        clickOn("#header > div.nav > div > div > nav > div.header_user_info > a");
        type("#email","yaya@gmail.com");
        log.info("enter email success");

        type("#passwd","abcd1234$");
        log.info("enter password success");

        clickOn("#SubmitLogin");
        log.info("click on login button Success");
        //chech search bar
        type("#search_query_top","T-shirt");
        log.info("type on search bar success");

        clickOn("#searchbox button");
        log.info("click on search button success");
        //Item validation
        String expectedMess="1 result has been found.";
        String actualMess=getElementText("//*[@id=\"center_column\"]/h1/span[2]");
        Assert.assertEquals(actualMess,expectedMess);
        log.info("message validation success");

        String expectedSearch="\"T_SHIRTS\"";
        String actualSearch=getElementText("//*[@id=\"center_column\"]/h1/span[1]");
        Assert.assertEquals(actualMess,expectedMess);
        log.info("search validation success");

    }


}