package com.quali.org.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.model.Log;

public class HomePage {
WebDriver driver;
@FindBy(xpath="//span[contains(text(),'My Account')]")
private WebElement MyAccountOptions;
@FindBy(linkText = "Register")
private WebElement RegisterOption;
@FindBy(linkText = "Login")
private WebElement LoginOption;

public HomePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void clickOnMyAccount() {
	MyAccountOptions.click();
}
public void clickOnRegister() {
	RegisterOption.click();
}
public void clickOnLogin() {
	LoginOption.click();
}
}
