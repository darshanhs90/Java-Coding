package appleInterview;

public class _10PrepDocLittleEndianToBigEndian {
	public static void main(String[] args) {
		String str="4042912835628958";
		//System.out.println(str);
		//System.out.println(converter(str));
		System.out.println(bitConverter(str));
	}

	private static String bitConverter(String str) {
		long value=Long.parseLong(str);
		long b1 = (value >>  0) & 0xff;
		long b2 = (value >>  8) & 0xff;
		long b3 = (value >> 16) & 0xff;
		long b4 = (value >> 24) & 0xff;
		return ( b1 << 24 | b2 << 16 | b3 << 8 | b4 << 0)+"";
	}

	private static String converter(String str) {
		StringBuilder sb=new StringBuilder(str);
		str=sb.reverse().toString();
		sb=new StringBuilder();
		for (int i = 0; i < str.length(); i+=2) {
			StringBuilder temp=new StringBuilder(str.substring(i,i+2));
			sb.append(temp.reverse().toString());
		}
		return sb.toString();
	}
}
