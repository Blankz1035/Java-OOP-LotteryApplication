package com.andyb.lla.game;

import java.util.ArrayList;
import java.util.Scanner;

import com.andyb.lla.towns.Town;

public class AdministratorAction {

	private Scanner scan = new Scanner(System.in);
	
	private int password = 2468;
	
	public AdministratorAction() {
		// Empty constructor for creation of Object
	}
	
	private void setGameJackpot (Town town, int jackpotValue) {
		town.getGame().setJackpot_value(jackpotValue);
	}
	
	private void setGameName (Town town, String gameName) {
		town.getGame().setGameName(gameName);
	}
	
	private void setWinningNumbers(Town town, ArrayList<Integer> winningNumbers) {
		town.getGame().setWinning_numbers(winningNumbers);
	}
	
	private void checkGameWinner (Town town) {
		boolean won = false;
		
		if (town.getGame().getWinning_numbers().size()==0) {
			System.out.println("Winning number have not yet been added to Game.\nCheck Failed.");
			return;
		}
		for (int i = 0; i < town.getGame().getPlayerList().size(); i++) {
			if (town.getGame().getWinning_numbers().equals(town.getGame().getPlayerList().
					get(i).getPlayerChoice())) {
				System.out.println("*Winner of lotto Game: " + town.getGame().getPlayerList().get(i).getPlayerName() + "*");
				won = true;
			}
		}
		System.out.println("Game won status: " + won + "\n");
	}
	
	public void actionHandler (int selection, Town town) {
		// This handler class will take in a selection value from the main program.
		// The handler will then delegate work to each provider methods to perform the task.
		int jackpotValue = 0;
		String gameName = "";
		ArrayList<Integer> winningNumbers = new ArrayList<Integer>();
		
		switch(selection) {
		case 1:
			System.out.print("Enter a new Game Name: ");
			gameName = scan.nextLine();
			setGameName(town, gameName);
			break;
		case 2:
			System.out.print("Enter a Lotto Jackpot Value: ");
			jackpotValue = scan.nextInt();
			setGameJackpot(town, jackpotValue);
			break;
		case 3:
			int counter =0;
			System.out.println("Select 4 Numbers: ");
			while(counter<4) { 
				counter ++;
				int choice = scan.nextInt();
				winningNumbers.add(choice);
			}
			setWinningNumbers(town, winningNumbers);
			break;
		case 4:
			checkGameWinner(town);
			break;
		default:
			System.out.println("Selection not valid.");
			break;
		}
	}

	public void DisplayAdminMenu() {
		System.out.println("\n====== Admin actions: ======");
		System.out.println("0 - to quit\n"
				+ "1 - Set a Towns game name\n"
				+ "2 - Set a Towns game jackpot\n"
				+ "3 - Set Lotto winning numbers\n"
				+ "4 - Check a Towns game winner\n"
				+ "5 - -----\n"
				+ "6 - print available actions.");
		
	}

	private int getPassword() {
		return password;
	}
	
	public boolean checkPassword(int pword) {
		if (pword == getPassword()) return true;
		return false;
	}
}
