package com.quali.org.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class accountsSuccessPage {
WebDriver driver;
@FindBy(xpath="//h1[contains(text(),'Your Account Has Been Created!')]")
private WebElement accountCreationSuccessMsgText;

public accountsSuccessPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public String assertAccountSuccessPage() {
	String accountCreationSuccessMsg=accountCreationSuccessMsgText.getText();
	return accountCreationSuccessMsg;
}
}
