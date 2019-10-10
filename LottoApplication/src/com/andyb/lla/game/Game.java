package com.andyb.lla.game;

import java.util.ArrayList;
import java.util.Collections;

import com.andyb.lla.play.Player;

public class Game {

	private int jackpot_value;
	private int number_of_plays = 0;
	private int game_value = 0;
	private String game_name;
	@SuppressWarnings("unused")
	private String town_name;
	
	private ArrayList<Integer> winning_numbers;
	private ArrayList<Player> playerList;

	
	public Game(int jackpot_value, String town_name) {
		this.jackpot_value = 0;
		this.town_name = town_name;
		this.game_value = 0;
		this.number_of_plays = 0;
		this.winning_numbers = GenerateWinningNumbers();
		this.playerList = new ArrayList<Player>();
	}

	public int getJackpot_value() {
		return jackpot_value;
	}

	public ArrayList<Integer> getWinning_numbers() {
		return winning_numbers;
	}

	public ArrayList<Player> getPlayerList() {
		return playerList;
	}

	public int getNumber_of_plays() {
		return number_of_plays;
	}

	public int getGame_value() {
		return game_value;
	}

	public String getGame_name() {
		return game_name;
	}

	public void setJackpot_value(int jackpot_value) {
		this.jackpot_value = jackpot_value;
	}

	public void setWinning_numbers(ArrayList<Integer> winning_numbers) {
		this.winning_numbers = winning_numbers;
	}

	public void setNumber_of_plays(int number_of_plays) {
		this.number_of_plays = number_of_plays;
	}

	public void setGame_value(int game_value) {
		this.game_value = game_value;
	}
	
	public void setGameName(String gameName) {
		this.game_name = gameName;
	}
	
	private void addToPlayerList (Player p) {
		this.playerList.add(p);
	}
	
	public void addPlayerDetails (Player p) {
		this.game_value += p.getPlayedValue();
		this.number_of_plays +=1;
		addToPlayerList(p);
	}
	
	public ArrayList<Integer> GenerateWinningNumbers (){
		// When the object is created, we want to generate an arraylist of 4 random numbers for the Lotto
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i = 0; i < 4; i++)
			temp.add((int)((Math.random()* 50) +1));

		//Sort the winning numbers generated.
		Collections.sort(temp);
		return temp;
	}
	
	public void printPlayerList() {
		for (Player player : playerList) {
			System.out.println("| Player Name: " + player.getPlayerName() + 
					" | Address: " + player.getPlayerAddress().toString() +
					" | Player Choice " + player.getPlayerChoice());
		}
	}
	
}
