package stepDef;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import us.piit.base.CommonAPI;

import java.time.Duration;

public class PaginationStepDef{

    SetUp setUp;

    public PaginationStepDef(SetUp setUp){
        this.setUp=setUp;
    }

    @When("I click on the Men category")
    public void i_click_on_the_men_category() {

        setUp.driver.findElement(By.xpath("//span[text()='Men']")).click();
    }

    @Then("I click on Top")
    public void i_click_on_top() {
        setUp.driver.findElement(By.xpath("//a[text()='Tops']")).click();
    }

    @Then("I see the Top page displayed with tile {string}")
    public void i_see_the_top_page_displayed_with_tile(String toolbarAmount) {

        Assert.assertEquals(setUp.driver.findElement(By.cssSelector("#page-title-heading span")).getText(),toolbarAmount);
    }

    @Then("I click on the 'PageNext' link")
    public void i_click_on_the_page_next_link() {
        setUp.driver.findElement(By.cssSelector("#maincontent > div.columns > div.column.main > div:nth-child(5) > div.pages > ul > li.item.pages-item-next > a")).click();
    }

    @Then("I should be on the next page of the results and i should see {string}")
    public void i_should_be_on_the_next_page_of_the_results_and_i_should_see(String pageTwo) {
        Assert.assertEquals(setUp.driver.findElement(By.cssSelector("#maincontent div:nth-child(4) div div:nth-child(3) p")).getText(),pageTwo);

    }

    @Then("I click on the 'PagePrevious' link")
    public void i_click_on_the_page_previous_link() {
        setUp.driver.findElement(By.cssSelector("#maincontent > div.columns > div.column.main > div:nth-child(5) > div.pages > ul > li.item.pages-item-previous")).click();
    }

    @Then("I should be back on the previous page and i should see {string}")
    public void i_should_be_back_on_the_previous_page_and_i_should_see(String title) {
        Assert.assertEquals(setUp.driver.findElement(By.cssSelector("#maincontent div:nth-child(4) div div:nth-child(3) p")).getText(),title);
    }

    @When("I repeat: Click on the Next link until reaching the last page with title {string}")
    public void i_repeat_click_on_the_link_until_reaching_the_last_page(String lastPgae){

        int totalPages = 4;
        try {
            for (int currentPage = 1; currentPage <= totalPages; currentPage++) {
                WebElement nextPageLink = setUp.driver.findElement(By.cssSelector("#maincontent > div.columns > div.column.main > div:nth-child(5) > div.pages > ul > li.item.pages-item-next > a"));
                if (nextPageLink.isDisplayed()) {
                    nextPageLink.click();
                }

            }
        }catch(Exception e){
            Assert.assertEquals(setUp.driver.findElement(By.cssSelector("#maincontent div:nth-child(4) div div:nth-child(3) p")).getText(),lastPgae);
        }

    }

    @Then("I repeat: Click on the previous link until reaching the first page with title {string}")
    public void i_repeat_click_on_the_previous_link_until_reaching_the_first_page_with_title(String pageOne) {

        int totalPages = 4;
        try {
            for (int currentPage = 1; currentPage <= totalPages; currentPage++) {
                WebElement nextPageLink = setUp.driver.findElement(By.cssSelector("#maincontent > div.columns > div.column.main > div:nth-child(5) > div.pages > ul > li.item.pages-item-previous"));
                if (nextPageLink.isDisplayed()) {
                    nextPageLink.click();
                }

            }
        }catch(Exception e){
            Assert.assertEquals(setUp.driver.findElement(By.cssSelector("#maincontent div:nth-child(4) div div:nth-child(3) p")).getText(),pageOne);
        }
    }

}
