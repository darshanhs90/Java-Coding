package hackerRank.CodeWhiz;
import java.math.BigInteger;
import java.util.Scanner;

/*
 * Maximum and Minimum
 * Link:https://www.hackerrank.com/contests/codewhiz-java-march-2016/challenges/maximum-and-minimum
 */
public class _03JavaPrimalityTest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BigInteger n = in.nextBigInteger();
		in.close();
		if(n.isProbablePrime(128))
			System.out.println("prime");
		else
			System.out.println("not prime");
	}
}
