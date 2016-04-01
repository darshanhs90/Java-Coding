package servicenow;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/*
 * Author : Haridarshan H.S.
 * Class  : WickiMeterImageGrid
 * Description:This Class is used to instantiate a WickiMeter Image and convert it to a 2-dimensional character array.
 */
public class WickiMeterImageGrid {
	String wickiMeterFilePath;
	int height,width;
	char imageGrid[][];
	public WickiMeterImageGrid(String filePath){
		wickiMeterFilePath=filePath;
	}
	/**
	 * This method is used to scan the WickiMeter image and store it in a 2D character array
	 *
	 * @return             Nothing
	 * @exception		   IOException On invalid input file.
	 */
	public  void scanImage() throws IOException{
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(wickiMeterFilePath));
			getCoOrdinates();
			imageGrid=new char[height][width];
			String sCurrentLine;
			int lineCounter=0;
			while ((sCurrentLine = br.readLine()) != null) {
				if(!sCurrentLine.trim().contentEquals("")){
					imageGrid[lineCounter]=sCurrentLine.toCharArray();
					lineCounter++;
				}
			}
			br.close();
		} catch (IOException e) {
			throw new IOException("Invalid File Path - Wicki Meter");
		}
	}
	/**
	 * This method is used to calculate the height and width of the WickiMeter image.
	 *
	 * @return             Nothing
	 * @exception		   IOException On invalid input file.
	 */
	private  void getCoOrdinates() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(wickiMeterFilePath));
		String sCurrentLine;
		while ((sCurrentLine = br.readLine()) != null) {
			width=sCurrentLine.length();
			if(!sCurrentLine.trim().contentEquals("")){
				height++;
			}
		}
		br.close();

	}		
	public  String getWickiMeterFilePath() {
		return wickiMeterFilePath;
	}
	public  void setWickiMeterFilePath(String wickiMeterFilePath) {
		this.wickiMeterFilePath = wickiMeterFilePath;
	}
	public  char[][] getImageGrid() {
		return imageGrid;
	}
	public  void setImageGrid(char[][] imageGrid) {
		this.imageGrid = imageGrid;
	}
}
