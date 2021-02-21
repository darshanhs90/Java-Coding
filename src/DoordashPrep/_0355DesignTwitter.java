package DoordashPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

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
		int id;

		public Tweet(int id, int tweetId) {
			this.id = id;
			this.tweetId = tweetId;
		}
	}

	static class Twitter {

		int autoGenId = 0;
		HashMap<Integer, HashSet<Integer>> userFollowerMap;
		HashMap<Integer, HashSet<Tweet>> userTweetMap;

		/** Initialize your data structure here. */
		public Twitter() {
			userFollowerMap = new HashMap<Integer, HashSet<Integer>>();
			userTweetMap = new HashMap<Integer, HashSet<Tweet>>();
		}

		/** Compose a new tweet. */
		public void postTweet(int userId, int tweetId) {
			if (!userFollowerMap.containsKey(userId)) {
				userFollowerMap.put(userId, new HashSet<Integer>(Arrays.asList(userId)));
				userTweetMap.put(userId, new HashSet<Tweet>());
			}
			userTweetMap.get(userId).add(new Tweet(autoGenId, tweetId));
			autoGenId++;
		}

		/**
		 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in
		 * the news feed must be posted by users who the user followed or by the user
		 * herself. Tweets must be ordered from most recent to least recent.
		 */
		public List<Integer> getNewsFeed(int userId) {
			List<Integer> output = new ArrayList<Integer>();
			if (!userTweetMap.containsKey(userId))
				return output;
			List<Tweet> tweets = new ArrayList<Tweet>();
			Iterator<Integer> followers = userFollowerMap.get(userId).iterator();
			while (followers.hasNext()) {
				tweets.addAll(userTweetMap.get(followers.next()));
			}
			Collections.sort(tweets, new Comparator<Tweet>() {
				@Override
				public int compare(Tweet o1, Tweet o2) {
					// TODO Auto-generated method stub
					return o2.id - o1.id;
				}
			});

			for (int i = 0; i < Math.min(tweets.size(), 10); i++) {
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
			if (!userFollowerMap.containsKey(followerId)) {
				userFollowerMap.put(followerId, new HashSet<Integer>(Arrays.asList(followerId)));
				userTweetMap.put(followerId, new HashSet<Tweet>());
			}

			if (!userFollowerMap.containsKey(followeeId)) {
				userFollowerMap.put(followeeId, new HashSet<Integer>(Arrays.asList(followeeId)));
				userTweetMap.put(followeeId, new HashSet<Tweet>());
			}

			userFollowerMap.get(followerId).add(followeeId);
		}

		/**
		 * Follower unfollows a followee. If the operation is invalid, it should be a
		 * no-op.
		 */
		public void unfollow(int followerId, int followeeId) {
			if (followerId == followeeId)
				return;
			if (!userFollowerMap.containsKey(followerId)) {
				userFollowerMap.put(followerId, new HashSet<Integer>(Arrays.asList(followerId)));
				userTweetMap.put(followerId, new HashSet<Tweet>());
			}

			if (!userFollowerMap.containsKey(followeeId)) {
				userFollowerMap.put(followeeId, new HashSet<Integer>(Arrays.asList(followeeId)));
				userTweetMap.put(followeeId, new HashSet<Tweet>());
				return;
			}

			if (userFollowerMap.get(followerId).contains(followeeId)) {
				userFollowerMap.get(followerId).remove(followeeId);
			}
		}
	}

}
