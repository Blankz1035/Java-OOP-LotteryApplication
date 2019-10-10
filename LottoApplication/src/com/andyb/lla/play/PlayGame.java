package com.andyb.lla.play;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.andyb.lla.game.AdministratorAction;
import com.andyb.lla.towns.TownList;

public class PlayGame {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		TownList townList = new TownList();
		AdministratorAction adminAction = new AdministratorAction();
		
		int choice = 10;

		System.out.println("\nWelcome to the Lottery Application!\n");
		DisplayOptions();

		while (choice!=0) {
			System.out.print("\nEnter a selection: ");
			choice = scan.nextInt();

			switch(choice) {
			case 0:
				System.out.println("Thank you for playing the Lotto!\nExiting Application.");
				break;
			case 1: 
				AdministratorFunctions(townList, adminAction);
				break;
			case 2: 
				PlayAGame(townList);
				break;
			case 3:
				DisplayAllTowns(townList);				
				break;
			case 4:
				DisplayAllDetails(townList);
				break;
			case 5:
				DisplayTownGameDetails(townList);
				break;
			case 6:
				AddTown(townList);
				break;
			case 7:
				DisplayOptions();
				break;
			default:
				System.out.println("Choice selection not available. Please choose again.");
			}
		}
	}

	private static void AdministratorFunctions(TownList townList, AdministratorAction adminAction) {
		// The Administrator functions will be a highly encapsulated class.
		// This class will contain functions to access games and set important values such as: 
		// 1. Set Jackpot Value
		// 2. Check for winners / Set winning numbers
		// 3. Set a Game Name for the town
		// 4. Display Administrator Menu
		// 5. Check user password for entry.
		
		System.out.print("Enter a password to use Administrator Functions: ");
		int pword = scan.nextInt();
		
		if (!adminAction.checkPassword(pword)) {
			System.out.println("Password Incorrect!");
			return;
		}
		
		int selection = 10;
		
		// Display AdminMenu first to the user. Then we will ask for a Town as all options need a town to function!
		adminAction.DisplayAdminMenu();
		
		System.out.print("\nEnter a town name: ");
		String townName = scan.next();
		scan.nextLine();
		
		if (townList.findTownPosition(townName) == null) {
			System.out.println("Town not found. Exiting Admin Functions.");
			return;
		}
		
		while (selection!=0) {
			System.out.print("Enter a selection: ");
			selection = scan.nextInt();
			
			switch(selection) {
			case 0:
				System.out.println("Exiting Admin Mode..");
				break;
			case 1 : case 2: case 3: case 4: 
				adminAction.actionHandler(selection, townList.findTownPosition(townName));
				break;
			case 6:
				adminAction.DisplayAdminMenu();
				break;
			default:
				System.out.println("Selection not available.");
			}
		}
	}

	private static void PlayAGame(TownList townList) {

		int counter = 0;
		ArrayList<Integer> playerChoice = new ArrayList<Integer>();
		
		System.out.print("Enter a town name: ");
		String townName = scan.next();
		scan.nextLine();
		
		if (townList.findTownPosition(townName) == null) {
			System.out.println("Town not found.");
			return;
		}
		// Enter all player details to be added to the Game Object
		System.out.print("Enter a Player name: ");
		String playerName = scan.nextLine();
		
		System.out.print("Enter a Player age: ");
		int playerAge = scan.nextInt();
		scan.nextLine();
		
		if (playerAge <18) {
			System.out.println("Age enter is not within legal range!");
			return;
		}

		System.out.print("Enter a Player Address: ");
		String playerAddress = scan.nextLine();
		
		System.out.println("Select 4 Numbers: ");
		while(counter<4) { 
			counter ++;
			int choice = scan.nextInt();
			playerChoice.add(choice);
		}
		//Sort the ArrayList so comparison is easy with winning numbers later.
		Collections.sort(playerChoice);
		Player p = new Player(playerName, playerAge, playerAddress, playerChoice);

		// Now add the newly created player to a game
		townList.findTownPosition(townName).getGame().addPlayerDetails(p);
		System.out.println("New player has been successfully added to the Game for '" + townName + "'");
	
	}

	public static void DisplayOptions() {
		System.out.println("Available actions to Join In:");
		System.out.println("0 - to quit\n"
				+ "1 - Administrator Options\n"
				+ "2 - Enter into a Game\n"
				+ "3 - Display List of Towns\n"
				+ "4 - Display List of Towns, Games and Jackpots\n"
				+ "5 - Display specific Town's Game Details\n"
				+ "6 - Add a new town\n"
				+ "7 - print available actions.");
	}

	public static void AddTown(TownList townList) {
		System.out.print("Enter a town name: ");
		String townName = scan.next();
		System.out.print("Enter a County name: ");
		String county = scan.next();
		townList.addToList(townName, county);
	}

	public static void DisplayAllTowns(TownList townList) {
		if (townList.getTownList().size() == 0) {
			System.out.println("No towns to display!");
			return;
		}
		for (int i =0; i< townList.getTownList().size(); i++) {
			System.out.println((i+1) + ": Town - " + townList.getTownList().get(i).getTown_name() + "|  County - " 
					+ townList.getTownList().get(i).getCounty());
		}
	}

	public static void DisplayAllDetails(TownList townList) {
		if (townList.getTownList().size() == 0) {
			System.out.println("No towns to display!");
			return;
		}

		for (int i =0; i< townList.getTownList().size(); i++) {
			System.out.println((i+1) + ": Town - " + townList.getTownList().get(i).getTown_name() + "|  County - "
					+ townList.getTownList().get(i).getCounty() + " Game Jackpot: " 
					+ townList.getTownList().get(i).getGame().getJackpot_value() + " Game Plays: " 
					+ townList.getTownList().get(i).getGame().getNumber_of_plays());
		}
	}

	public static void DisplayTownGameDetails(TownList townList) {	
		if (townList.getTownList().size() == 0) {
			System.out.println("No towns to display!");
			return;
		}
		System.out.print("Please enter a town where you wish to check the Game Details: ");
		String townName = scan.next();
		townList.DisplayTownGameDetails(townName);
	}

	
}
