package stepDef;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class ZoomStepDef {

    SetUp setUp;

    public ZoomStepDef(SetUp setUp){
        this.setUp=setUp;
    }


    @Given("User navigates to luma url {string}")
    public void user_navigates_to_luma_url(String url) {
        setUp.driver.get(url);
    }
    @Then("User should see title {string} and Luma logo should be present")
    public void user_should_see_title_and_luma_logo_should_be_present(String title) {
        Assert.assertEquals(setUp.driver.getTitle(),title);
        Assert.assertTrue(setUp.driver.findElement(By.cssSelector("img[src='https://magento.softwaretestingboard.com/pub/static/version1678540400/frontend/Magento/luma/en_US/images/logo.svg']")).isDisplayed());

    }
    @When("User clicks on the Men category")
    public void user_clicks_on_the_men_category() {
        setUp.driver.findElement(By.xpath("//span[text()='Men']")).click();
    }
    @When("User clicks on Top")
    public void user_clicks_on_top() {
        setUp.driver.findElement(By.xpath("//a[text()='Tops']")).click();
    }

    @When("user clicks on product name Sparta Gym Tank")
    public void user_click_on_product_name() {
        setUp.driver.findElement(By.cssSelector("img[src='https://magento.softwaretestingboard.com/pub/media/catalog/product/cache/7c4c1ed835fbbf2269f24539582c6d44/m/t/mt08-green_main_1.jpg']")).click();
    }

    @And("User hovers over the product image and clicks")
    public void user_hovers_over_the_product_image(){
        Actions actions= new Actions(setUp.driver);
        actions.moveToElement(setUp.driver.findElement(By.cssSelector("img[src='https://magento.softwaretestingboard.com/pub/media/catalog/product/cache/d34482110da20c5e24f97c38fb219fb3/m/t/mt08-green_main_1.jpg']"))).click().build().perform();

    }

    @When("user clicks on zoom-in button and verifies the image is zoomed-in")
    public void the_image_should_be_zoomed_in(){
        Actions actions= new Actions(setUp.driver);
        int originalImageWidth =  setUp.driver.findElement(By.cssSelector("img[src='https://magento.softwaretestingboard.com/pub/media/catalog/product/cache/c2e58f207611755436220741b3fe027b/m/t/mt08-green_main_1.jpg']")).getSize().getWidth();

        actions.moveToElement(setUp.driver.findElement(By.cssSelector(".fotorama__zoom-in.zoom-in-loaded"))).doubleClick().doubleClick().click().click().click().build().perform();

        WebElement zoomedImage = setUp.driver.findElement(By.cssSelector(".fotorama__img--full.fotorama__img--zoommable"));
        int zoomedImageWidth = zoomedImage.getSize().getWidth();
        System.out.println("The original image width: " + originalImageWidth);
        System.out.println("The zoomed image width: " + zoomedImageWidth);
        Assert.assertTrue(zoomedImageWidth > originalImageWidth);
    }

}
