package com.deposit.yogeshdawkhar.helper;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
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
	protected static String randomNumber = new SimpleDateFormat("dd_MMM_yy_HHmmssSSS").format(new Date());
	protected static String fileSeprator = File.separator;
	protected static String extentReportImagePath = System.getProperty("user.dir") + fileSeprator + "src" + fileSeprator
			+ "ExtentReports" + fileSeprator + randomNumber + "";
	protected static Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
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
