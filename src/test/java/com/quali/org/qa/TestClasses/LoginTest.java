package com.quali.org.qa.TestClasses;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
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
	AssertJUnit.assertEquals(actualEditinfoMsg, expectedEditinfoMsg);
	
	String ActualchangePwdMsg=loginPageobj.validatechangePwdtext();
	String ExpectedchangePwdMsg="Change your password";
	AssertJUnit.assertEquals(ActualchangePwdMsg, ExpectedchangePwdMsg);
	
	String ActualModifyAddressMsg=loginPageobj.validateModifyAddressText();
	String ExpectedModifyAddressMsg="Modify your address book entries";
	AssertJUnit.assertEquals(ActualModifyAddressMsg, ExpectedModifyAddressMsg);
	

	String ActualModifyListMsg=loginPageobj.validateModifyListsText();
	String ExpectedModifyListMsg="Modify your wish list";
	AssertJUnit.assertEquals(ActualModifyListMsg, ExpectedModifyListMsg);

	String ActualorderHistoryMsg=loginPageobj.validateorderHistoryText();
	String ExpectedorderHistoryMsg="View your order history";
	AssertJUnit.assertEquals(ActualorderHistoryMsg, ExpectedorderHistoryMsg);
	

	String ActualDownloadsMsg=loginPageobj.validateDownloadsText();
	String ExpectedDownloadsMsg="Downloads";
	AssertJUnit.assertEquals(ActualDownloadsMsg, ExpectedDownloadsMsg);
	
	String ActualRewardpointsMsg=loginPageobj.validateRewardpointsText();
	String ExpectedRewardpointsMsg="Your Reward Points";
	AssertJUnit.assertEquals(ActualRewardpointsMsg, ExpectedRewardpointsMsg);
	
	String ActualreturnreqMsg=loginPageobj.validatereturnrequestText();
	String ExpectedreturnreqMsg="View your return requests";
	AssertJUnit.assertEquals(ActualreturnreqMsg, ExpectedreturnreqMsg);
	
	String ActualtxnsMsg=loginPageobj.validateTxnsText();
	String ExpectedtxnsMsg="Your Transactions";
	AssertJUnit.assertEquals(ActualtxnsMsg, ExpectedtxnsMsg);
	
	String ActualrecuuringPayMsg=loginPageobj.validateRecurringPaymentsText();
	String ExpectedrecuuringPayMsg="Recurring payments";
	AssertJUnit.assertEquals(ActualrecuuringPayMsg, ExpectedrecuuringPayMsg);
	
	String ActualRegAffilAccMsg=loginPageobj.validateRegAffilAccText();
	String ExpectedRegAffilAccMsg="Register for an affiliate account";
	AssertJUnit.assertEquals(ActualRegAffilAccMsg, ExpectedRegAffilAccMsg);
	
	String ActualsubunsubMsg=loginPageobj.validatesubUnSubText();
	String ExpectedsubusubMsg="Subscribe / unsubscribe to newsletter";
	AssertJUnit.assertEquals(ActualsubunsubMsg, ExpectedsubusubMsg);
	
	
	}
	
	@AfterMethod
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
