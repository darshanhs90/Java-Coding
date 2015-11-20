package careerCup;

import java.util.Random;

/*
 * Link: http://www.careercup.com/question?id=197774
 * Given a 3 number discrete random number generator {1,2,3} ,
 * how can you design a 5 number random generator.
 */
public class _18googleCareerCup {
	public static void main(String[] args) {
		System.out.println(getRandom());
	}
	private static int getRandom() {
		Random r=new Random();
		int value=0;
		int randomThree=(r.nextInt(4)+1);
		value=(randomThree+randomThree+randomThree+1)%5;
		return value;
	}
}
