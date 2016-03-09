package hackerRank.CodeWhiz;
import java.util.BitSet;
import java.util.Scanner;

/*
 * Maximum and Minimum
 * Link:https://www.hackerrank.com/contests/codewhiz-java-march-2016/challenges/maximum-and-minimum
 */
public class _04JavaBitSet {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfElements=in.nextInt();
		int noOfTestCases=in.nextInt();
		BitSet b1=new BitSet(noOfElements);
		BitSet b2=new BitSet(noOfElements);
		for (int i = 0; i < noOfTestCases; i++) {
			String operator=(in.next());
			if(operator.contentEquals("AND"))
			{
				int value1=in.nextInt();
				int value2=in.nextInt();
				if(value1==1)
				{
					if(value2==2)
						b1.and(b2);
					else
						b1.and(b1);
				}
				else{
					if(value2==2)
						b2.and(b2);
					else
						b2.and(b1);
				}
			}else if(operator.contentEquals("SET"))
			{
				int value=in.nextInt();
				int index=in.nextInt();
				if(value==1)
				{
					b1.set(index);
				}
				else{
					b2.set(index);
				}
			}else if(operator.contentEquals("FLIP"))
			{
				int value=in.nextInt();
				int index=in.nextInt();
				if(value==1)
				{
					b1.flip(index);
				}
				else{
					b2.flip(index);
				}
			}else  if(operator.contentEquals("XOR")){
				int value1=in.nextInt();
				int value2=in.nextInt();
				if(value1==1)
				{
					if(value2==2)
						b1.xor(b2);
					else
						b1.xor(b1);
				}
				else{
					if(value2==1)
						b2.xor(b1);
					else
						b2.xor(b2);
				}
			}
			else{
				int value1=in.nextInt();
				int value2=in.nextInt();
				if(value1==1)
				{
					if(value2==2)
						b1.or(b2);
					else
						b1.or(b1);
				}
				else{
					if(value2==1)
						b2.or(b1);
					else
						b2.or(b2);
				}
			}
			System.out.println(b1.cardinality()+" "+b2.cardinality());
		}
	}
}
