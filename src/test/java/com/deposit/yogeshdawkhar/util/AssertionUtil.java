package com.deposit.yogeshdawkhar.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

public class AssertionUtil {
	public static void assertNotEquals(String feildText, String validationMessage, String errorMessage)
			throws Exception {
		if (feildText.equals(validationMessage)) {
			ExtentReportLog.testCaseFailWithImage(errorMessage);
		}
		Assert.assertNotEquals(feildText, validationMessage);
	}

	public static void assertNotEquals(Long id, String errorMessage) throws Exception {
		if (id==null) {
			ExtentReportLog.testCaseFailWithImage(errorMessage);
		}
		Assert.assertNotEquals(id, null);
	}

	public static void assertEquals(String feildText, String validationMessage, String infoMessage, String failMessage)
			throws Exception {
		if (feildText.equals(validationMessage)) {
			ExtentReportLog.testCaseInfoWithImage(infoMessage);
		} else {
			ExtentReportLog.testCaseFailWithImage(failMessage);
		}
		Assert.assertEquals(feildText, validationMessage);
	}
	public static void assertEqualsWithoutImage(String feildText, String validationMessage, String infoMessage, String failMessage)
			throws Exception {
		if (feildText.equals(validationMessage)) {
			ExtentReportLog.testCaseInfo(infoMessage);
		} else {
			ExtentReportLog.testCaseFail(failMessage);
		}
		Assert.assertEquals(feildText, validationMessage);
	}

	public static void assertEquals(List<String> failedemail, ArrayList<String> arrayList, String infoMessage,
			String failMessage) throws Exception {
		if (failedemail.equals(arrayList)) {
			ExtentReportLog.testCasePassWithImage(infoMessage);
		} else {
			ExtentReportLog.testCaseFailWithImage(failMessage);
		}
		Assert.assertEquals(arrayList,failedemail);
	}
	
	public static void assertEqualsWithOutImage(List<String> failedemail, ArrayList<String> arrayList, String infoMessage,
			String failMessage) throws Exception {
		if (failedemail.equals(arrayList)) {
			ExtentReportLog.testCasePass(infoMessage);
		} else {
			ExtentReportLog.testCaseFail(failMessage);
		}
		Assert.assertEquals(arrayList,failedemail);
	}
	
	public static void assertEqualsWithOutImage(String actual,String  expected, String infoMessage,
			String failMessage) throws Exception {
		if (actual.equals(expected)) {
			ExtentReportLog.testCasePass(infoMessage);
		} else {
			ExtentReportLog.testCaseFail(failMessage);
		}
		Assert.assertEquals(actual,expected);
	}
	
	public static void assertFail(String failMessage)
			throws Exception {
			ExtentReportLog.testCaseFailWithImage(failMessage);
		Assert.fail(failMessage);
	}

	public static void assertEqualsWithOutImage(int statusCode, int validationCode, String infoMessage, String failMessage)
			throws Exception {
		if (statusCode==validationCode) {
			ExtentReportLog.testCasePass(infoMessage);
		} else {
			ExtentReportLog.testCaseFail(failMessage);
		}
		Assert.assertEquals(statusCode, validationCode);
	}
}
