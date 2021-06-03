package May2021GoogLeetcode;

import java.util.TreeMap;

public class _1146SnapshotArray {
	public static void main(String[] args) {
		SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
		snapshotArr.set(0, 5); // Set array[0] = 5
		System.out.println(snapshotArr.snap()); // Take a snapshot, return snap_id = 0
		snapshotArr.set(0, 6);
		System.out.println(snapshotArr.get(0, 0)); // Get the value of array[0] with snap_id = 0, return 5

		snapshotArr = new SnapshotArray(4); // set the length to be 3
		System.out.println(snapshotArr.snap()); // Take a snapshot, return snap_id = 0
		System.out.println(snapshotArr.snap()); // Take a snapshot, return snap_id = 1
		System.out.println(snapshotArr.get(3, 1));
		snapshotArr.set(2, 4);
		System.out.println(snapshotArr.snap()); // Take a snapshot, return snap_id = 2
		snapshotArr.set(1, 4);
	}

	static class SnapshotArray {
		TreeMap[] map;
		int snapId = 0;

		public SnapshotArray(int length) {
			map = new TreeMap[length];
			for (int i = 0; i < map.length; i++) {
				map[i] = new TreeMap<Integer, Integer>();
				map[i].put(0, 0);
			}
		}

		public void set(int index, int val) {
			map[index].put(snapId, val);
		}

		public int snap() {
			snapId++;
			return snapId - 1;
		}

		public int get(int index, int snap_id) {
			return (int) map[index].floorEntry(snap_id).getValue();
		}
	}

}
