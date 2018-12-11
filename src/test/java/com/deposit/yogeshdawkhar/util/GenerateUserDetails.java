package com.deposit.yogeshdawkhar.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.deposit.yogeshdawkhar.page.User;

public class GenerateUserDetails {

	String Randomnumber = new SimpleDateFormat("ddMMMyyHHmmssSSS").format(new Date());

	public User generateUserDetails(String type) {
		String email = getEmailByType(type);
		String name = getNameByType(type);
		String password = getPasswordByType(type);
		String confirmationPassword = getConfirmPasswordByType(type);

		return new User(name, email, password, confirmationPassword);
	}

	private String getConfirmPasswordByType(String type) {
		if ((type.equalsIgnoreCase("addUserWithDiffrentConfirmPasswordWithoutOtherValues"))
				|| (type.equalsIgnoreCase("addUserWithDiffrentConfirmPasswordWithOtherValues"))) {
			return Randomnumber + 1;
		} else if (type.equalsIgnoreCase("addUserSameMinSizePassword")) {
			return "1234";
		} else if (type.equalsIgnoreCase("diffMinSizePassword")) {
			return "abcd";
		} else if ((type.equalsIgnoreCase("addUserWithOutConfirmPassword"))
				|| (type.equalsIgnoreCase("addUserWithOutAnyValue"))) {
			return "";
		} else if ((type.equalsIgnoreCase("addUserWithValidData"))
				|| (type.equalsIgnoreCase("addSameUserWithValidData"))) {
			return Randomnumber;
		} else {
			return Randomnumber;
		}
	}

	private String getPasswordByType(String type) {
		if ((type.equalsIgnoreCase("addUserWithDiffrentConfirmPasswordWithOtherValues"))
				|| (type.equalsIgnoreCase("addSameUserWithValidData"))
				|| (type.equalsIgnoreCase("addUserWithValidData"))
				|| (type.equalsIgnoreCase("addUserWithDiffrentConfirmPasswordWithoutOtherValues"))) {
			return Randomnumber;
		} else if (type.equalsIgnoreCase("addUserWithMinPassword")) {
			return "1234";
		} else if (type.equalsIgnoreCase("diffMinSizePassword")) {
			return "1234";
		} else if (type.equalsIgnoreCase("addUserWithOutPassword") || type.equalsIgnoreCase("addUserWithOutAnyValue")) {
			return "";
		} else {
			return Randomnumber;
		}
	}

	private String getEmailByType(String type) {
		if (type.equalsIgnoreCase("addUserWithInvalidEmailID")) {
			return Randomnumber;
		} else if ((type.equalsIgnoreCase("addUserWithoutEmail")) || (type.equalsIgnoreCase("addUserWithOutAnyValue"))||
				(type.equalsIgnoreCase("addUserWithDiffrentConfirmPasswordWithoutOtherValues"))) {
			return "";
		} else if (type.equalsIgnoreCase("addUserWithInvalidEmailID")) {
			return Randomnumber;
		} else if ((type.equalsIgnoreCase("addUserWithValidData"))
				|| (type.equalsIgnoreCase("addSameUserWithValidData"))) {
			return "test" + Randomnumber + "@" + Randomnumber + ".com";
		}
		return "test" + Randomnumber + "@" + Randomnumber + ".com";

	}

	private String getNameByType(String type) {
		if ((type.equalsIgnoreCase("addUserWithOutName")) || (type.equalsIgnoreCase("addUserWithOutAnyValue"))||
				(type.equalsIgnoreCase("addUserWithDiffrentConfirmPasswordWithoutOtherValues"))) {
			return "";
		} else if ((type.equalsIgnoreCase("addUserWithValidData"))
				|| (type.equalsIgnoreCase("addSameUserWithValidData"))) {
			return Randomnumber;
		}
		return Randomnumber;
	}

	public User generateUserDetails() {
		DateFormat dateFormat = new SimpleDateFormat("ddMMMyyHHmmssSSS");
		String Randomnumber = dateFormat.format(new Date());
		String name = Randomnumber;
		String email = "test" + Randomnumber + "@" + Randomnumber + ".com";
		String password = Randomnumber;
		String confirmationPassword = Randomnumber;
		return new User(name, email, password, confirmationPassword);
	}

	public List<String> getInvalidEmailId() {
		return Arrays.asList("plainaddress", "#@%^%#$@#$@#.com", "@domain.com", "Yogesh D <email@domain.com>",
				"email.domain.com", "email@domain@domain.com", ".email@domain.com", "email.@domain.com",
				"email..email@domain.com", "あいうえお@domain.com", "email@domain.com (Yogesh D)", "email@domain",
				"email@-domain.com", "email@domain..com", "Abc.example.com", "A@b@c@example.com",
				"a\"b(c)d,e:f;g<h>i[j\\k]l@example.com", "just\"not\"right@example.com",
				"this is\"not\\allowed@example.com", "this\\ still\\\"not\\\\allowed@example.com", "1", ".@.");
	}

	public List<String> getValidEmailId() {
		return Arrays.asList("email@domain.com", "firstname.lastname@domain.com", "email@subdomain.domain.com",
				"firstname+lastname@domain.com", "email@123.123.123.123", "1234567890@domain.com",
				"email@domain-one.com", "_______@domain.com", "email@domain.name", "email@domain.co.jp",
				"firstname-lastname@domain.com");
	}
}
