package stepDef;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class UpdateQuantityStepDef {

    SetUp setUp;

    public UpdateQuantityStepDef(SetUp setUp){
        this.setUp=setUp;
    }

    @Then("user hover over Gear category and clicks on Watches")
    public void user_hover_over_gear_category_and_clicks_watches(){
        Actions actions=new Actions(setUp.driver);
        actions.moveToElement(setUp.driver.findElement(By.cssSelector("#ui-id-6")))
                .moveToElement(setUp.driver.findElement(By.cssSelector("#ui-id-27"))).click().build().perform();

    }
    @Then("user clicks on item Dash Digital Watch")
    public void user_clicks_on_item_dash_digital_watch() {
        WebElement element=setUp.driver.findElement(By.cssSelector("img[src='https://magento.softwaretestingboard.com/pub/media/catalog/product/cache/7c4c1ed835fbbf2269f24539582c6d44/m/g/mg02-bk-0.jpg']"));
        setUp.scrollToElement(setUp.driver,element);
        setUp.driver.findElement(By.cssSelector("img[src='https://magento.softwaretestingboard.com/pub/media/catalog/product/cache/7c4c1ed835fbbf2269f24539582c6d44/m/g/mg02-bk-0.jpg']")).click();
    }
    @Then("user update the quantity to {string}")
    public void user_update_the_quantity_to(String number){
        Actions actions=new Actions(setUp.driver);
        WebElement element=setUp.driver.findElement(By.cssSelector("#maincontent div.columns div div.product-info-main div.page-title-wrapper.product h1 span"));
        setUp.scrollToElement(setUp.driver,element);
        actions.moveToElement(setUp.driver.findElement(By.cssSelector("#qty"))).click().doubleClick().sendKeys(number).build().perform();
    }

    @Then("user clicks on Add To Cart button")
    public void user_clicks_on_add_to_cart_button() {
        setUp.driver.findElement(By.cssSelector("#product-addtocart-button")).click();
    }

    @Then("the updated quantity {string} should be displayed in the shopping cart")
    public void the_updated_quantity_should_be_displayed_in_the_shopping_cart(String updatedQty)  throws InterruptedException {
        setUp.waitFor(2);

         WebElement element=setUp.driver.findElement(By.cssSelector("body > div.page-wrapper > header > div.header.content > div.minicart-wrapper > a > span.counter.qty > span.counter-number"));
        System.out.println("the number of element is: "+setUp.getElementTextWithJavaScript(setUp.driver,element));
        Assert.assertEquals(setUp.getElementTextWithJavaScript(setUp.driver,element),updatedQty);

    }
}
