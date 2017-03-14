package hackerRank.WeekOfCode29;

/*
 * Link:https://www.dropbox.com/scl/fi/6dkg1y66xq5i8njhjigo4/Columnar%20Layout%201.png?dl=0
 */
public class _06DropboxQuestion {
	static class Point{
		int x,y;
		Point(int x,int y)
		{
			this.x=x;
			this.y=y;
		}

	}
	static class Size{
		int width,height;
		Size(int width,int height)
		{
			this.width=width;
			this.height=height;
		}

	}
	static Point[] layout(Size parentSize,Size[] childSizes)
	{
		int maxlen = parentSize.width;
		int maxht = parentSize.height;
		int rtnlen = 0;
		int newlen = 0;
		int newht =0;
		Point[] points = new Point[childSizes.length];
		for (int i=0; i <= childSizes.length-1; i++)
		{

			if (rtnlen < childSizes[i].width)
			{
				rtnlen=childSizes[i].width;
				if (childSizes[i].height <= maxht && childSizes[i].width <= maxlen) {
					if (maxlen-newlen >= childSizes[i].width && (maxht-newht) >= childSizes[i].height){
						Point start0 = new Point(newlen, newht);
						newht+= childSizes[i].height;
						points[i]=start0;
					}

					else{
						newlen= rtnlen;
						rtnlen=0;
						newht=0;
						if(maxht-newht <= childSizes[i].height && maxlen-newlen <= childSizes[i].width){

							Point start1 = new Point(newlen,0);
							points[i]= start1;

						}


						else {
							System.out.println("Too Large for this layout");
						}
					}
				}
			}
		}




		return points;
	}
	public static void main(String[] args) {
		Point[] out=layout(new Size(100, 100),new Size[]{new Size(20,20),new Size(30,30),new Size(40,40),new Size(30,50)});
		try{
			for(Point p : out)
			{
				System.out.println(p.x+"/"+p.y);
			}
		}
		catch(Exception e)
		{

		}
	}



}
