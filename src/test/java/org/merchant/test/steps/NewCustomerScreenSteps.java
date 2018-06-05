package org.merchant.test.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewCustomerScreenSteps {
	private static final String APP_URL = "http://ec2-54-174-213-136.compute-1.amazonaws.com:8080/admin";
	WebDriver driver;

	@Given("^Opened application and routed to New user creation page$")
	public void opened_application_and_routed_to_New_user_creation_page() throws Throwable {
		driver = new FirefoxDriver();
		driver.get(APP_URL);
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
		// driver.close();
		driver.quit();
	}

}
