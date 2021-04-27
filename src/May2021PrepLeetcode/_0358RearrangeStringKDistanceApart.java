package May2021PrepLeetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class _0358RearrangeStringKDistanceApart {

	public static void main(String[] args) {
		System.out.println(rearrangeString("aabbcc", 3));
		System.out.println(rearrangeString("aaabc", 3));
		System.out.println(rearrangeString("aaadbbcc", 2));
	}

	static class Pair {
		char c;
		int val;

		public Pair(char c, int val) {
			this.c = c;
			this.val = val;
		}
	}

	public static String rearrangeString(String s, int k) {
		
	}

}
