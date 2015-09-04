package geeksforgeeks;





/*
 * http://www.geeksforgeeks.org/amazon-interview-set-21/
 *  N-Petrol bunk problem: There are n petrol bunks located in a circle.
 *  We have a truck which runs 1 km per 1 liter (mileage 1kmpl).
 *  Two arrays are given.
 *  The distances between petrol bunks are given in one array.
 *  Other array contains the no of litres available at each petrol bunk.
 *  We have to find the starting point such that if we start at that point ,
 *  you we would able to visit entire circle without running out of fuel.
 *  Initially truck has no fuel.
 */;
 public class _01AmazonInterview_21_03 {
	 public static void main(String[] args) {
		 int distance[]={6,3,7};
		 int petrol[]={4,6,4};
		 startingPointLong(distance,petrol);
	 }

	private static void startingPointLong(int[] distance, int[] petrol) {	
		
		for (int i = 0; i < petrol.length; i++) {//for forward propogation in circle
			boolean exited=false;
			int distanceValue=distance[i];
			int petrolValue=petrol[i];
			if(distanceValue>petrolValue){
				continue;
			}
			int j=i;
			int counter=0;
			while(true && counter<distance.length){
				counter++;
				if(i==j){
					j=(j+1)%(distance.length);
					continue;
				}
				else{
					if(distanceValue>petrolValue){
						exited=true;
						break;
					}
					else{
						petrolValue=petrolValue-distanceValue;
						distanceValue=0;
						distanceValue=distance[j];
						petrolValue+=petrol[j];
						j=(j+1)%distance.length;
					}
				}
			}
			if(!exited)
			{
				System.out.println(i);
				return;
			}
		}
		System.out.println("No Path");
		
		
	}
 }