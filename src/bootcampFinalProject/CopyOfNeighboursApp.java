package bootcampFinalProject;

import java.util.ArrayList;
import java.util.Scanner;

public class CopyOfNeighboursApp {

	static Scanner input = new Scanner(System.in);
	static ArrayList<Neighbours> neighbourList = new ArrayList<>();
	static Neighbours selectedNeighbour = null;

	public static void main(String[] args) {
		neighbourList.add(Neighbours.getNeighbour("Lynette", 25));
		neighbourList.add(Neighbours.getNeighbour("Gabrielle", 30));
		neighbourList.add(Neighbours.getNeighbour("Carlos", 35));
		System.out.println("Welcome to Wisteria Lane!");

		int option = 999;
		while (option!=99) {
			if (selectedNeighbour == null) {
				System.out.println("");
				System.out.println("Please select your option:");
				System.out.println("[11] - list neighbours' names ");
				System.out.println("[33] - add a new neighbour");
				System.out.println("[1] - select a neighbour by name");
				System.out.println("[99] - quit the program");
				System.out.println("");

				if (input.hasNextInt())
					option = input.nextInt();

				switch (option) {
				case 11:
					listNames();
					break;
				case 33:
					addNeighbour();
					break;
				case 1:
					selectName();
					break;
				case 99:
					System.out.println("You've exited the application");
					break;
				default:
					System.out.println("Option not recognized!");
				}
			} else {
				System.out.println("");
				System.out.println("Please select your option:");
				System.out.println("[11] - list neighbours' names ");
				System.out.println("[33] - add a new neighbour");
				System.out.println("[22] - change selected neighbour");
				System.out.println("[2] - change name for "
						+ selectedNeighbour.getName());
				System.out.println("[3] - bake a cake");
				System.out.println("[4] - watch a TV show");
				System.out.println("[5] - eat dinner");
				System.out.println("[6] - fight with another neighbour");
				System.out.println("[7] - give cake to another neighbour");
				System.out.println("[8] - have dinner with another neighbour");
				System.out.println("[9] - have a birthday party");

				System.out.println("[99] - quit the program");
				System.out.println("");

				if (input.hasNextInt())
					option = input.nextInt();

				switch (option) {
				case 11:
					listNames();
					break;
				case 33:
					addNeighbour();
					break;
				case 22:
					selectName();
					break;
				case 2:
					changeName();
					break;
				case 3:
					selectedNeighbour.bakeCake();
					break;
				case 4:
					watchTV();
					break;
				case 5:
					eatDinner();
					break;
				case 6:
					fightWithNeighbour();
					break;
				case 7:
					giveCake();
					break;
				case 8:
					dinnerWithNeighbour();
					break;
				case 9:
					selectedNeighbour.birthdayParty(neighbourList);
					break;
				case 99:
					System.out.println("You've exited the application");
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
		listNames();
		System.out.println("Choose neighbour's name");
		String name = input.nextLine();
		selectedNeighbour = findByName(name);
		System.out.println("Name " + name + " has been sucessfully selected.");
		selectedNeighbour.info();
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
		} else {
			System.out.println("Invalid input");
		}

	}

	public static void eatDinner() {
		System.out.println("How much will this neighbour eat?");
		if (input.hasNextInt()) {
			int mealSize = input.nextInt();
			selectedNeighbour.eatDinner(mealSize);
		} else {
			System.out.println("Invalid input");
		}
	}

	public static void fightWithNeighbour() {
		System.out.println("Which neighbour will "
				+ selectedNeighbour.getName() + " fight?");
		listNames();
		String otherNeighbour = input.nextLine();
		if (findByName(otherNeighbour) == null) {
			System.out.println("Neighbour not found");
		} else {

			System.out.println("For how long will they fight?");
			if (input.hasNextInt()) {
				int minutes = input.nextInt();
				selectedNeighbour.fight(findByName(otherNeighbour), minutes);
			} else {
				System.out.println("Invalid input");
			}

		}
	}

	public static void giveCake() {
		System.out.println("To whom will " + selectedNeighbour.getName()
				+ " give the cake?");
		listNames();
		String otherNeighbour = input.nextLine();
		if (findByName(otherNeighbour) == null) {
			System.out.println("Neighbour not found");
		} else {
			selectedNeighbour.giveCakeToNeighbour(findByName(otherNeighbour));

		}
	}

	public static void dinnerWithNeighbour() {
		System.out.println("With whom will " + selectedNeighbour.getName()
				+ " eat dinner?");
		listNames();
		String otherNeighbour = input.nextLine();
		if (findByName(otherNeighbour) == null) {
			System.out.println("Neighbour not found");
		} else {
			System.out.println("How much will they eat?");
			if (input.hasNextInt()) {
				int mealSize = input.nextInt();
				selectedNeighbour.dinnerWithNeighbour(
						findByName(otherNeighbour), mealSize);
			} else {
				System.out.println("Invalid input");
			}
		}
	}

	public static void addNeighbour() {
		System.out.println("Input name");
		String newNeighbour = input.nextLine();
		if (findByName(newNeighbour) == null) {
			System.out.println("Enter age");
			if (input.hasNextInt()) {
				int newAge = input.nextInt();
				Neighbours addedNeighbour = new Neighbours(newNeighbour, newAge);
				neighbourList.add(addedNeighbour);
				System.out.println("Neighbour " + addedNeighbour.getName()
						+ " has moved in");
				addedNeighbour.info();
			} else {
				System.out.println("Invalid input");
			}
		} else {
			System.out.println("Neighbour with this name is already exists.");
		}
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
