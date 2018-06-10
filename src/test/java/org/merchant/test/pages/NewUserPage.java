package org.merchant.test.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class NewUserPage {

    @FindBy(xpath = "//*[@id='page_title']")
    WebElement titleNewUser;

    @FindBy(xpath = "//input[@id='user_username']")
    WebElement userName;

    @FindBy(xpath = "//input[@id='user_password']")
    WebElement passWord;

    @FindBy(xpath = "//input[@id='user_email']")
    WebElement userEmail;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement createUser;

    @FindBy(xpath = "//div[@class='flash flash_notice']")
    WebElement flashNotice;

    WebDriver driver;

    public NewUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void createUser(String username,String pass,String email){
        userName.sendKeys(username);
        passWord.sendKeys(pass);
        userEmail.sendKeys(email);
        createUser.click();
    }

    public void verifyNewUserCreation() {
        Assert.assertEquals(flashNotice.getText().equalsIgnoreCase("User was successfully created.") , true);
    }

}
