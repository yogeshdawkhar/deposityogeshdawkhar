package com.deposit.yogeshdawkhar.util;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.deposit.yogeshdawkhar.helper.HelperClass;

public class ScreenshotUtil extends HelperClass {

	public static boolean takeScreenshot(final String name) {
		String screenshotDirectory = EXTENT_REPORT_IMAGE_PATH;
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		return screenshot.renameTo(new File(screenshotDirectory, String.format("%s.png", name)));
	}

	public static String createimagename() throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmssSSS");
		Date date = new Date();
		String imagename = dateFormat.format(date);
		takeScreenshot(imagename);
		return imagename;
	}

}
