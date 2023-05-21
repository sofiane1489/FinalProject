package us.piit.luma;

import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.lumaPages.HomePageBeforeLogin;
import us.piit.lumaPages.OrderAndReturnPage;
import us.piit.lumaPages.OrderInformationPage;
import us.piit.utility.Utility;
import java.util.Properties;

public class OrderTrackingTest extends CommonAPI {

      Properties pro=Utility.loadProperties();

      String orderID = Utility.decode(pro.getProperty("luma.orderID"));
      String lastName= Utility.decode(pro.getProperty("luma.lastName"));
      String email=Utility.decode(pro.getProperty("luma.email"));

    @Test
    public void orderStatus(){
        HomePageBeforeLogin homePageBeforeLogin=new HomePageBeforeLogin(getDriver());
        OrderAndReturnPage orderAndReturnPage=new OrderAndReturnPage(getDriver());
        OrderInformationPage orderInformationPage=new OrderInformationPage(getDriver());

        // website validation with Title
        String expextedTitle="Home Page";
        String actualTitle=getCurrentTtile();
        Assert.assertEquals(actualTitle,expextedTitle);
        // website validation with luma logo
        Assert.assertTrue(homePageBeforeLogin.checkHomePageLogoVisibility());

        scrollToBottom();
        homePageBeforeLogin.clickOnOrderAndReturnLink();
        orderAndReturnPage.enterOrderID(orderID);
        orderAndReturnPage.enterBillingLastName(lastName);
        orderAndReturnPage.enterEmail(email);
        orderAndReturnPage.clickOnContinueBtn();

        //orderID validation
        String expectedOrderID="Order # "+orderID;
        Assert.assertEquals(expectedOrderID,orderInformationPage.getOrderIDText());

       //order status validation
       String expectedOrderStatus="PENDING";
       Assert.assertEquals(expectedOrderStatus,orderInformationPage.getOrderStatus());




    }
}
