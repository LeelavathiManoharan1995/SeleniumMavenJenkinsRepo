package com.quali.org.qa.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listeners implements ITestListener{
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test Project execution started");
	}


	
	@Override
	public void onTestStart(ITestResult result) {
		String testname=result.getName();
		System.out.println(testname+"started executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testname=result.getName();
		System.out.println(testname+"got Success");
		System.out.println(result.getThrowable());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testname=result.getName();
		System.out.println(testname+"Got Failed");
		System.out.println(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testname=result.getName();
		System.out.println(testname+"Testcases are skipped");
	}

	

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		String Testcasename=result.getName();
		System.out.println(Testcasename+ "failed due to time out");
		System.out.println(result.getThrowable());
	}

	
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("All the Testcases execution finished successfully");
		
	}
	
	

}
