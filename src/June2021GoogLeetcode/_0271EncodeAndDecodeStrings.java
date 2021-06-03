package June2021GoogLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0271EncodeAndDecodeStrings {

	public static void main(String[] args) {

		Codec codec = new Codec();
		System.out.println(
				codec.decode(codec.encode(new ArrayList<String>(Arrays.asList("a", "b", "c", "d", "sss", "f")))));

	}

	public static class Codec {
	
	}
}
