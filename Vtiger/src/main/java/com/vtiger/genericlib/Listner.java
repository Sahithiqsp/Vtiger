package com.vtiger.genericlib;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listner implements ITestListener{
	ExtentSparkReporter esr;
	ExtentTest test;
	ExtentReports er;

	@Override 
	public void onTestStart(ITestResult result) {
	
		String methName=result.getName();
		Reporter.log(methName+" TestCase Strated",true);
		test=er.createTest(methName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String methName=result.getName();
		Reporter.log(methName+" TestCase Executed",true);
		test.log(Status.PASS," TestCase Executed "+methName);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
	    WebDriverUtility wu= new WebDriverUtility();
	    JavaUtility ju= new JavaUtility();
		String methName=result.getName();
	 try {
		wu.screenShot(Driver.driver,"./SS/t1.png");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		Reporter.log(methName+" TestCase Failed",true);
		String dateTime=ju.genrateDateTime()+methName+".png";
		String path=Iconstant.screenShotpath+dateTime;
		String path1=Iconstant.screenShotpath+dateTime;
		
		String dirPath=System.getProperty("user.dir")/*+path1*/;
		test.log(Status.FAIL," TestCase Executed "+methName);
		
        System.out.println("+++++++++++++++++++++++"+dirPath);
//		
//		try {
//			wd.screenShot(Driver.getDriver(),path);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methName=result.getName();
		Reporter.log(methName+" TestCase Skipped",true);
		test.log(Status.SKIP," TestCase Executed "+methName);
	}

	@Override
	public void onStart(ITestContext context) {
		JavaUtility ju= new JavaUtility();
		esr=new ExtentSparkReporter(Iconstant.reportpath+ju.genrateDateTime()+".html");
		esr.config().setDocumentTitle("Vtiger Regression Report");
		esr.config().setReportName("Sammy");
		esr.config().setProtocol(Protocol.HTTPS);
		esr.config().setTheme(Theme.DARK);
		
		
		er=new ExtentReports();
		
		er.attachReporter(esr);
		
		er.setSystemInfo("OS", "Windows");
		er.setSystemInfo("Bits", "64");
		er.setSystemInfo("Version", "i7");
		String methName=context.getName();
		Reporter.log(methName+" Project Started",true);
	}

	@Override
	public void onFinish(ITestContext context) {
		String methName=context.getName();
		Reporter.log(methName+" Project Finish",true);
		er.flush();
		
	}

}
