package servicenow;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;
/*
 * Author : Haridarshan H.S.
 * Class  : ImageComparer
 * Description:This Class is used to compare the wickimeter image against the photonbomb and
 * 			   starship images and populate the possible targets sorted by the confidence.
 */
public class ImageComparer {
	WickiMeterImageGrid wicki;
	PhotonBombImageGrid photon;
	StarShipImageGrid starShip;
	TreeMap<Double,ArrayList<String>> confidenceMap;
	public ImageComparer(WickiMeterImageGrid wicki,PhotonBombImageGrid photon,StarShipImageGrid starShip){
		this.wicki=wicki;
		this.photon=photon;
		this.starShip=starShip;
	}
	/**
	 * This method is used to compare the testdata image against the target images. 
	 *
	 * @return         the list of possible targets found sorted by the confidence level
	 */
	public TreeMap<Double,ArrayList<String>> compare() {
		char[][] mainImage=wicki.getImageGrid();
		char[][] testImage=photon.getImageGrid();
		confidenceMap=new TreeMap<>(Collections.reverseOrder());
		findTarget(mainImage, testImage,"PhotonBomb");
		testImage=starShip.getImageGrid();
		findTarget(mainImage, testImage,"StarShip");
		return confidenceMap;
	}
	/**
	 * This method is used to find the target/test image in the main image
	 *
	 * @param  mainImage   the testdata image
	 * @param  testImage   the target image
	 * @param  target      type of the target
	 * @return			   Nothing
	 */
	private void findTarget(char[][] mainImage, char[][] testImage,String target) {
		for (int i = 0; i < mainImage.length-testImage.length; i++) {
			for (int j = 0; j < mainImage[0].length-testImage[0].length; j++) {
				double confidence=checkImagePixel(mainImage,i,j,testImage);
				ArrayList<String> list;
				if(confidenceMap.containsKey(confidence)){
					list=confidenceMap.get(confidence);
					list.add("Target:"+target+" , Confidence:"+confidence*100+"% , x="+i+" , y="+j);
				}
				else{
					list=new ArrayList<>();
					list.add("Target:"+target+" , Confidence:"+confidence*100+" , x="+i+" , y="+j);
				}
				confidenceMap.put(confidence, list);
			}
		}
	}
	/**
	 * This method is used to check the target mask in the main image starting at the given x and y co-ordinates. 
	 *
	 * @param  mainImage   the wicki image or the testdata image
	 * @param  x   		   the x co-ordinate in the testdata from where the scan needs to be started
	 * @param  y   		   the y co-ordinate in the testdata from where the scan needs to be started
	 * @param  testImage   the target image
	 * @return             the confidence in the target
	 */
	private double checkImagePixel(char[][] mainImage,int x, int y, char[][] testImage) {
		int posCounter=0,negCounter=0;
		for (int i = 0; i < testImage.length; i++) {
			for (int j = 0; j < testImage[0].length; j++) {
				if(testImage[i][j]=='+')
				{
					if(mainImage[x+i][y+j]=='+')
						posCounter++;
					else
						negCounter++;
				}
			}
		}
		return posCounter/(float)(posCounter+negCounter);
	}

}
