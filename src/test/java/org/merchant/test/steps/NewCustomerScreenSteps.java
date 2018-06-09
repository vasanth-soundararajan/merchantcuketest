package org.merchant.test.steps;

import org.junit.Assert;
import org.merchant.test.common.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NewCustomerScreenSteps {

    public WebDriver driver;
    
    public NewCustomerScreenSteps() {
    	driver = Hooks.driver;
    }

	@Given("^Opened application and routed to New user creation page$")
	public void opened_application_and_routed_to_New_user_creation_page() throws Throwable {
		driver.get(Constants.BASE_URL);
		assert driver.getTitle().contains("Admin");
	}

	@When("^user entered valid \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void userEnteredValid(String arg0, String arg1, String arg2) throws Throwable {
		driver.findElement(By.id("users")).click();
		driver.findElement(By.linkText("New User")).click();
		driver.findElement(By.id("user_username")).sendKeys(arg0);
		driver.findElement(By.id("user_email")).sendKeys(arg1);
		driver.findElement(By.id("user_password")).sendKeys(arg2);
	}

	@Then("^User created$")
	public void userCreated() throws Throwable {
		try {
			driver.findElement(By.xpath("//input[@name='commit']")).click();
			String runSucessMsg = driver.findElement(By.className("flash flash_notice")).getText();
			String custdetailsmsg = driver.findElement(By.xpath("//h3[contains(text(),'Customer Details')]")).getText();

			System.out.println("After runSucessMsg");

			if (!runSucessMsg.isEmpty()) {
				runSucessMsg = runSucessMsg.split("\n")[0].trim();
				Assert.assertEquals(custdetailsmsg, "Customer Details");
				Assert.assertEquals(runSucessMsg, "User was successfully created.");
			} else {
				String alreayTakenUID = driver.findElement(By.linkText("has already been taken")).getText();
				Assert.assertEquals(alreayTakenUID, "has already been taken");
			}

		} catch (Exception e) {
			System.out.println("Exception :" + e);
		}
	}
}
