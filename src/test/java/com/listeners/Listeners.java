package com.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import CRMpracticeBasePack.CRMBaseClass;

public class Listeners extends CRMBaseClass implements ITestListener {

	public Listeners() throws IOException {
		super();

	}

	public void onTestStart(ITestResult result) {
		
		System.out.println("Test suite start running");

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
		try {
			takeScreenShot(testCaseName);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

}
