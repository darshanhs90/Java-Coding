package PracticeLeetCode;

public class _046Permutations {
	public static void main(String[] args) {
		//System.out.println(permute(new int[]{1,2,3}));
		permute1("","123");
	}

	private static void permute1(String prefix, String string) {
		if(string.length()==0)
		{
			System.out.println(prefix);
			return;
		}
		for (int i = 0; i < string.length(); i++) {
			permute1(prefix+string.charAt(i), string.substring(0,i)+string.substring(i+1));
		}
	}

}

