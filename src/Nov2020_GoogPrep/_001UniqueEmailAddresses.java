package Nov2020_GoogPrep;

import java.util.HashSet;

public class _001UniqueEmailAddresses {

	public static void main(String[] args) {
		System.out.println(numUniqueEmails(new String[] { "test.email+alex@leetcode.com",
				"test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com" }));
	}

	public static int numUniqueEmails(String[] emails) {
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < emails.length; i++) {
			String email = emails[i];
			String emailParts[] = email.split("@");
			String emailId = emailParts[0];
			String domain = emailParts[1];

			if (emailId.indexOf("+") > -1) {
				emailId = emailId.substring(0, emailId.indexOf("+"));
			}
			emailId = emailId.replace(".", "");
			String transformedEmail = emailId + "@" + domain;
			set.add(transformedEmail);
		}
		return set.size();
	}
}
