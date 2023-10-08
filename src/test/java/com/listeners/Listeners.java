package com.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import CRMpracticeBasePack.CRMBaseClass;
import crmExtentReports.ExtentReportGeneration;

public class Listeners extends CRMBaseClass implements ITestListener {

	ExtentReports report = ExtentReportGeneration.getExtentReport();
	ExtentTest extentTest;

	public Listeners() throws IOException {
		super();

	}

	public void onTestStart(ITestResult result) {

		String testCaseName = result.getName();
		extentTest = report.createTest(testCaseName);

		extentTest.log(Status.INFO, testCaseName + "Test case execution started");

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test suite run successfully");

		System.out.println(result.getMethod());

		String testCaseName = result.getName();
		try {
			takeScreenShot(testCaseName);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	
	
	
	public void onTestFailure(ITestResult result) {

		System.out.println(result.getMethod());

		String testCaseName = result.getName();
		
		extentTest.log(Status.FAIL,testCaseName+"Test got failed");
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			extentTest.addScreenCaptureFromPath(takeScreenShot(testCaseName), testCaseName);
		} catch (IOException e) {

			e.printStackTrace();
		}
        
		extentTest.log(Status.INFO, result.getThrowable());
	}
	
	
	
	
	
	
	

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}
	
	public void onFinish(ITestContext context) {
		
		report.flush();
		File file=new File(System.getProperty("user.dir")+"\\ExtentReport\\Spark.html");
		try {
			Desktop.getDesktop().browse(file.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}




/*
  try {
			takeScreenShot(testCaseName);
		} catch (IOException e) {

			e.printStackTrace();
			System.out.println("Test case get Failed");
		}*/
