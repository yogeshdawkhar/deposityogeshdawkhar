package com.deposit.yogeshdawkhar.page;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.deposit.yogeshdawkhar.constants.ErrorMessageContants;
import com.deposit.yogeshdawkhar.constants.ValidationMessageContants;
import com.deposit.yogeshdawkhar.helper.HelperClass;
import com.deposit.yogeshdawkhar.util.AssertionUtil;
import com.deposit.yogeshdawkhar.util.ExtentReportLog;
import com.deposit.yogeshdawkhar.util.GenerateUserDetails;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AddNewUserPage extends HelperClass {
	@FindBy(how = How.ID, using = "name")
	WebElement nameWebElement;
	@FindBy(how = How.ID, using = "email")
	WebElement emailWebElement;
	@FindBy(how = How.ID, using = "password")
	WebElement passwordWebElement;
	@FindBy(how = How.ID, using = "confirmationPassword")
	WebElement confirmationPasswordWebElement;
	@FindBy(how = How.XPATH, using = "/html/body/div/div/div/form/fieldset/div[5]/button")
	WebElement SubmitWebElement;
	@FindBy(how = How.ID, using = "user.name.error")
	WebElement usernameerrorWebElement;
	@FindBy(how = How.ID, using = "user.email.error")
	WebElement useremailerrorWebElement;
	@FindBy(how = How.ID, using = "user.password.error")
	WebElement userpassworderrorWebElement;
	@FindBy(how = How.ID, using = "user.confirmationPassword.error")
	WebElement userconfirmationPasswordErrorWebElement;
	@FindBy(how = How.LINK_TEXT, using = "New User")
	WebElement newuserbuttonWebElement;
	@FindBy(how = How.CSS, using = "#name")
	WebElement placeHolderNameWebElement;
	@FindBy(how = How.CSS, using = "#email")
	WebElement placeHolderEmailWebElement;
	@FindBy(how = How.CSS, using = "#password")
	WebElement placeHolderPasswordWebElement;
	@FindBy(how = How.CSS, using = "#confirmationPassword")
	WebElement placeHolderConfirmationPasswordWebElement;

	public AddNewUserPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterDetailsOnFormAndClickSubmit(String nametext, String emailtext, String passwordtext,
			String confirmpasswordtext) throws Exception {
		nameWebElement.clear();
		nameWebElement.sendKeys(nametext);
		emailWebElement.clear();
		emailWebElement.sendKeys(emailtext);
		ExtentReportLog.testCaseInfo("Entered Value in Email field" + emailtext);
		passwordWebElement.clear();
		passwordWebElement.sendKeys(passwordtext);
		ExtentReportLog.testCaseInfo("Entered Value in Password field" + passwordtext);
		confirmationPasswordWebElement.clear();
		confirmationPasswordWebElement.sendKeys(confirmpasswordtext);
		ExtentReportLog.testCaseInfo("Entered Value in Confirmation Password field" + confirmpasswordtext);
		SubmitWebElement.click();
		ExtentReportLog.testCaseInfoWithImage("Submit Button clicked");
	}

	public void addUserWithOutName(String usecase) throws Exception {
		User user = new GenerateUserDetails().generateUserDetails(usecase);
		String nametext = user.getName();
		String emailtext = user.getEmail();
		String passwordtext = user.getPassword();
		String confirmpasswordtext = user.getConfirmationPassword();
		enterDetailsOnFormAndClickSubmit(nametext, emailtext, passwordtext, confirmpasswordtext);
		if (driver.getCurrentUrl().equalsIgnoreCase(AddUserUrl)) {
			AssertionUtil.assertEquals(usernameerrorWebElement.getText(), ValidationMessageContants.REQUIRED,
					ErrorMessageContants.REQUIRED_PRESENT,
					usernameerrorWebElement.getText() + ErrorMessageContants.ERROR_PRESENT);
			AssertionUtil.assertNotEquals(useremailerrorWebElement.getText(), ValidationMessageContants.REQUIRED,
					useremailerrorWebElement.getText() + ErrorMessageContants.ERROR_PRESENT);
			AssertionUtil.assertNotEquals(userpassworderrorWebElement.getText(), ValidationMessageContants.REQUIRED,
					userpassworderrorWebElement.getText() + ErrorMessageContants.ERROR_PRESENT);
			AssertionUtil.assertNotEquals(userconfirmationPasswordErrorWebElement.getText(),
					ValidationMessageContants.REQUIRED,
					userconfirmationPasswordErrorWebElement.getText() + ErrorMessageContants.ERROR_PRESENT);
		} else {
			AssertionUtil.assertFail(usecase + "User is redirected to other URL. " + driver.getCurrentUrl());
		}
	}

	public void addUserWithOutEmail(String usecase) throws Exception {
		User user = new GenerateUserDetails().generateUserDetails(usecase);
		String nametext = user.getName();
		String emailtext = user.getEmail();
		String passwordtext = user.getPassword();
		String confirmpasswordtext = user.getConfirmationPassword();
		enterDetailsOnFormAndClickSubmit(nametext, emailtext, passwordtext, confirmpasswordtext);
		if (driver.getCurrentUrl().equalsIgnoreCase(AddUserUrl)) {
			AssertionUtil.assertNotEquals(usernameerrorWebElement.getText(), ValidationMessageContants.REQUIRED,
					usernameerrorWebElement.getText() + ErrorMessageContants.ERROR_PRESENT);
			AssertionUtil.assertEquals(useremailerrorWebElement.getText(), ValidationMessageContants.REQUIRED,
					ErrorMessageContants.ERROR_PRESENT,
					ValidationMessageContants.REQUIRED + ErrorMessageContants.ERROR_NOT_PRESENT);
			AssertionUtil.assertNotEquals(userpassworderrorWebElement.getText(), ValidationMessageContants.REQUIRED,
					userpassworderrorWebElement.getText() + ErrorMessageContants.ERROR_PRESENT);
			AssertionUtil.assertNotEquals(userconfirmationPasswordErrorWebElement.getText(),
					ValidationMessageContants.REQUIRED,
					userconfirmationPasswordErrorWebElement.getText() + ErrorMessageContants.ERROR_PRESENT);

		} else {
			AssertionUtil.assertFail(usecase + "User is redirected to other URL. " + driver.getCurrentUrl());
		}
	}

	public void addUserWithOutPassword(String usecase) throws Exception {
		User user = new GenerateUserDetails().generateUserDetails(usecase);
		String nametext = user.getName();
		String emailtext = user.getEmail();
		String passwordtext = user.getPassword();
		String confirmpasswordtext = user.getConfirmationPassword();
		enterDetailsOnFormAndClickSubmit(nametext, emailtext, passwordtext, confirmpasswordtext);
		if (driver.getCurrentUrl().equalsIgnoreCase(AddUserUrl)) {
			AssertionUtil.assertNotEquals(usernameerrorWebElement.getText(), ValidationMessageContants.REQUIRED,
					usernameerrorWebElement.getText() + ErrorMessageContants.ERROR_PRESENT);
			AssertionUtil.assertNotEquals(useremailerrorWebElement.getText(), ValidationMessageContants.REQUIRED,
					useremailerrorWebElement.getText() + ErrorMessageContants.ERROR_PRESENT);
			AssertionUtil.assertEquals(userpassworderrorWebElement.getText(), ValidationMessageContants.REQUIRED,
					ErrorMessageContants.REQUIRED_PRESENT, ErrorMessageContants.REQUIRED_NOT_PRESENT);
			AssertionUtil.assertNotEquals(userconfirmationPasswordErrorWebElement.getText(),
					ValidationMessageContants.REQUIRED,
					userconfirmationPasswordErrorWebElement.getText() + ErrorMessageContants.ERROR_PRESENT);
		} else {
			AssertionUtil.assertFail(usecase + "User is redirected to other URL. " + driver.getCurrentUrl());
		}
	}

	public void addUserWithOutConfirmPassword(String usecase) throws Exception {
		User user = new GenerateUserDetails().generateUserDetails(usecase);
		String nametext = user.getName();
		String emailtext = user.getEmail();
		String passwordtext = user.getPassword();
		String confirmpasswordtext = user.getConfirmationPassword();
		enterDetailsOnFormAndClickSubmit(nametext, emailtext, passwordtext, confirmpasswordtext);
		if (driver.getCurrentUrl().equalsIgnoreCase(AddUserUrl)) {
			AssertionUtil.assertNotEquals(usernameerrorWebElement.getText(), ValidationMessageContants.REQUIRED,
					usernameerrorWebElement.getText() + ErrorMessageContants.REQUIRED_PRESENT);
			AssertionUtil.assertNotEquals(useremailerrorWebElement.getText(), ValidationMessageContants.REQUIRED,
					useremailerrorWebElement.getText() + ErrorMessageContants.REQUIRED_PRESENT);
			AssertionUtil.assertNotEquals(userpassworderrorWebElement.getText(), ValidationMessageContants.REQUIRED,
					userpassworderrorWebElement.getText() + ErrorMessageContants.REQUIRED_PRESENT);
			AssertionUtil.assertEquals(userconfirmationPasswordErrorWebElement.getText(),
					ValidationMessageContants.PASSWORD_NOT_SAME, ErrorMessageContants.PASSWORD_NOT_SAME_PRESENT,
					ErrorMessageContants.PASSWORD_NOT_SAME_NOT_PRESENT);
		} else {
			AssertionUtil.assertFail(usecase + "User is redirected to other URL. " + driver.getCurrentUrl());
		}
	}

	public void addUserWithOutAnyValue(String usecase) throws Exception {
		User user = new GenerateUserDetails().generateUserDetails(usecase);
		String nametext = user.getName();
		String emailtext = user.getEmail();
		String passwordtext = user.getPassword();
		String confirmpasswordtext = user.getConfirmationPassword();
		enterDetailsOnFormAndClickSubmit(nametext, emailtext, passwordtext, confirmpasswordtext);
		if (driver.getCurrentUrl().equalsIgnoreCase(AddUserUrl)) {
			AssertionUtil.assertEquals(usernameerrorWebElement.getText(), ValidationMessageContants.REQUIRED,
					ErrorMessageContants.REQUIRED_PRESENT, ErrorMessageContants.REQUIRED_NOT_PRESENT);
			AssertionUtil.assertEquals(useremailerrorWebElement.getText(), ValidationMessageContants.REQUIRED,
					ErrorMessageContants.REQUIRED_PRESENT, ErrorMessageContants.REQUIRED_NOT_PRESENT);
			AssertionUtil.assertEquals(userpassworderrorWebElement.getText(), ValidationMessageContants.REQUIRED,
					ErrorMessageContants.REQUIRED_PRESENT, ErrorMessageContants.REQUIRED_NOT_PRESENT);
			AssertionUtil.assertNotEquals(userconfirmationPasswordErrorWebElement.getText(),
					ValidationMessageContants.REQUIRED,
					userconfirmationPasswordErrorWebElement.getText() + ErrorMessageContants.ERROR_PRESENT);
		} else {
			AssertionUtil.assertFail(usecase + "User is redirected to other URL. " + driver.getCurrentUrl());
		}
	}

	public void addUserWithMinPassword(String usecase) throws Exception {
		User user = new GenerateUserDetails().generateUserDetails(usecase);
		String nametext = user.getName();
		String emailtext = user.getEmail();
		String passwordtext = user.getPassword();
		String confirmpasswordtext = user.getConfirmationPassword();
		enterDetailsOnFormAndClickSubmit(nametext, emailtext, passwordtext, confirmpasswordtext);
		if (driver.getCurrentUrl().equalsIgnoreCase(AddUserUrl)) {
			AssertionUtil.assertNotEquals(usernameerrorWebElement.getText(), ValidationMessageContants.REQUIRED,
					usernameerrorWebElement.getText() + ErrorMessageContants.ERROR_PRESENT);
			AssertionUtil.assertNotEquals(useremailerrorWebElement.getText(), ValidationMessageContants.REQUIRED,
					useremailerrorWebElement.getText() + ErrorMessageContants.ERROR_PRESENT);
			AssertionUtil.assertEquals(userpassworderrorWebElement.getText(),
					ValidationMessageContants.MIN_PASSWORD_SIZE, ErrorMessageContants.MIN_PASSWORD_SIZE_PRESENT,
					ErrorMessageContants.MIN_PASSWORD_SIZE_NOT_PRESENT);
			AssertionUtil.assertNotEquals(userconfirmationPasswordErrorWebElement.getText(),
					ValidationMessageContants.REQUIRED,
					userconfirmationPasswordErrorWebElement.getText() + ErrorMessageContants.ERROR_PRESENT);
		} else {
			AssertionUtil.assertFail(usecase + "User is redirected to other URL. " + driver.getCurrentUrl());
		}
	}

	public void addUserWithDiffrentConfirmPasswordWithOtherValues(String usecase) throws Exception {
		User user = new GenerateUserDetails().generateUserDetails(usecase);
		String nametext = user.getName();
		String emailtext = user.getEmail();
		String passwordtext = user.getPassword();
		String confirmpasswordtext = user.getConfirmationPassword();
		enterDetailsOnFormAndClickSubmit(nametext, emailtext, passwordtext, confirmpasswordtext);
		if (driver.getCurrentUrl().equalsIgnoreCase(AddUserUrl)) {
			AssertionUtil.assertNotEquals(usernameerrorWebElement.getText(), ValidationMessageContants.REQUIRED,
					usernameerrorWebElement.getText() + ErrorMessageContants.ERROR_PRESENT);
			AssertionUtil.assertNotEquals(useremailerrorWebElement.getText(), ValidationMessageContants.REQUIRED,
					useremailerrorWebElement.getText() + ErrorMessageContants.ERROR_PRESENT);
			AssertionUtil.assertNotEquals(userpassworderrorWebElement.getText(), ValidationMessageContants.REQUIRED,
					userpassworderrorWebElement.getText() + ErrorMessageContants.ERROR_PRESENT);
			AssertionUtil.assertEquals(userconfirmationPasswordErrorWebElement.getText(),
					ValidationMessageContants.PASSWORD_NOT_SAME, ErrorMessageContants.PASSWORD_NOT_SAME_PRESENT,
					ErrorMessageContants.PASSWORD_NOT_SAME_NOT_PRESENT);
		} else {
			AssertionUtil.assertFail(usecase + "User is redirected to other URL. " + driver.getCurrentUrl());
		}
	}

	public void addUserWithDiffrentConfirmPasswordWithoutOtherValues(String usecase) throws Exception {
		User user = new GenerateUserDetails().generateUserDetails(usecase);
		String nametext = user.getName();
		String emailtext = user.getEmail();
		String passwordtext = user.getPassword();
		String confirmpasswordtext = user.getConfirmationPassword();
		enterDetailsOnFormAndClickSubmit(nametext, emailtext, passwordtext, confirmpasswordtext);
		if (driver.getCurrentUrl().equalsIgnoreCase(AddUserUrl)) {
			AssertionUtil.assertEquals(usernameerrorWebElement.getText(), ValidationMessageContants.REQUIRED,
					ErrorMessageContants.INVALID_USER_NAME_PRESENT, ErrorMessageContants.INVALID_USER_NAME_NOT_PRESENT);
			AssertionUtil.assertEquals(useremailerrorWebElement.getText(), ValidationMessageContants.REQUIRED,
					ErrorMessageContants.INVALID_EMAIL_ID_PRESENT, ErrorMessageContants.INVALID_EMAIL_ID_NOT_PRESENT);
			AssertionUtil.assertNotEquals(userpassworderrorWebElement.getText(), ValidationMessageContants.REQUIRED,
					ErrorMessageContants.REQUIRED_PRESENT);
			AssertionUtil.assertEquals(userconfirmationPasswordErrorWebElement.getText(),
					ValidationMessageContants.PASSWORD_NOT_SAME, ErrorMessageContants.PASSWORD_NOT_SAME_PRESENT,
					ErrorMessageContants.PASSWORD_NOT_SAME_NOT_PRESENT);
		} else {
			AssertionUtil.assertFail(usecase + "User is redirected to other URL. " + driver.getCurrentUrl());
		}
	}

	public void verifyPageTitleGetAllUser() throws Exception {
		driver.get(GetAllUserUrl);
		AssertionUtil.assertEqualsWithoutImage(driver.getTitle(), ValidationMessageContants.ALL_USER_PAGE_TITLE,
				driver.getTitle() + " Title present", driver.getTitle() + " Expected Title not present");
	}

	public void verifyPageTitleAddNewUser() throws Exception {
		driver.get(AddUserUrl);
		AssertionUtil.assertEqualsWithoutImage(driver.getTitle(), ValidationMessageContants.ADD_NEW_USER_PAGE_TITLE,
				driver.getTitle() + " Title present", driver.getTitle() + " Expected Title not present");
	}

	public void addUserWithInvalidEmailID(String usecase) throws Exception {
		List<String> emailinputs = new GenerateUserDetails().getInvalidEmailId();
		List<String> failedemail = new ArrayList<String>();
		for (int i = 0; i < emailinputs.size(); i++) {
			User user = new GenerateUserDetails().generateUserDetails(usecase);
			String emailtext = (String) emailinputs.get(i);
			String nameText = user.getName();
			String passwordtext = user.getPassword();
			String confirmpasswordtext = user.getConfirmationPassword();
			enterDetailsOnFormAndClickSubmit(nameText, emailtext, passwordtext, confirmpasswordtext);

			if (driver.getCurrentUrl().equalsIgnoreCase(AddUserUrl)) {
				if (useremailerrorWebElement.getText().equalsIgnoreCase(ValidationMessageContants.INVALID_EMAIL_ID)) {
					ExtentReportLog.testCasePassWithImage("Test Pass for this data : " + emailtext
							+ ". This error Message Was present " + useremailerrorWebElement.getText());
				} else {
					failedemail.add(emailtext);
					ExtentReportLog.testCaseFailWithImage("Test Failed for this data : " + emailtext
							+ ". This error Message Was present : " + useremailerrorWebElement.getText());
				}
			} else {
				failedemail.add(emailtext);
				ExtentReportLog.testCaseFailWithImage("Test failed for following data : " + emailtext
						+ "\n User is redirected to  " + driver.getCurrentUrl().toString());
			}
			driver.navigate().to(AddUserUrl);
		}
		AssertionUtil.assertEqualsWithOutImage(failedemail, (new ArrayList<String>()), "Test Passed For all Data.",
				"Test failed for following data:" + failedemail);
	}

	public void addUserWithValidEmailID(String usecase) throws Exception {
		List<String> emailinputs = new GenerateUserDetails().getValidEmailId();
		List<String> failedemail = new ArrayList<String>();
		for (int i = 0; i < emailinputs.size(); i++) {
			User user = new GenerateUserDetails().generateUserDetails(usecase);
			String nameText = user.getName();
			String passwordtext = user.getPassword();
			String confirmpasswordtext = user.getConfirmationPassword();
			String emailtext = (String) emailinputs.get(i);

			enterDetailsOnFormAndClickSubmit(nameText, emailtext, passwordtext, confirmpasswordtext);

			if ((driver.getCurrentUrl().equalsIgnoreCase(AddUserUrl)) && ((useremailerrorWebElement.getText()
					.equalsIgnoreCase(ValidationMessageContants.INVALID_EMAIL_ID))
					|| (useremailerrorWebElement.getText().equalsIgnoreCase(ValidationMessageContants.REQUIRED))
					|| (useremailerrorWebElement.getText()
							.equalsIgnoreCase(ValidationMessageContants.MUST_BE_UNIQUE)))) {
				failedemail.add(emailtext);
				ExtentReportLog.testCaseFailWithImage("Test failed for this data->" + emailtext
						+ " This error Message Was present " + useremailerrorWebElement.getText());

			} else if (driver.getCurrentUrl().equalsIgnoreCase(GetAllUserUrl)) {
				verifyUserRecordOnUI(nameText, emailtext, passwordtext);
			} else {
				ExtentReportLog.testCaseFail("User redirected to URL : " + driver.getCurrentUrl().toString());
			}
			driver.navigate().to(AddUserUrl);
		}
		AssertionUtil.assertEqualsWithOutImage(failedemail, (new ArrayList<String>()), "Test Passed For all Data.",
				"Test Failed For Data:" + failedemail);
	}

	public void verifyNamePlaceHolder() throws Exception {
		AssertionUtil.assertEquals(placeHolderNameWebElement.getAttribute("placeholder"),
				ValidationMessageContants.PLACEHOLDER_NAME, ErrorMessageContants.PLACEHOLDER_NAME_MESSAGE_PRESENT,
				ErrorMessageContants.PLACEHOLDER_NAME_MESSAGE_NOT_PRESENT);
	}

	public void verifyEmailPlaceHolder() throws Exception {
		AssertionUtil.assertEquals(placeHolderEmailWebElement.getAttribute("placeholder"),
				ValidationMessageContants.PLACEHOLDER_EMAIL, ErrorMessageContants.PLACEHOLDER_EMAIL_MESSAGE_PRESENT,
				ErrorMessageContants.PLACEHOLDER_EMAIL_MESSAGE_NOT_PRESENT);
	}

	public void verifyPasswordPlaceHolder() throws Exception {
		AssertionUtil.assertEquals(placeHolderPasswordWebElement.getAttribute("placeholder"),
				ValidationMessageContants.PLACEHOLDER_PASSWORD,
				ErrorMessageContants.PLACEHOLDER_PASSWORD_MESSAGE_PRESENT,
				ErrorMessageContants.PLACEHOLDER_PASSWORD_MESSAGE_NOT_PRESENT);
	}

	public void verifyConfirmPasswordPlaceHolder() throws Exception {
		AssertionUtil.assertEquals(placeHolderConfirmationPasswordWebElement.getAttribute("placeholder"),
				ValidationMessageContants.PLACEHOLDER_CONFIRM_PASSWORD,
				ErrorMessageContants.PLACEHOLDER_CONFIRM_PASSWORD_MESSAGE_PRESENT,
				ErrorMessageContants.PLACEHOLDER_CONFIRM_PASSWORD_MESSAGE_NOT_PRESENT);
	}

	public void addUserWithValidData(String usecase) throws Exception {
		User user = new GenerateUserDetails().generateUserDetails(usecase);
		String nametext = user.getName();
		String emailtext = user.getEmail();
		String passwordtext = user.getPassword();
		String confirmpasswordtext = user.getConfirmationPassword();
		enterDetailsOnFormAndClickSubmit(nametext, emailtext, passwordtext, confirmpasswordtext);
		if (driver.getCurrentUrl().equalsIgnoreCase(AddUserUrl)) {
			AssertionUtil.assertNotEquals(usernameerrorWebElement.getText(), ValidationMessageContants.REQUIRED,
					ErrorMessageContants.REQUIRED_PRESENT);
			AssertionUtil.assertNotEquals(useremailerrorWebElement.getText(), ValidationMessageContants.REQUIRED,
					ErrorMessageContants.REQUIRED_PRESENT);
			AssertionUtil.assertNotEquals(userpassworderrorWebElement.getText(), ValidationMessageContants.REQUIRED,
					ErrorMessageContants.REQUIRED_PRESENT);
			AssertionUtil.assertNotEquals(userconfirmationPasswordErrorWebElement.getText(),
					ValidationMessageContants.REQUIRED, ErrorMessageContants.REQUIRED_PRESENT);

		}
		verifyUserRecordOnUI(nametext, emailtext, passwordtext);
	}

	public void addSameUserWithValidData(String usecase) throws Exception {
		User user = new GenerateUserDetails().generateUserDetails(usecase);
		String nametext = user.getName();
		String emailtext = user.getEmail();
		String passwordtext = user.getPassword();
		String confirmpasswordtext = user.getConfirmationPassword();
		enterDetailsOnFormAndClickSubmit(nametext, emailtext, passwordtext, confirmpasswordtext);
		AssertionUtil.assertEquals(driver.getCurrentUrl(), GetAllUserUrl, "User is on correct URL" + GetAllUserUrl,
				"User is on diffrent URL:" + driver.getCurrentUrl());
		verifyUserRecordOnUI(nametext, emailtext, passwordtext);
		if (driver.getCurrentUrl().equalsIgnoreCase(AddUserUrl)) {
			AssertionUtil.assertNotEquals(usernameerrorWebElement.getText(), ValidationMessageContants.REQUIRED,
					ErrorMessageContants.REQUIRED_PRESENT);
			AssertionUtil.assertNotEquals(useremailerrorWebElement.getText(), ValidationMessageContants.REQUIRED,
					ErrorMessageContants.REQUIRED_PRESENT);
			AssertionUtil.assertNotEquals(userpassworderrorWebElement.getText(), ValidationMessageContants.REQUIRED,
					ErrorMessageContants.REQUIRED_PRESENT);
			AssertionUtil.assertNotEquals(userconfirmationPasswordErrorWebElement.getText(),
					ValidationMessageContants.REQUIRED, ErrorMessageContants.REQUIRED_PRESENT);
		}
		newuserbuttonWebElement.click();
		enterDetailsOnFormAndClickSubmit(nametext, emailtext, passwordtext, confirmpasswordtext);
		AssertionUtil.assertEquals(driver.getCurrentUrl(), AddUserUrl, "User is on correct URL" + AddUserUrl,
				"User is on diffrent URL:" + driver.getCurrentUrl());
		AssertionUtil.assertEquals(usernameerrorWebElement.getText(), ValidationMessageContants.MUST_BE_UNIQUE,
				ErrorMessageContants.MUST_BE_UNIQUE_PRESENT, ErrorMessageContants.MUST_BE_UNIQUE_NOT_PRESENT);
		AssertionUtil.assertEquals(useremailerrorWebElement.getText(), ValidationMessageContants.MUST_BE_UNIQUE,
				ErrorMessageContants.MUST_BE_UNIQUE_PRESENT, ErrorMessageContants.MUST_BE_UNIQUE_NOT_PRESENT);
		AssertionUtil.assertNotEquals(userpassworderrorWebElement.getText(), ValidationMessageContants.REQUIRED,
				ErrorMessageContants.REQUIRED_PRESENT);
		AssertionUtil.assertNotEquals(userconfirmationPasswordErrorWebElement.getText(),
				ValidationMessageContants.REQUIRED, ErrorMessageContants.ERROR_PRESENT);

	}

	public void verifyAddedUserOnUI() throws Exception {
		User user = new GenerateUserDetails().generateUserDetails();
		enterDetailsOnFormAndClickSubmit(user.getName(), user.getEmail(), user.getPassword(),
				user.getConfirmationPassword());
		verifyUserRecordOnUI(user.getName(), user.getEmail(), user.getConfirmationPassword());
	}

	public void verifyAddedUserInAPIResponse() throws Exception {
		User user = new GenerateUserDetails().generateUserDetails();
		enterDetailsOnFormAndClickSubmit(user.getName(), user.getEmail(), user.getPassword(),
				user.getConfirmationPassword());
		verifyUserRecordInGetAllUsersAPI(user);
	}

	public User GetrecordID(String Findrecord) throws Exception {
		String name = "", email = "", password = "";
		Long id = null;
		Response response = (Response) get(GetAllUserUrlJson);
		JSONArray ja = new JSONArray(response.asString());
		for (int i = 0; i < ja.length(); i++) {
			JSONObject jo = ja.getJSONObject(i);
			if (jo.getString("name").equals(Findrecord)) {
				id = jo.getLong("id");
				name = jo.getString("name");
				email = jo.getString("email");
				password = jo.getString("password");
				break;
			}
		}
		return new User(id, name, email, password);
	}

	private void verifyUserRecordOnUI(String username, String useremail, String userpassword) throws Exception {
		User record = GetrecordID(username);
		Long id = record.getId();
		driver.navigate().to(GetAllUserUrl);
		if (!(id == null)) {
			List<WebElement> Row_count1 = driver.findElements(By.xpath("//tr[@id='" + id + "']/td"));
			AssertionUtil.assertEquals(Row_count1.get(0).getText(), username, "Element present",
					"Expected Element not present : " + username);
			AssertionUtil.assertEquals(Row_count1.get(1).getText(), useremail, "Element present",
					"Expected Element not present : " + useremail);
			AssertionUtil.assertEquals(Row_count1.get(2).getText(), userpassword, "Element present",
					"Expected Element not present : " + userpassword);
		}
		AssertionUtil.assertNotEquals(id, "Record not present:" + username);
	}

	private static void verifyUserRecordInGetAllUsersAPI(User user) throws Exception {
		String nameText = user.getName();
		String emailtext = user.getEmail();
		String passwordtext = user.getPassword();
		Response response = given().log().all().get(GetAllUserUrlJson);
		ExtentReportLog.testCaseInfo("Response of Getalluserjson api: " + response.asString());
		response.then().body("name", hasItem(nameText)).body("email", hasItem(emailtext))
				.body("password", hasItem(passwordtext)).contentType(ContentType.JSON).statusCode(200);
	}
}
