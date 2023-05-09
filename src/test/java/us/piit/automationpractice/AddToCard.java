package us.piit.automationpractice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.SetUp;

public class AddToCard extends SetUp {
    Logger log= LogManager.getLogger(AddToCard.class.getName());

    @Test
    public void AddItem() {
        String expectedTitle = "My Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);
        //enter  username, password, click on login button,
        clickOn("#header > div.nav > div > div > nav > div.header_user_info > a");
        type("#email","yaya@gmail.com");
        log.info("enter email success");

        type("#passwd","abcd1234$");
        log.info("enter password success");

        clickOn("#SubmitLogin");
        log.info("click on login button Success");
        //select item, add to cart
        clickOn("//*[@id=\"block_top_menu\"]/ul/li[3]/a");
        log.info("click on t_shirts section success");

        clickOn("//*[@id=\"color_2\"]");
        log.info("click on show more success");

        selectByIn("select[id='group_1']",2);
        log.info("select size success");

        clickOn("//*[@id=\"color_14\"]");
        log.info("choose color success");

        clickOn("#quantity_wanted_p > a.btn.btn-default.button-plus.product_quantity_up > span > i");
        log.info("choose quantity success");

        clickOn("//*[@id=\"add_to_cart\"]/button/span");
        log.info("click on add to cart button success");


    }
}
