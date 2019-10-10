package com.andyb.lla.play;

import java.util.ArrayList;

public class Player {

	private String playerName;
	private int playerAge;
	private String playerAddress;
	private ArrayList<Integer> playerChoice;
	private int playedValue = 0;
	
	
	public Player(String playerName, int playerAge, String playerAddress, ArrayList<Integer> playerChoice) {
		this.playerName = playerName;
		this.playerAge = playerAge;
		this.playerAddress = playerAddress;
		this.playerChoice = playerChoice;
		setPlayerChoice(playerChoice);
	}

	public String getPlayerName() {
		return playerName;
	}

	public int getPlayerAge() {
		return playerAge;
	}

	public String getPlayerAddress() {
		return playerAddress;
	}

	public ArrayList<Integer> getPlayerChoice() {
		return playerChoice;
	}

	public int getPlayedValue() {
		return playedValue;
	}

	public void setPlayerChoice(ArrayList<Integer> playerChoice) {
		this.playerChoice = playerChoice;
		
		if (playerChoice.size()>8) {
			setPlayedValue(5);
		}
		else if (playerChoice.size()>4) {
			setPlayedValue(4);
		}
		else if (playerChoice.size() == 4) {
			setPlayedValue(2);
		}
	}

	private void setPlayedValue(int playedValue) {
		this.playedValue = playedValue;
	}
	
	
}
