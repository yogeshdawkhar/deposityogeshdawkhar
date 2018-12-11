package com.deposit.yogeshdawkhar.page;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;

import com.deposit.yogeshdawkhar.helper.HelperClass;
import com.deposit.yogeshdawkhar.util.ExtentReportLog;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAllUserAPI extends HelperClass {

	static void verifyUserRecordInGetAllUsersAPI(User user) throws Exception {
		String nameText = user.getName();
		String emailtext = user.getEmail();
		String passwordtext = user.getPassword();
		Response response = given().log().all().get(GetAllUserUrlJson);
		ExtentReportLog.testCaseInfo("Response of Getalluserjson api: " + response.asString());
		response.then().body("name", hasItem(nameText)).body("email", hasItem(emailtext))
				.body("password", hasItem(passwordtext)).contentType(ContentType.JSON).statusCode(200);
	}
}
