package com.andyb.lla.towns;

import com.andyb.lla.game.Game;

public class Town {
	
	private String town_name;
	private String county;

	private Game game;
	
	public Town(String town_name, String county) {
	
		this.town_name = town_name;
		this.county = county;
		this.game = new Game(0, town_name);
	}

	public String getTown_name() {
		return town_name;
	}
	
	public String getCounty() {
		return county;
	}
	
	public Game getGame() {
		return game;
	}
	
	public void displayGameDetails() {
		System.out.println("============== Game Details: ============");
		System.out.println("------> Town Name: " + town_name);
		System.out.println("------> Game Name: " + game.getGame_name());
		System.out.println("------> Game Value: " + game.getGame_value());
		System.out.println("------> Game plays: " + game.getNumber_of_plays());
		System.out.println("------> Winning Numbers: " + game.getWinning_numbers());
		System.out.println("------> Jackpot Value: " + game.getJackpot_value());
		System.out.println("------> Player list: "); game.printPlayerList();
		System.out.println("=========================================");
		
	}

}