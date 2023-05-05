package us.piit.luma;

import org.testng.annotations.Test;
import us.piit.SetUp;

public class AddItemToCar extends SetUp {

    @Test
    public void addItem(){
      clickOn("#ui-id-5 > span:nth-child(2)");
      clickOn("#narrow-by-list2 > dd > ol > li:nth-child(1) > a");
      clickOn("img[alt='Cassius Sparring Tank']");
      clickOn("#option-label-size-143-item-167");
      clickOn("#option-label-color-93-item-50");
        delete("#qty");
       type("#qty","4");
      clickOn("#product-addtocart-button");

    }
}
