package May2021GoogLeetcode;

import java.util.HashSet;

public class _0929UniqueEmailAddresses {

	public static void main(String[] args) {
		System.out.println(numUniqueEmails(new String[] { "test.email+alex@leetcode.com",
				"test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com" }));
		System.out.println(numUniqueEmails(new String[] { "a@leetcode.com", "b@leetcode.com", "c@leetcode.com" }));
	}

	public static int numUniqueEmails(String[] emails) {
		HashSet<String> emailSet = new HashSet<String>();
		for (String email : emails) {
			String parts[] = email.split("@");
			String localName = parts[0];
			String domainName = parts[1];
			localName = localName.replaceAll("\\.", "");

			int index = localName.indexOf('+');
			if (index > -1) {
				localName = localName.substring(0, index);
			}

			emailSet.add(localName + "@" + domainName);
		}
		return emailSet.size();
	}

}
