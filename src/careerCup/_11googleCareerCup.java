package careerCup;

/*
 * Link: http://www.careercup.com/question?id=64372
 * Count number of bits 
 */
public class _11googleCareerCup {

	public static void main(String[] args) {
		System.out.println(bitCount(7));
	}
	private static int bitCount(long val) { 
		val -= (val & 0xaaaaaaaaaaaaaaaaL) >>> 1; 
		val = (val & 0x3333333333333333L) + ((val >>> 2) & 0x3333333333333333L); 
		val = (val + (val >>> 4)) & 0x0f0f0f0f0f0f0f0fL; 
		val += val >>> 8; 
		val += val >>> 16; 
		return ((int)(val) + (int)(val >>> 32)) & 0xff; 
	}

}
