package com.deposit.yogeshdawkhar.testcases;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.deposit.yogeshdawkhar.helper.HelperClass;
import com.deposit.yogeshdawkhar.page.AddNewUserPage;
import com.deposit.yogeshdawkhar.util.ExtentReportLog;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddNewUserTestCase extends HelperClass {

	@BeforeClass
	public static void setUp() {
		if (ExecuteTestonThisbrowser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		if (ExecuteTestonThisbrowser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		if (ExecuteTestonThisbrowser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

	@Test
	public void addUserWithOutName() throws Exception {
		ExtentReportLog.testStart(this.getClass().getSimpleName() + " -> "
				+ Thread.currentThread().getStackTrace()[1].getMethodName() + " On " + ExecuteTestonThisbrowser);
		driver.get(AddUserUrl);
		ExtentReportLog.testCaseInfoWithImage("Entered URL: " + AddUserUrl);
		new AddNewUserPage(driver).addUserWithOutName(Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Test
	public void addUserWithOutEmail() throws Exception {
		ExtentReportLog.testStart(this.getClass().getSimpleName() + " -> "
				+ Thread.currentThread().getStackTrace()[1].getMethodName() + " On " + ExecuteTestonThisbrowser);
		driver.get(AddUserUrl);
		ExtentReportLog.testCaseInfoWithImage("Entered URL: " + AddUserUrl);
		new AddNewUserPage(driver).addUserWithOutEmail(Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Test
	public void addUserWithOutPassword() throws Exception {
		ExtentReportLog.testStart(this.getClass().getSimpleName() + " -> "
				+ Thread.currentThread().getStackTrace()[1].getMethodName() + " On " + ExecuteTestonThisbrowser);
		driver.get(AddUserUrl);
		ExtentReportLog.testCaseInfoWithImage("Entered URL: " + AddUserUrl);
		new AddNewUserPage(driver).addUserWithOutPassword(Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Test
	public void addUserWithOutConfirmPassword() throws Exception {
		ExtentReportLog.testStart(this.getClass().getSimpleName() + " -> "
				+ Thread.currentThread().getStackTrace()[1].getMethodName() + " On " + ExecuteTestonThisbrowser);
		driver.get(AddUserUrl);
		ExtentReportLog.testCaseInfoWithImage("Entered URL: " + AddUserUrl);
		new AddNewUserPage(driver)
				.addUserWithOutConfirmPassword(Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Test
	public void addUserWithOutAnyValue() throws Exception {
		ExtentReportLog.testStart(this.getClass().getSimpleName() + " -> "
				+ Thread.currentThread().getStackTrace()[1].getMethodName() + " On " + ExecuteTestonThisbrowser);
		driver.get(AddUserUrl);
		ExtentReportLog.testCaseInfoWithImage("Entered URL: " + AddUserUrl);
		new AddNewUserPage(driver).addUserWithOutAnyValue(Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Test
	public void addUserWithMinPassword() throws Exception {
		ExtentReportLog.testStart(this.getClass().getSimpleName() + " -> "
				+ Thread.currentThread().getStackTrace()[1].getMethodName() + " On " + ExecuteTestonThisbrowser);
		driver.get(AddUserUrl);
		ExtentReportLog.testCaseInfoWithImage("Entered URL: " + AddUserUrl);
		new AddNewUserPage(driver).addUserWithMinPassword(Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Test
	public void addUserWithDiffrentConfirmPasswordWithOtherValues() throws Exception {
		ExtentReportLog.testStart(this.getClass().getSimpleName() + " -> "
				+ Thread.currentThread().getStackTrace()[1].getMethodName() + " On " + ExecuteTestonThisbrowser);
		driver.get(AddUserUrl);
		ExtentReportLog.testCaseInfoWithImage("Entered URL: " + AddUserUrl);
		new AddNewUserPage(driver).addUserWithDiffrentConfirmPasswordWithOtherValues(
				Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Test
	public void addUserWithDiffrentConfirmPasswordWithoutOtherValues() throws Exception {
		ExtentReportLog.testStart(this.getClass().getSimpleName() + " -> "
				+ Thread.currentThread().getStackTrace()[1].getMethodName() + " On " + ExecuteTestonThisbrowser);
		driver.get(AddUserUrl);
		ExtentReportLog.testCaseInfoWithImage("Entered URL: " + AddUserUrl);
		new AddNewUserPage(driver).addUserWithDiffrentConfirmPasswordWithoutOtherValues(
				Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Test
	public void addUserWithInvalidEmailID() throws Exception {
		ExtentReportLog.testStart(this.getClass().getSimpleName() + " -> "
				+ Thread.currentThread().getStackTrace()[1].getMethodName() + " On " + ExecuteTestonThisbrowser);
		driver.get(AddUserUrl);
		ExtentReportLog.testCaseInfoWithImage("Entered URL: " + AddUserUrl);
		new AddNewUserPage(driver).addUserWithInvalidEmailID(Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Test
	public void addUserWithValidEmailID() throws Exception {
		ExtentReportLog.testStart(this.getClass().getSimpleName() + " -> "
				+ Thread.currentThread().getStackTrace()[1].getMethodName() + " On " + ExecuteTestonThisbrowser);
		driver.get(AddUserUrl);
		ExtentReportLog.testCaseInfoWithImage("Entered URL: " + AddUserUrl);
		new AddNewUserPage(driver).addUserWithValidEmailID(Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Test
	public void verifyNamePlaceHolder() throws Exception {
		ExtentReportLog.testStart(this.getClass().getSimpleName() + " -> "
				+ Thread.currentThread().getStackTrace()[1].getMethodName() + " On " + ExecuteTestonThisbrowser);
		driver.get(AddUserUrl);
		ExtentReportLog.testCaseInfoWithImage("Entered URL: " + AddUserUrl);
		new AddNewUserPage(driver).verifyNamePlaceHolder();

	}

	@Test
	public void verifyEmailPlaceHolder() throws Exception {
		ExtentReportLog.testStart(this.getClass().getSimpleName() + " -> "
				+ Thread.currentThread().getStackTrace()[1].getMethodName() + " On " + ExecuteTestonThisbrowser);
		driver.get(AddUserUrl);
		ExtentReportLog.testCaseInfoWithImage("Entered URL: " + AddUserUrl);
		new AddNewUserPage(driver).verifyEmailPlaceHolder();
	}

	@Test
	public void verifyPasswordPlaceHolder() throws Exception {
		ExtentReportLog.testStart(this.getClass().getSimpleName() + " -> "
				+ Thread.currentThread().getStackTrace()[1].getMethodName() + " On " + ExecuteTestonThisbrowser);
		driver.get(AddUserUrl);
		ExtentReportLog.testCaseInfoWithImage("Entered URL: " + AddUserUrl);
		new AddNewUserPage(driver).verifyPasswordPlaceHolder();
	}

	@Test
	public void verifyConfirmPasswordPlaceHolder() throws Exception {
		ExtentReportLog.testStart(this.getClass().getSimpleName() + " -> "
				+ Thread.currentThread().getStackTrace()[1].getMethodName() + " On " + ExecuteTestonThisbrowser);
		driver.get(AddUserUrl);
		ExtentReportLog.testCaseInfoWithImage("Entered URL: " + AddUserUrl);
		new AddNewUserPage(driver).verifyConfirmPasswordPlaceHolder();
	}

	@Test
	public void addUserWithValidData() throws Exception {
		ExtentReportLog.testStart(this.getClass().getSimpleName() + " -> "
				+ Thread.currentThread().getStackTrace()[1].getMethodName() + " On " + ExecuteTestonThisbrowser);
		driver.get(AddUserUrl);
		ExtentReportLog.testCaseInfoWithImage("Entered URL: " + AddUserUrl);
		new AddNewUserPage(driver).addUserWithValidData(Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Test
	public void addSameUserWithValidData() throws Exception {
		ExtentReportLog.testStart(this.getClass().getSimpleName() + " -> "
				+ Thread.currentThread().getStackTrace()[1].getMethodName() + " On " + ExecuteTestonThisbrowser);
		driver.get(AddUserUrl);
		ExtentReportLog.testCaseInfoWithImage("Entered URL: " + AddUserUrl);
		new AddNewUserPage(driver).addSameUserWithValidData(Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Test
	public void verifyAddedUserOnUI() throws Exception {
		ExtentReportLog.testStart(this.getClass().getSimpleName() + " -> "
				+ Thread.currentThread().getStackTrace()[1].getMethodName() + " On " + ExecuteTestonThisbrowser);
		driver.get(AddUserUrl);
		ExtentReportLog.testCaseInfoWithImage("Entered URL: " + AddUserUrl);
		new AddNewUserPage(driver).verifyAddedUserOnUI();
	}

	@Test
	public void verifyPageTitleGetAllUser() throws Exception {
		ExtentReportLog.testStart(this.getClass().getSimpleName() + " -> "
				+ Thread.currentThread().getStackTrace()[1].getMethodName() + " On " + ExecuteTestonThisbrowser);
		driver.get(GetAllUserUrl);
		new AddNewUserPage(driver).verifyPageTitleGetAllUser();
	}

	@Test
	public void VerifyPageTitleofAddNewUserPage() throws Exception {
		ExtentReportLog.testStart(this.getClass().getSimpleName() + " -> "
				+ Thread.currentThread().getStackTrace()[1].getMethodName() + " On " + ExecuteTestonThisbrowser);
		driver.get(AddUserUrl);
		new AddNewUserPage(driver).verifyPageTitleAddNewUser();
	}

	@After
	public void closeBrowser() {
		extent.endTest(extentTest);
		extent.flush();
	}
}
