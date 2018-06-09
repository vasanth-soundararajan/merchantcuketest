package org.merchant.test.steps;

import java.util.List;

import org.merchant.test.common.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class UserFiltersSteps {

    public WebDriver driver;
    
    public UserFiltersSteps() {
    	driver = Hooks.driver;
    }

    @Given("^selected the USERNAME selectbox and value$")
    public void selected_the_USERNAME_selectbox_and_value() throws Throwable {
        driver.get(Constants.BASE_URL);
        driver.findElement(By.id("users")).click();

        Select select = new Select(driver.findElement(By.xpath("//div[@id='q_username_input']//select")));
        select.selectByVisibleText("Equals");
        driver.findElement(By.id("q_username")).sendKeys("test29");
    }

    @Then("^Submitted the filter$")
    public void submitted_the_filter() throws Throwable {
        driver.findElement(By.xpath("//input[@name='commit']")).click();
        List<WebElement> users = driver.findElements(By.xpath("html/body/div[1]/div[4]/div[1]/div/form/div[2]/div[1]/div/div/table/tbody"));

        if(users.size() > 0) {
          for (WebElement li : users) {

          }
        }
    }

    @Then("^Checked the results$")
    public void checked_the_results() throws Throwable {

    }
}
