package servicenow;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

//Users/Darshan/Downloads/TestData.wck
//Users/Darshan/Downloads/PhotonBomb.wck
//Users/Darshan/Downloads/Starship.wck

//Users/Darshan/Downloads/files/TestData.wck
//Users/Darshan/Downloads/files/PhotonBomb.wck
//Users/Darshan/Downloads/files/Starship.wck

/*
 * Author : Haridarshan H.S.
 * Class  : WickiMeter
 * Description:This Class is used to test the wickimeter image against the photonbomb and
 * 			   starship images and list the top 10 possible targets based on the confidence level.
 */
public class WickiMeter {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the TestData File Path");
		String wickiImagePath=scanner.next();
		System.out.println("Enter the PhotonBomb File Path");
		String photonBombImagePath=scanner.next();
		System.out.println("Enter the StarShip File Path");
		String startShipImagePath=scanner.next();
		scanner.close();
		WickiMeterImageGrid wicki=new WickiMeterImageGrid(wickiImagePath);
		PhotonBombImageGrid photonBomb=new PhotonBombImageGrid(photonBombImagePath);
		StarShipImageGrid starShip=new StarShipImageGrid(startShipImagePath);
		try {
			wicki.scanImage();
			photonBomb.scanImage();
			starShip.scanImage();
			ImageComparer ic=new ImageComparer(wicki,photonBomb,starShip);
			TreeMap<Double,ArrayList<String>> outputMap=ic.compare();
			int counter=0;
			for (Map.Entry<Double,ArrayList<String>> entry : outputMap.entrySet())
			{
				ArrayList<String> list=entry.getValue();
				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i));
					counter++;
				}
				if(counter>10)
					return;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
	}
}
