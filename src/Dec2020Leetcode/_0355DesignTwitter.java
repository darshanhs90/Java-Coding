package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class _0355DesignTwitter {

	public static void main(String[] args) {
		Twitter twitter = new Twitter();

		// User 1 posts a new tweet (id = 5).
		twitter.postTweet(1, 5);

		// User 1's news feed should return a list with 1 tweet id -> [5].
		// System.out.println(twitter.getNewsFeed(1));

		// User 1 follows user 2.
		twitter.follow(1, 2);

		// User 2 posts a new tweet (id = 6).
		twitter.postTweet(2, 6);

		// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
		// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
		System.out.println(twitter.getNewsFeed(1));

		// User 1 unfollows user 2.
		twitter.unfollow(1, 2);

		// User 1's news feed should return a list with 1 tweet id -> [5],
		// since user 1 is no longer following user 2.
		System.out.println(twitter.getNewsFeed(1));
	}

	static class Tweet {
		int tweetId;
		int autoGenId;

		public Tweet(int tweetId, int autoGenId) {
			this.tweetId = tweetId;
			this.autoGenId = autoGenId;
		}
	}

	static class Twitter {
		HashMap<Integer, HashSet<Integer>> userFollowersMap;
		HashMap<Integer, HashSet<Tweet>> userTweetsMap;
		int autoGenId = 0;

		/** Initialize your data structure here. */
		public Twitter() {
			userFollowersMap = new HashMap<Integer, HashSet<Integer>>();
			userTweetsMap = new HashMap<Integer, HashSet<Tweet>>();
		}

		/** Compose a new tweet. */
		public void postTweet(int userId, int tweetId) {
			if (userTweetsMap.containsKey(userId)) {
				userTweetsMap.get(userId).add(new Tweet(tweetId, autoGenId));
			} else {
				HashSet<Tweet> tweetsSet = new HashSet<Tweet>();
				tweetsSet.add(new Tweet(tweetId, autoGenId));
				HashSet<Integer> usersSet = new HashSet<Integer>();
				usersSet.add(userId);
				userFollowersMap.put(userId, usersSet);
				userTweetsMap.put(userId, tweetsSet);
			}
			autoGenId++;
		}

		/**
		 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in
		 * the news feed must be posted by users who the user followed or by the user
		 * herself. Tweets must be ordered from most recent to least recent.
		 */
		public List<Integer> getNewsFeed(int userId) {
			Set<Integer> followers = userFollowersMap.get(userId);
			List<Tweet> tweets = new ArrayList<Tweet>();
			if (followers != null && followers.size() > 0) {
				Iterator<Integer> iter = followers.iterator();
				while (iter.hasNext()) {
					tweets.addAll(userTweetsMap.get(iter.next()));
				}
				Collections.sort(tweets, new Comparator<Tweet>() {

					@Override
					public int compare(Tweet o1, Tweet o2) {
						// TODO Auto-generated method stub
						return o2.autoGenId - o1.autoGenId;
					}
				});
				if (tweets.size() > 10) {
					tweets = tweets.subList(0, 10);
				}
			}

			List<Integer> output = new ArrayList<Integer>();
			for (int i = 0; i < tweets.size(); i++) {
				output.add(tweets.get(i).tweetId);
			}

			return output;
		}

		/**
		 * Follower follows a followee. If the operation is invalid, it should be a
		 * no-op.
		 */
		public void follow(int followerId, int followeeId) {
			if (followerId == followeeId)
				return;
			if (userFollowersMap.containsKey(followerId) && userFollowersMap.containsKey(followeeId)) {
				userFollowersMap.get(followerId).add(followeeId);
			} else if (userFollowersMap.containsKey(followerId)) {
				userFollowersMap.put(followeeId, new HashSet<Integer>());
				userFollowersMap.get(followeeId).add(followeeId);
				userFollowersMap.get(followerId).add(followeeId);
				userTweetsMap.put(followeeId, new HashSet<Tweet>());
			} else if (userFollowersMap.containsKey(followeeId)) {
				userFollowersMap.put(followerId, new HashSet<Integer>());
				userFollowersMap.get(followerId).add(followerId);
				userFollowersMap.get(followerId).add(followeeId);
				userTweetsMap.put(followerId, new HashSet<Tweet>());
			} else {
				userFollowersMap.put(followerId, new HashSet<Integer>());
				userFollowersMap.put(followeeId, new HashSet<Integer>());
				userFollowersMap.get(followerId).add(followerId);
				userFollowersMap.get(followeeId).add(followeeId);
				userFollowersMap.get(followerId).add(followeeId);
				userTweetsMap.put(followerId, new HashSet<Tweet>());
				userTweetsMap.put(followeeId, new HashSet<Tweet>());
			}
		}

		/**
		 * Follower unfollows a followee. If the operation is invalid, it should be a
		 * no-op.
		 */
		public void unfollow(int followerId, int followeeId) {
			if (followerId == followeeId)
				return;
			if (userFollowersMap.containsKey(followerId) && userFollowersMap.containsKey(followeeId)) {
				userFollowersMap.get(followerId).remove(followeeId);
			}
		}
	}

}
