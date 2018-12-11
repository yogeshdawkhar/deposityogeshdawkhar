package com.deposit.yogeshdawkhar.testcases;

import static io.restassured.RestAssured.delete;

import org.junit.After;
import org.junit.Test;

import com.deposit.yogeshdawkhar.constants.ErrorMessageContants;
import com.deposit.yogeshdawkhar.helper.HelperClass;
import com.deposit.yogeshdawkhar.util.AssertionUtil;
import com.deposit.yogeshdawkhar.util.ExtentReportLog;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteUserTestCase extends HelperClass {

	@Test
	public void validateContentTypeandStatusCodeofdeleteAllUserAPI() throws Exception {
		ExtentReportLog.testStart(
				this.getClass().getSimpleName() + " -> " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Response response = (Response) delete(DeleteAllUserUrl);
		ExtentReportLog.testCaseInfo("Delete all user API called. URL: " + DeleteAllUserUrl);
		AssertionUtil.assertEqualsWithoutImage(response.asString(), "",
				ErrorMessageContants.DELETE_API_EMPTY_RESPONSE_PRESENT,
				ErrorMessageContants.DELETE_API_EMPTY_RESPONSE_NOT_PRESENT + response.asString());
		AssertionUtil.assertEqualsWithoutImage(response.getContentType(), "text/plain; charset=utf-8",
				ErrorMessageContants.DELETE_API_CONTENT_TYPE_TEXT_PLAIN_PRESENT,
				ErrorMessageContants.DELETE_API_CONTENT_TYPE_TEXT_PLAIN_NOT_PRESENT + response.getContentType());
		AssertionUtil.assertEqualsWithOutImage(response.getStatusCode(), 200,
				ErrorMessageContants.DELETE_API_STATUS_CODE_200_PRESENT,
				ErrorMessageContants.DELETE_API_STATUS_CODE_200_NOT_PRESENT + response.getStatusCode());

		response.then().contentType(ContentType.TEXT).statusCode(200);
	}

	@Test
	public void getHealthDeleteAllUserAPI() throws Exception {
		ExtentReportLog.testStart(
				this.getClass().getSimpleName() + " -> " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Response response = (Response) delete(DeleteAllUserUrl);
		ExtentReportLog.testCaseInfo("Delete all user API called. URL: " + DeleteAllUserUrl);
		ExtentReportLog.testCaseInfo("Status Code of delete all user API is : " + response.getStatusCode());
		response.then().statusCode(200);
	}

	@After
	public void endTest() {
		extent.endTest(extentTest);
		extent.flush();
	}
}
