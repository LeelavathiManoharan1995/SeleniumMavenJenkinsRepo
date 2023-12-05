package com.quali.org.qa.BasicPackage;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass1 {
	
WebDriver driver;
public Properties props;
public static ExtentReports extentreports;
public static ExtentTest extentTest;

public BaseClass1() {
	 props=new Properties();
	File configFile=new File(System.getProperty("user.dir")+"/src/main/java/com/quali/org/qa/Configuration/config.properties");
	try {
		FileInputStream fis=new FileInputStream(configFile);
		props.load(fis);
	}
	catch(Throwable exp) {
		exp.printStackTrace();
	}
}
	public WebDriver launchBrowserandOpenWebsite(String browserName) {
		//browserName="chrome";
		//String url="https://tutorialsninja.com/demo/";
		if(browserName.equalsIgnoreCase("Chrome")) {
		driver=	new ChromeDriver();
		}
		if(browserName.equalsIgnoreCase("fireFox")) {
			driver=	new FirefoxDriver();
			}
		if(browserName.equalsIgnoreCase("safari")) {
			driver=	new SafariDriver();
			}
		if(browserName.equalsIgnoreCase("edge")) {
			driver=	new EdgeDriver();
			}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(1000));
		driver.get((props.getProperty("url")));
		return driver;
		
	}
	
	@BeforeTest
	public void getnameMethod(ITestContext context) {

		extentTest = extentreports.createTest(context.getName());
	}

	@BeforeSuite
	public void InitExentReport() {

		ExtentSparkReporter sparkreporter = new ExtentSparkReporter("testreport_extent.html");
		extentreports = new ExtentReports();
		extentreports.attachReporter(sparkreporter);
		
		extentreports.setSystemInfo("Operating Sytsem : ", System.getProperty("os.name"));
		extentreports.setSystemInfo("JAVA Version : ", System.getProperty("java.version"));

	}

	// To Generate the extent report
	@AfterSuite
	public void generateReports() throws IOException {

		extentreports.flush();
		Desktop.getDesktop().browse(new File("testreport_extent.html").toURI());
	}

	@AfterMethod
	public void generateStatus(Method m, ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {

			System.out.println("Caputre the screenshot on failure");
			extentTest.fail(result.getThrowable());

		} else if (result.getStatus() == ITestResult.SUCCESS) {

			extentTest.pass(m.getName() + "  is passed");
		}

	}
}
