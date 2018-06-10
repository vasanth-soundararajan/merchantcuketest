package org.merchant.test.steps;

import java.util.List;

import org.junit.Assert;
import org.merchant.test.common.Constants;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

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
    
    @Given("^selected \"([^\"]*)\" filter$")
    public void selected_user_filter_value(String arg0) throws Throwable {
        driver.get(Constants.BASE_URL);
        driver.findElement(By.id("users")).click();

        Select select = new Select(driver.findElement(By.xpath("//div[@id='q_username_input']//select")));
        select.selectByVisibleText("Equals");
        driver.findElement(By.id("q_username")).sendKeys(arg0);
    }

    @When("^Submitted the filter$")
    public void submitted_the_filter() throws Throwable {
        driver.findElement(By.xpath("//input[@name='commit']")).click();
    }

    @Then("^Checked the results$")
    public void checked_the_results() throws Throwable {
        List<WebElement> users = driver.findElements(By.xpath("html/body/div[1]/div[4]/div[1]/div/form/div[2]/div[1]/div/div/table/tbody"));
        
        Assert.assertTrue(users.size() > 0);
    }
    
    @And("^delete user$")
    public void deleteUser() throws Throwable {
        driver.findElement(By.cssSelector("div > a.delete_link.member_link")).click();
        WebDriverWait wait = new WebDriverWait(driver, 3000);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
