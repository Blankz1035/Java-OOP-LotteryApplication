package com.andyb.lla.towns;

import java.util.ArrayList;

public class TownList {

	private ArrayList<Town> TownList;

	public TownList() {
		this.TownList =  new ArrayList<Town>();
	}

	public ArrayList<Town> getTownList() {
		return TownList;
	}

	private void addToTownList (String townName, String County){

		if (findTown(townName)) {
			System.out.println("Town is already in the List!\nAddition cancelled.");
			return;
		}
		TownList.add(new Town(townName, County));
		System.out.println("Town '" + townName + "' has been added.");
	}

	public void addToList(String townName, String County) {
		addToTownList(townName, County);
	}
	
	private boolean findTown(String townName) {
		for (int i= 0; i< TownList.size(); i++) {
			if(TownList.get(i).getTown_name().equalsIgnoreCase(townName)) {
				//System.out.println("Duplicate Town has been found!");
				return true;
			}
		}
		return false;
	}
	
	public Town findTownPosition (String townName) {
		for (int i= 0; i< TownList.size(); i++) {
			if(TownList.get(i).getTown_name().equalsIgnoreCase(townName)) {
				return TownList.get(i);
			}
		}
		return null;
	}
	
	public void DisplayTownGameDetails (String townName) {
		if (findTown(townName)) {
			Town t = findTownPosition(townName);
			System.out.println("\n------> Town Name: " + townName + "  County: " + t.getCounty());
			t.displayGameDetails();
		}
		else {
			System.out.println("Town was not found!\nAction cancelled.");
			return;
		}
	}
}
