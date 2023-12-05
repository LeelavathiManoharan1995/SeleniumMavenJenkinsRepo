package com.quali.org.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver driver;
@FindBy(xpath="//*[@id='input-email']")
private WebElement usernametextField;

@FindBy(xpath="//*[@id='input-password']")
private WebElement passwordtextField;

@FindBy(xpath="//input[@type='submit']")
private WebElement Loginbutton;

@FindBy(linkText = "Edit your account information")
private WebElement assertEditinfoafterLoginText;

@FindBy(linkText = "Change your password")
private WebElement assertChangepwdfterLoginText;

@FindBy(linkText = "Modify your address book entries")
private WebElement assertModifyAddressafterLoginText;

@FindBy(linkText = "Modify your wish list")
private WebElement assertModifyListafterLoginText;

@FindBy(linkText = "View your order history")
private WebElement assertOrderHistoryafterLoginText;

@FindBy(linkText = "Downloads")
private WebElement assertDownloadsafterLoginText;

@FindBy(linkText = "Your Reward Points")
private WebElement assertRewardPointsafterLoginText;

@FindBy(linkText = "View your return requests")
private WebElement assertreturnRequestafterLoginText;

@FindBy(linkText = "Your Transactions")
private WebElement assertTxnsafterLoginText;

@FindBy(linkText = "Recurring payments")
private WebElement assertRecurringpaymentsafterLoginText;

@FindBy(linkText = "Register for an affiliate account")
private WebElement RegAffilateAccafterLoginText;

@FindBy(linkText = "Subscribe / unsubscribe to newsletter")
private WebElement subcribeUnsubafterLoginText;

@FindBy(linkText = "Logout")
private WebElement logoutbutton;

public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void enterUsername(String EmailId) {
	usernametextField.sendKeys(EmailId);
}
public void enterpassword(String pwd) {
	passwordtextField.sendKeys(pwd);
}
public void clickOnLogin() {
	Loginbutton.click();
}

public void clickOnLogout() {
	logoutbutton.click();
}
public String validateeditaccountAssertText() {
	String editaccountinfoText=assertEditinfoafterLoginText.getText();
	return editaccountinfoText;
}
public String validatechangePwdtext() {
	String changePwdText=assertChangepwdfterLoginText.getText();
	return changePwdText;
}
public String validateModifyAddressText() {
	String modifyAddressText=assertModifyAddressafterLoginText.getText();
	return modifyAddressText;
}
public String validateModifyListsText() {
	String modifyListText=assertModifyListafterLoginText.getText();
	return modifyListText;
}
public String validateorderHistoryText() {
	String orderHistoryText=assertOrderHistoryafterLoginText.getText();
	return orderHistoryText;
}
public String validateDownloadsText() {
	String downloadsText=assertDownloadsafterLoginText.getText();
	return downloadsText;
}
public String validateRewardpointsText() {
	String rewardPointsText=assertRewardPointsafterLoginText.getText();
	return rewardPointsText;
}
public String validatereturnrequestText() {
	String returnreqText=assertreturnRequestafterLoginText.getText();
	return returnreqText;
}
public String validateTxnsText() {
	String txnsText=assertTxnsafterLoginText.getText();
	return txnsText;
}
public String validateRecurringPaymentsText() {
	String reccuPaymentsText=assertRecurringpaymentsafterLoginText.getText();
	return reccuPaymentsText;
}
public String validateRegAffilAccText() {
	String regAffilateAccText=RegAffilateAccafterLoginText.getText();
	return regAffilateAccText;
}
public String validatesubUnSubText() {
	String subUnsubText=subcribeUnsubafterLoginText.getText();
	return subUnsubText;
}
}
