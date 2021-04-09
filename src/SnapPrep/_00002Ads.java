package SnapPrep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class _00002Ads {
	// For a given user profile with attributes of

	// user={"age":26, "gender":"male", "language":["EN", "ES"] }

	// and a set of ads with related targeting rules

	// ads= [

//	     {"id": 1, "age": [18,25], "gender": "male", "language": ["EN"]},

//	     {"id": 2, "age": [25,25], "gender": "female", "language": ["EN"]},

//	     {"id": 3, "age": [25,30], "gender": "male", "language": ["ES"]},

//	     {"id": 4, "age": [20,40], "gender": "male", "language": ["EN", "ES"]}

	// ]

	// Please implement a function to return total number of ads available for this
	// user.

	// For the example above, the answer is 2

	// Note: For number of ads K: K > 50000
	public static class UserAttributes {
		int age;
		String gender;
		String[] languages;

		public UserAttributes(int age, String gender, String[] languages) {
			this.age = age;
			this.gender = gender;
			this.languages = languages;
		}
	}

	public static class Ads {
		int[] ageRange;
		String gender;
		String[] languages;
		int id;

		public Ads(int id, int[] ageRange, String gender, String[] languages) {
			this.id = id;
			this.ageRange = ageRange;
			this.gender = gender;
			this.languages = languages;
		}
	}

	public static void main(String[] args) {

		UserAttributes userAttributes = new UserAttributes(26, "male", new String[] { "EN", "ES" });
		Ads ad1 = new Ads(1, new int[] { 25, 25 }, "female", new String[] { "EN" });
		Ads ad2 = new Ads(2, new int[] { 18, 25 }, "male", new String[] { "EN" });
		Ads ad3 = new Ads(3, new int[] { 25, 30 }, "male", new String[] { "ES" });
		Ads ad4 = new Ads(4, new int[] { 20, 40 }, "male", new String[] { "EN", "ES" });

		System.out.println(adsCount(userAttributes, new Ads[] { ad1, ad2, ad3, ad4 }));

	}

	public static int adsCount(UserAttributes userAttributes, Ads[] ads) {

		// gender -> male - > language specific child nodes- > ads and its age range
		// 18->childndes, 19->childnoed
//	        -> female - > language specific child nodes -> ads and its age range
		HashMap<String, HashMap<String, HashMap<Integer, List<Ads>>>> adMap = new HashMap<String, HashMap<String, HashMap<Integer, List<Ads>>>>();

		// building a map
		populateMap(ads, adMap);

		HashSet<Ads> matchingAds = new HashSet<Ads>();

		populateMatchingAds(adMap, userAttributes, matchingAds);
		return matchingAds.size();
	}

	public static void populateMatchingAds(HashMap<String, HashMap<String, HashMap<Integer, List<Ads>>>> adMap,
			UserAttributes userAttributes, HashSet<Ads> matchingAds) {
		String userGender = userAttributes.gender;
		int userAge = userAttributes.age;
		String[] userLanguages = userAttributes.languages;
		if (!adMap.containsKey(userGender))
			return;

		HashMap<String, HashMap<Integer, List<Ads>>> languageMap = adMap.get(userGender);

		for (String language : userLanguages) {
			if (!languageMap.containsKey(language)) {
				continue;
			}

			HashMap<Integer, List<Ads>> ageMap = languageMap.get(language);
			if (!ageMap.containsKey(userAge)) {
				continue;
			}
			matchingAds.addAll(ageMap.get(userAge));
		}
	}

	public static void populateMap(Ads[] ads, HashMap<String, HashMap<String, HashMap<Integer, List<Ads>>>> adMap) {
		for (Ads currentAd : ads) {
			String gender = currentAd.gender;
			String languages[] = currentAd.languages;
			int[] ageRange = currentAd.ageRange;

			if (!adMap.containsKey(gender)) {
				adMap.put(gender, new HashMap<String, HashMap<Integer, List<Ads>>>());
			}
			HashMap<String, HashMap<Integer, List<Ads>>> genderMap = adMap.get(gender);

			for (String language : languages) {
				if (!genderMap.containsKey(language)) {
					genderMap.put(language, new HashMap<Integer, List<Ads>>());
				}

				int startAge = ageRange[0];

				int endAge = ageRange[1];

				for (int currAge = startAge; currAge <= endAge; currAge++) {
					HashMap<Integer, List<Ads>> ageMap = genderMap.get(language);

					if (!ageMap.containsKey(currAge)) {
						ageMap.put(currAge, new ArrayList<Ads>());
					}

					adMap.get(gender).get(language).get(currAge).add(currentAd);
				}
			}
		}
	}

}
