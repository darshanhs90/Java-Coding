package servicenow;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*
 * Author : Haridarshan H.S.
 * Class  : WickiMeter
 * Description:This Class is used to test the wickimeter image against the photonbomb and
 * 			   starship images and list the top 10 possible targets based on the confidence level.
 */
public class WickiMeter {
	/**
	 * This is the main method which makes use of WickiMeterImageGrid,PhotonBombImageGrid and StarShipImageGrid classes,
	 * to find the list of possible targets and lists out top 10 targets based on the confidence level.
	 * @param args Unused.
	 * @return Nothing.
	 */
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
