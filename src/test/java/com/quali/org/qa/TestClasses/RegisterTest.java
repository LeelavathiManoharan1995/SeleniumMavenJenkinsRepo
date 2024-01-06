package com.quali.org.qa.TestClasses;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.quali.org.qa.BasicPackage.BaseClass1;
import com.quali.org.qa.Pages.HomePage;
import com.quali.org.qa.Pages.LoginPage;
import com.quali.org.qa.Pages.RegisterPage;
import com.quali.org.qa.Pages.accountsSuccessPage;

public  class RegisterTest  extends BaseClass1{
	public static WebDriver driver;
	public static String EmailId;
	public static String pwd;
//	public static final String EmailID = "";
//	public static final String pwd="";

	public RegisterTest() {
		super();
	}
@BeforeMethod
	public void initialSetup() {
		driver=launchBrowserandOpenWebsite(props.getProperty("browserName"));
		HomePage homepageobj=new HomePage(driver);
		homepageobj.clickOnMyAccount();
	}
@Test(priority = 1)
public static void  RegisterAsNewAccount() {
	HomePage homepageobj=new HomePage(driver);

	homepageobj.clickOnRegister();

	RegisterPage regPageobj=new RegisterPage(driver);
	accountsSuccessPage accSuccessPageobj=new accountsSuccessPage(driver);
	Random randomstring=new Random();
	regPageobj.enterFirstname("leela12");
	regPageobj.enterLastname("naren");
	 EmailId=regPageobj.enterEmailId("leelad"+randomstring.nextInt()+"@gmail.com");
	System.out.println("My account EmailId is"+ EmailId);
    regPageobj.entertelephone("7619610250");
     pwd=regPageobj.enterPassword("12345"+randomstring.nextInt());
	System.out.println("My account Password is"+ pwd);
	regPageobj.enterconfimrPassword(pwd);
	regPageobj.subscribeAsYes();
	regPageobj.clickOnPrivacyPolicyCheckbox();
	regPageobj.clickOnContinue();
	String actualSuccessMsg= accSuccessPageobj.assertAccountSuccessPage();
	String expectedSuccessMsg="Your Account Has Been Created!";
	AssertJUnit.assertEquals(actualSuccessMsg, expectedSuccessMsg);
//Login with registered creds
	LoginPage loginpage=new LoginPage(driver);
	loginpage.clickOnLogout();
	HomePage homepageobj1=new HomePage(driver);
	homepageobj1.clickOnMyAccount();
	homepageobj1.clickOnLogin();
	loginpage.enterUsername(EmailId);
	loginpage.enterpassword(pwd);
	loginpage.clickOnLogin();
	
	String actualEditinfoMsg=	loginpage.validateeditaccountAssertText();
	String expectedEditinfoMsg="Edit your account information";
	AssertJUnit.assertEquals(actualEditinfoMsg, expectedEditinfoMsg);


	//loginpageT.c

}
/*@Test(priority = 2)
//@Parameters(EmailId, "pwd"})
 public void loginWithRegisteredCredentials(String Emailid,String pwd) {
	RegisterTest.EmailId=Emailid;
	RegisterTest.pwd=pwd;
	HomePage homepageobj=new HomePage(driver);
	homepageobj.clickOnLogin();
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterUsername(Emailid);
	loginpage.enterpassword(pwd);
	loginpage.clickOnLogin();
	

}*/


@Test(priority = 2)
public void assertAllwarnings() {
	RegisterPage regPageobj=new RegisterPage(driver);
	HomePage homepageobj=new HomePage(driver);
	homepageobj.clickOnRegister();
	regPageobj.clickOnContinue();
	
	String actualfirstNamewarn=regPageobj.verifyFirstNamewarning();
	String expectedfirstNamewarn="First Name must be between 1 and 32 characters!";
	AssertJUnit.assertEquals(actualfirstNamewarn, expectedfirstNamewarn);
	
	String actualLastNamewarn=regPageobj.verifylastNamewarning();
	String expectedLastNamewarn="Last Name must be between 1 and 32 characters!";
	AssertJUnit.assertEquals(actualLastNamewarn, expectedLastNamewarn);

String actualEmailIdwarn=regPageobj.verifyemailIDwarning();
String expectedEmailIdwarn="E-Mail Address does not appear to be valid!";
AssertJUnit.assertEquals(actualEmailIdwarn, expectedEmailIdwarn);

String actualtelephonewarn=regPageobj.verifytelephonewarning();
String expectedtelephoneWarn="Telephone must be between 3 and 32 characters!";
AssertJUnit.assertEquals(actualtelephonewarn, expectedtelephoneWarn);

String actualPasswordwarn=	regPageobj.verifyPasswordwarning();
String expectedPasswordWarn="Password must be between 4 and 20 characters!";
AssertJUnit.assertEquals(actualPasswordwarn, expectedPasswordWarn);

String actualprivacywarn=regPageobj.verifyPrivacypolicywarning();
String expectedprivacyWarn="Warning: You must agree to the Privacy Policy!";
AssertJUnit.assertEquals(actualprivacywarn, expectedprivacyWarn);


	
	
}
@AfterMethod
@AfterMethod
public void tearDown() {
	driver.quit();
}
}
