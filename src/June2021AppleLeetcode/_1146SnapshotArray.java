package June2021AppleLeetcode;

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

		public SnapshotArray(int length) {

		}

		public void set(int index, int val) {
		}

		public int snap() {
		}

		public int get(int index, int snap_id) {

		}
	}

}
