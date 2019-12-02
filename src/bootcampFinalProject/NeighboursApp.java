package bootcampFinalProject;

import java.util.ArrayList;
import java.util.Scanner;

public class NeighboursApp {
	
	static Scanner input = new Scanner(System.in);
	static ArrayList<Neighbours> neighbourList = new ArrayList<>();
	
	public static void main(String[] args) {
		neighbourList.add(Neighbours.getNeighbour("Lynette", 25));
		neighbourList.add(Neighbours.getNeighbour("Gabrielle", 30));
		neighbourList.add(Neighbours.getNeighbour("Carlos", 35));
		System.out.println("Welcome to Wisteria Lane!");
		
		String option = "";
		while (option != "q") {
			System.out.println("Please select option:");
			System.out.println("[l] - list neighbours' names ");
			System.out.println("[1] - select Lynette");
			System.out.println("[2] - select Gabrielle");
			System.out.println("[3] - select Carlos");
			System.out.println("[b] - 	");
			
			System.out.println("[q] - quit the program");
			
			option = input.nextLine();

			/*switch (option) {
			case "l":
				listCountryNames();
				break;
			case "a":
				addNewForecast();
				break;
			case "d":
				deleteForecast();
				break;
			case "g":
				addNewForecastCountry();
				break;
			case "q":
				break;
			default:
				System.out.println("Option not recognized!");
			}*/
				
		}

	}

}
