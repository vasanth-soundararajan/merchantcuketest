package org.merchant.test.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

    @FindBy(xpath = "//*[@id='page_title']")
    WebElement titleDashboard;

    @FindBy(xpath = "//a[contains(.,'Users')]")
    WebElement tabUsers;

    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyPage() {
        Assert.assertEquals(titleDashboard.getText().equalsIgnoreCase("Dashboard"), true);
    }

    public boolean isUsersLinkAvailable() {
        boolean isAvailable = false;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement users = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Users')]")));
            isAvailable = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isAvailable;
    }

    public void clickOnUsers() {
        if (isUsersLinkAvailable()) {
            tabUsers.click();
        } else {
            System.out.println("Assert failure to fail the test case if we need 'Users' link compulsory for testcase");
        }
    }

}
