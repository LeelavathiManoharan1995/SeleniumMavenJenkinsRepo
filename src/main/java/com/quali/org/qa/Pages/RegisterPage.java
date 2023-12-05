package com.quali.org.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
WebDriver driver;
@FindBy(xpath="//*[@id='input-firstname']")
private WebElement firstNameTextfield;

@FindBy(xpath="//*[@id='input-lastname']")
private WebElement lastNameTextfield;

@FindBy(xpath="//*[@id='input-email']")
private WebElement emailIdTextfield;

@FindBy(xpath="//*[@id='input-telephone']")
private WebElement telePhoneTextfield;

@FindBy(xpath="//*[@id='input-password']")
private WebElement passwordTextfield;

@FindBy(xpath="//*[@id='input-confirm']")
private WebElement confirmPasswordTextfield;

@FindBy(xpath="(//input[@value='1'])[2]")
private WebElement NewsLetterradioButton;

@FindBy(xpath = "//*[@id='content']/form/div/div/input[1]")
private WebElement privacypolicyCheckBox;

@FindBy(xpath="//*[@id='content']/form/div/div/input[2]")
private WebElement continueButton;

@FindBy(xpath="//*[@id='account-register']/div[1]")
private WebElement privacyPolicyWarningalert;

@FindBy(xpath="//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
private WebElement firstNameWarningText;
@FindBy(xpath="//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
private WebElement LastNameWarningText;
@FindBy(xpath="//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
private WebElement emailIdWarningText;
@FindBy(xpath="//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
private WebElement TelephoneWarningText;
@FindBy(xpath="//div[contains(text(),'Password must be between 4 and 20 characters!')]")
private WebElement passwordWarningText;

public RegisterPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);

}
public void enterFirstname(String firstname) {
	firstNameTextfield.sendKeys(firstname);
}
public void enterLastname(String lastname) {
	lastNameTextfield.sendKeys(lastname);
}
public String enterEmailId(String emailid) {
	emailIdTextfield.sendKeys(emailid);
	return emailid;
}
public void entertelephone(String telephone) {
	telePhoneTextfield.sendKeys(telephone);
}
public String enterPassword(String password) {
	passwordTextfield.sendKeys(password);
	return password;
}
public void enterconfimrPassword(String confirmPwd) {
	confirmPasswordTextfield.sendKeys(confirmPwd);
}
public void subscribeAsYes() {
	NewsLetterradioButton.click();
	
}
public void clickOnPrivacyPolicyCheckbox() {
	privacypolicyCheckBox.click();
}
public void clickOnContinue() {
	continueButton.click();
}

public String verifyPrivacypolicywarning() {
	String privacyPolicywarnMsg=privacyPolicyWarningalert.getText();
	return privacyPolicywarnMsg;
}
public String verifyFirstNamewarning() {
	String privacyPolicywarnMsg=firstNameWarningText.getText();
	return privacyPolicywarnMsg;
}
public String verifylastNamewarning() {
	String privacyPolicywarnMsg=LastNameWarningText.getText();
	return privacyPolicywarnMsg;
}
public String verifyemailIDwarning() {
	String privacyPolicywarnMsg=emailIdWarningText.getText();
	return privacyPolicywarnMsg;
}
public String verifytelephonewarning() {
	String privacyPolicywarnMsg=TelephoneWarningText.getText();
	return privacyPolicywarnMsg;
}
public String verifyPasswordwarning() {
	String privacyPolicywarnMsg=passwordWarningText.getText();
	return privacyPolicywarnMsg;
}

}
