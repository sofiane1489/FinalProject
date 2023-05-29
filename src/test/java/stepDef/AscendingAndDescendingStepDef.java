package stepDef;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AscendingAndDescendingStepDef {

    SetUp setUp;

    public AscendingAndDescendingStepDef(SetUp setUp){
        this.setUp=setUp;
    }

    @When("user navigate to men category")
    public void user_navigate_to_men_category() {
        setUp.driver.findElement(By.xpath("//span[text()='Men']")).click();
    }
    @When("user click on top")
    public void user_click_on_top() {
        setUp.driver.findElement(By.xpath("//a[text()='Tops']")).click();
    }
    @Then("user click on the dropdown button sort by and select price")
    public void user_click_on_the_dropdown_button_sort_by() {
        Select select=new Select(setUp.driver.findElement(By.xpath("//div[2]//div[4]//select[1]")));
        select.selectByIndex(2);
        setUp.scrollToElement(setUp.driver,setUp.driver.findElement(By.xpath("//div[2]//div[4]//select[1]")));
    }
    @Then("user click on set descending direction")
    public void user_click_on_set_descending_direction() {
        setUp.driver.findElement(By.cssSelector("body > div:nth-child(4) > main:nth-child(4) > div:nth-child(4) > div:nth-child(1) > div:nth-child(3) > div:nth-child(5) > a:nth-child(3)")).click();
        setUp.scrollToElement(setUp.driver,setUp.driver.findElement(By.xpath("//div[2]//div[4]//select[1]")));
    }
    @Then("user should see {string} at the top of the list")
    public void user_should_see_at_the_top_of_the_list(String firstProduct) {
        setUp.scrollToElement(setUp.driver,setUp.driver.findElement(By.xpath("//div[2]//div[4]//select[1]")));
        Assert.assertEquals(setUp.driver.findElement(By.cssSelector("body > div:nth-child(4) > main:nth-child(4) > div:nth-child(4) > div:nth-child(1) > div:nth-child(4) > ol:nth-child(1) > li:nth-child(1) > div:nth-child(1) > div:nth-child(2) > strong:nth-child(1) > a:nth-child(1)")).getText(),firstProduct);

    }


}
