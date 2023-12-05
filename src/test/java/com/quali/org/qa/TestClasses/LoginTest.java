package com.quali.org.qa.TestClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.quali.org.qa.BasicPackage.BaseClass1;
import com.quali.org.qa.Pages.HomePage;
import com.quali.org.qa.Pages.LoginPage;
//import com.quali.org.qa.TestClasses.RegisterTest;
import com.quali.org.qa.Pages.RegisterPage;

public class LoginTest extends BaseClass1 {
	public static WebDriver driver;
	//RegisterTest regTest=new RegisterTest();

	public LoginTest() {
		super();
	}
	
	@BeforeMethod
	public void initialSetup() {
		driver=launchBrowserandOpenWebsite(props.getProperty("browserName"));
		HomePage homepageobj=new HomePage(driver);
		homepageobj.clickOnMyAccount();
		homepageobj.clickOnLogin();
		
		
	}
	@Test(priority = 1)
	//@Parameters({"EmailId", "pwd"})

	public  void loginWithValidCredentials() {

		LoginPage loginPageobj=new LoginPage(driver);
		//RegisterPage regPageobj=new RegisterPage(driver);

		loginPageobj.enterUsername(props.getProperty("username"));
		loginPageobj.enterpassword(props.getProperty("password"));
		loginPageobj.clickOnLogin();
	
	
	

	String actualEditinfoMsg=	loginPageobj.validateeditaccountAssertText();
	String expectedEditinfoMsg="Edit your account information";
	Assert.assertEquals(actualEditinfoMsg, expectedEditinfoMsg);
	
	String ActualchangePwdMsg=loginPageobj.validatechangePwdtext();
	String ExpectedchangePwdMsg="Change your password";
	Assert.assertEquals(ActualchangePwdMsg, ExpectedchangePwdMsg);
	
	String ActualModifyAddressMsg=loginPageobj.validateModifyAddressText();
	String ExpectedModifyAddressMsg="Modify your address book entries";
	Assert.assertEquals(ActualModifyAddressMsg, ExpectedModifyAddressMsg);
	

	String ActualModifyListMsg=loginPageobj.validateModifyListsText();
	String ExpectedModifyListMsg="Modify your wish list";
	Assert.assertEquals(ActualModifyListMsg, ExpectedModifyListMsg);

	String ActualorderHistoryMsg=loginPageobj.validateorderHistoryText();
	String ExpectedorderHistoryMsg="View your order history";
	Assert.assertEquals(ActualorderHistoryMsg, ExpectedorderHistoryMsg);
	

	String ActualDownloadsMsg=loginPageobj.validateDownloadsText();
	String ExpectedDownloadsMsg="Downloads";
	Assert.assertEquals(ActualDownloadsMsg, ExpectedDownloadsMsg);
	
	String ActualRewardpointsMsg=loginPageobj.validateRewardpointsText();
	String ExpectedRewardpointsMsg="Your Reward Points";
	Assert.assertEquals(ActualRewardpointsMsg, ExpectedRewardpointsMsg);
	
	String ActualreturnreqMsg=loginPageobj.validatereturnrequestText();
	String ExpectedreturnreqMsg="View your return requests";
	Assert.assertEquals(ActualreturnreqMsg, ExpectedreturnreqMsg);
	
	String ActualtxnsMsg=loginPageobj.validateTxnsText();
	String ExpectedtxnsMsg="Your Transactions";
	Assert.assertEquals(ActualtxnsMsg, ExpectedtxnsMsg);
	
	String ActualrecuuringPayMsg=loginPageobj.validateRecurringPaymentsText();
	String ExpectedrecuuringPayMsg="Recurring payments";
	Assert.assertEquals(ActualrecuuringPayMsg, ExpectedrecuuringPayMsg);
	
	String ActualRegAffilAccMsg=loginPageobj.validateRegAffilAccText();
	String ExpectedRegAffilAccMsg="Register for an affiliate account";
	Assert.assertEquals(ActualRegAffilAccMsg, ExpectedRegAffilAccMsg);
	
	String ActualsubunsubMsg=loginPageobj.validatesubUnSubText();
	String ExpectedsubusubMsg="Subscribe / unsubscribe to newsletter";
	Assert.assertEquals(ActualsubunsubMsg, ExpectedsubusubMsg);
	
	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
