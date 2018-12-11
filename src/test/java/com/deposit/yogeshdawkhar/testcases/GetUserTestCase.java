package com.deposit.yogeshdawkhar.testcases;

import static io.restassured.RestAssured.get;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.deposit.yogeshdawkhar.constants.ErrorMessageContants;
import com.deposit.yogeshdawkhar.helper.HelperClass;
import com.deposit.yogeshdawkhar.page.AddNewUserPage;
import com.deposit.yogeshdawkhar.util.AssertionUtil;
import com.deposit.yogeshdawkhar.util.ExtentReportLog;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetUserTestCase extends HelperClass {
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
	public void verifyAddedUserInAPIResponse() throws Exception {
		ExtentReportLog.testStart(this.getClass().getSimpleName() + " -> "
				+ Thread.currentThread().getStackTrace()[1].getMethodName() + " On " + ExecuteTestonThisbrowser);
		driver.get(AddUserUrl);
		ExtentReportLog.testCaseInfoWithImage("Entered URL: " + AddUserUrl);
		new AddNewUserPage(driver).verifyAddedUserInAPIResponse();
	}

	@Test
	public void validateContentTypeandStatusCodeofgetAllUserAPI() throws Exception {
		ExtentReportLog.testStart(
				this.getClass().getSimpleName() + " -> " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Response response = (Response) get(GetAllUserUrlJson);
		ExtentReportLog.testCaseInfo("Get all userjson API called. URL: " + GetAllUserUrlJson);
		ExtentReportLog.testCaseInfo("Response of get all userjson API: " + response.asString());
		AssertionUtil.assertEqualsWithOutImage(response.getContentType(), "application/json; charset=utf-8",
				ErrorMessageContants.GET_ALL_USER_API_CONTENT_TYPE_JSON_PRESENT,
				ErrorMessageContants.GET_ALL_USER_CONTENT_TYPE_JSON_NOT_PRESENT);
		AssertionUtil.assertEqualsWithOutImage(response.getStatusCode(), 200,
				ErrorMessageContants.GET_ALL_USER_API_STATUS_CODE_200_PRESENT,
				ErrorMessageContants.GET_ALL_USER_API_STATUS_CODE_200_NOT_PRESENT);

		response.then().contentType(ContentType.JSON).statusCode(200);
	}

	@Test
	public void getHealthGetAllUserAPI() throws Exception {
		ExtentReportLog.testStart(
				this.getClass().getSimpleName() + " -> " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Response response = (Response) get(GetAllUserUrlJson);
		ExtentReportLog.testCaseInfo("Get all userjson API called. URL: " + GetAllUserUrlJson);
		AssertionUtil.assertEqualsWithOutImage(response.getStatusCode(), 200,
				ErrorMessageContants.GET_ALL_USER_API_STATUS_CODE_200_PRESENT,
				ErrorMessageContants.GET_ALL_USER_API_STATUS_CODE_200_NOT_PRESENT);

		response.then().statusCode(200);
	}

	@After
	public void closeBrowser() {
		extent.endTest(extentTest);
		extent.flush();
	}
}
