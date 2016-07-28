package eBayPrep;

public class _295FindMedianFromDataStream{
	public static class MedianFinder {

		// Adds a number into the data structure.
		int count=-1;
		double currMedian=-1;
		public void addNum(int num) {
			if(count==-1){
				count=1;
				currMedian=num;
			}
			else{
				currMedian=(double)((currMedian*count)+num)/(double)(count+1);
				count++;
			}
		}

		// Returns the median of current data stream
		public double findMedian() {
			return currMedian;
		}
	};


	public static void main(String[] args) {
		MedianFinder m=new MedianFinder();
		m.addNum(2);
		System.out.println(m.findMedian());
		m.addNum(3);
		System.out.println(m.findMedian());


	}
}

