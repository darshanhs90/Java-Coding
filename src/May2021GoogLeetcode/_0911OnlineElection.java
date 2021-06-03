package May2021GoogLeetcode;

public class _0911OnlineElection {
	public static void main(String[] args) {
		TopVotedCandidate tvc = new TopVotedCandidate(new int[] { 0, 1, 1, 0, 0, 1, 0 },
				new int[] { 0, 5, 10, 15, 20, 25, 30 });

		System.out.println(tvc.q(3));
		System.out.println(tvc.q(12));
		System.out.println(tvc.q(25));
		System.out.println(tvc.q(15));
		System.out.println(tvc.q(24));
		System.out.println(tvc.q(8));
	}

	static class TopVotedCandidate {

	}
}
