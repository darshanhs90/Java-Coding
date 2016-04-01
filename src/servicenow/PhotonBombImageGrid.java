package servicenow;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/*
 * Author : Haridarshan H.S.
 * Class  : PhotonBombImageGrid
 * Description:This Class is used to instantiate a PhotonBomb Image and convert it to a 2-dimensional character array.
 */
public class PhotonBombImageGrid {
	String photonFilePath;
	int height,width;
	char imageGrid[][];
	public PhotonBombImageGrid(String filePath){
		photonFilePath=filePath;
	}
	/**
	 * This method is used to scan the photonbomb image and store it in a 2D character array
	 *
	 * @return             Nothing
	 * @exception		   IOException On invalid input file.
	 */
	public  void scanImage() throws IOException{
		BufferedReader br;
		try{
			br= new BufferedReader(new FileReader(photonFilePath));
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
		} catch (Exception e) {
			throw new IOException("Invalid File Path - Photon bomb");
		};
	}
	/**
	 * This method is used to calculate the height and width of the photonbomb image.
	 *
	 * @return             Nothing
	 * @exception		   IOException On invalid input file.
	 */
	private  void getCoOrdinates() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(photonFilePath));
		String sCurrentLine;
		while ((sCurrentLine = br.readLine()) != null) {
			width=sCurrentLine.length();
			if(!sCurrentLine.trim().contentEquals("")){
				height++;
			}
		}
		br.close();
	}
	public  String getPhotonFilePath() {
		return photonFilePath;
	}
	public  void setPhotonFilePath(String photonFilePath) {
		this.photonFilePath = photonFilePath;
	}
	public  char[][] getImageGrid() {
		return imageGrid;
	}
	public  void setImageGrid(char[][] imageGrid) {
		this.imageGrid = imageGrid;
	}	
}
