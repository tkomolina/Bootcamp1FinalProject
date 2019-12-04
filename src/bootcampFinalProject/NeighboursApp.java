package bootcampFinalProject;

import java.util.ArrayList;
import java.util.Scanner;

public class NeighboursApp {

	static Scanner input = new Scanner(System.in);
	static ArrayList<Neighbours> neighbourList = new ArrayList<>();
	static Neighbours selectedNeighbour = null;

	public static void main(String[] args) {
		neighbourList.add(Neighbours.getNeighbour("Lynette", 25));
		neighbourList.add(Neighbours.getNeighbour("Gabrielle", 30));
		neighbourList.add(Neighbours.getNeighbour("Carlos", 35));
		System.out.println("Welcome to Wisteria Lane!");

		String option = "";
		while (!option.equals("q")) {
			if (selectedNeighbour == null) {
				System.out.println("Please select option:");
				System.out.println("[l] - list neighbours' names ");
				System.out.println("[a] - add a new neighbour");
				System.out.println("[1] - select neighbour by name");
				System.out.println("[q] - quit the program");

				if (input.hasNext())
					option = input.nextLine();

				switch (option) {
				case "l":
					listNames();
					break;
				case "a":
					addNeighbour();
					break;
				case "1":
					selectName();
					break;
				case "q":
					break;
				default:
					System.out.println("Option not recognized!");
				}
			} else {
				System.out.println("Please select option:");
				System.out.println("[l] - list neighbours' names ");
				System.out.println("[a] - add a new neighbour");
				System.out.println("[c] - change selected neighbour by name");
				System.out.println("[2] - change name for selected neighbour");
				System.out.println("[3] - bake a cake for selected neighbour");
				System.out.println("[4] - " + selectedNeighbour.getName()
						+ " watches TV show");
				System.out.println("[5] - " + selectedNeighbour.getName()
						+ " eats dinner");
				System.out.println("[6] - " + selectedNeighbour.getName()
						+ " fights with another neighbour");
				System.out.println("[7] - " + selectedNeighbour.getName()
						+ " gives cake to another neighbour");
				System.out.println("[8] - " + selectedNeighbour.getName()
						+ " has dinner with another neighbour");
				System.out.println("[9] - " + selectedNeighbour.getName()
						+ " has a birthday party");

				System.out.println("[q] - quit the program");

				if (input.hasNext())
					option = input.nextLine();

				switch (option) {
				case "l":
					listNames();
					break;
				case "a":
					addNeighbour();
					break;
				case "c":
					selectName();
					break;
				case "2":
					changeName();
					break;
				case "3":
					selectedNeighbour.bakeCake();
					break;
				case "4":
					watchTV();
					break;
				case "5":
					eatDinner();
					break;
				case "6":
					fightWithNeighbour();
					break;
				case "7":
					giveCake();
					break;
				case "8":
					dinnerWithNeighbour();
					break;
				case "9":
					selectedNeighbour.birthdayParty(neighbourList);
					break;
				case "q":
					break;
				default:
					System.out.println("Option not recognized!");
				}
			}
		}
	}

	public static void listNames() {
		for (Neighbours element : neighbourList) {
			System.out.print(element.getName() + " ");
		}
		System.out.println();
	}

	public static void selectName() {

		System.out.println("Input neighbour's name");
		String name = input.nextLine();
		selectedNeighbour = findByName(name);
		System.out.println("Name " + name + " has been sucessfully selected.");
	}

	public static void changeName() {
		System.out.println("Input neighbour's new name");
		String name = input.nextLine();
		selectedNeighbour.changeName(name);
	}

	public static void watchTV() {
		System.out.println("How long the neighbour will watch TV?");
		if (input.hasNextInt()) {
			int minutes = input.nextInt();
			selectedNeighbour.watchTVshow(minutes);
		}else{
			System.out.println("Invalid input");
		}
		
	}

	public static void eatDinner() {
		System.out.println("How much will this neighbour eat?");
		int mealSize = input.nextInt();
		selectedNeighbour.eatDinner(mealSize);
	}

	public static void fightWithNeighbour() {
		System.out.println("Which neighbour will "
				+ selectedNeighbour.getName() + " fight?");
		String otherNeighbour = input.nextLine();
		System.out.println("For how long will they fight?");
		int minutes = input.nextInt();
		selectedNeighbour.fight(findByName(otherNeighbour), minutes);

	}

	public static void giveCake() {
		System.out.println("To whom will " + selectedNeighbour.getName()
				+ " give the cake?");
		String otherNeighbour = input.nextLine();
		selectedNeighbour.giveCakeToNeighbour(findByName(otherNeighbour));
	}

	public static void dinnerWithNeighbour() {
		System.out.println("With whom will " + selectedNeighbour.getName()
				+ " eat dinner?");
		String otherNeighbour = input.nextLine();
		System.out.println("How much will they eat?");
		int mealSize = input.nextInt();
		selectedNeighbour.dinnerWithNeighbour(findByName(otherNeighbour),
				mealSize);
	}

	public static void addNeighbour() {
		System.out.println("Input name");
		String newNeighbour = input.nextLine();
		System.out.println("Enter age");
		int newAge = input.nextInt();
		Neighbours addedNeighbour = new Neighbours(newNeighbour, newAge);
		neighbourList.add(addedNeighbour);
		System.out.println("Neighbour " + addedNeighbour.getName()
				+ " has moved in");
	}

	private static Neighbours findByName(String name) {
		Neighbours found = null;
		for (int i = 0; i < neighbourList.size(); i++) {
			if (neighbourList.get(i).getName().equals(name)) {
				found = neighbourList.get(i);
				break;
			}

		}
		return found;
	}
}
