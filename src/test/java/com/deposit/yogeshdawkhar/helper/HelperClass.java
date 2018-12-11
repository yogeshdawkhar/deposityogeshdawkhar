package com.deposit.yogeshdawkhar.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class HelperClass {
	public static WebDriver driver;
	public static String ExecuteTestonThisbrowser = "chrome";
	protected static String BaseURL="http://85.93.17.135:9000";
	protected static String AddUserUrl = BaseURL+"/user/new";
	protected static String GetAllUserUrl = BaseURL+"/users/all";
	protected static String GetAllUserUrlJson = BaseURL+"/user/all/json";
	protected static String DeleteAllUserUrl = BaseURL+"/user/all";
	
	protected static DateFormat dateFormat = new SimpleDateFormat("dd_MMM_yy_HHmmssSSS");
	protected static String randomdatenumber = dateFormat.format(new Date());
	protected static String extentReportImagePath = System.getProperty("user.dir") + "\\src\\ExtentReports\\"
			+ randomdatenumber + "\\";
	protected static String extentReportFilename = extentReportImagePath + "extentReportFile" + ".html";
	protected static ExtentReports extent = new ExtentReports(extentReportFilename, false);
	protected static ExtentTest extentTest;

	@AfterClass
	public static void endReport() {
		extent.flush();
		if (driver != null) {
			driver.quit();
		}
	}
}