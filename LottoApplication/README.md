# Java-OOP-LotteryApplication

A Java based console application that I have created using an OOP approach to showcase the articles of the game Lottery.  

The design of this application was inspired by learning. I wanted to try to replicate different aspects of a real life scenario and a Lottery application carries many different features and functionality that can be translated into software requirements.

<hr/>

## Application Features
The application contains two key menu functionalities:
1. Main Menu (designed for use of end users).
2. Admin Menu (designed for use of Administrators - requires password entry).

### Main Menu
```java
System.out.println("0 - to quit\n"
				+ "1 - Administrator Options\n"
				+ "2 - Enter into a Game\n"
				+ "3 - Display List of Towns\n"
				+ "4 - Display List of Towns, Games and Jackpots\n"
				+ "5 - Display specific Town's Game Details\n"
				+ "6 - Add a new town\n"
				+ "7 - print available actions.");
```

### Administrator Menu
```java
System.out.println("0 - to quit\n"
				+ "1 - Set a Towns game name\n"
				+ "2 - Set a Towns game jackpot\n"
				+ "3 - Set Lotto winning numbers\n"
				+ "4 - Check a Towns game winner\n"
				+ "5 - -----\n"
				+ "6 - print available actions.");
```

## Getting Started

To get started with this application, you need to clone the repo to your IDE workspace. After this you can simple open in your IDE or run using the console window on your computer using the reserved keyword Java.

In my opinion, it would be easiest to import this project into your IDE to view the output.

### Prerequisites

```
1. IDE (Eclipse etc).
2. JDK / JRE installed & configured on your computer.
```

## Detailed application overview
This lottery application has been created in a way that a lottery game cannot be run without a linked Town object!

Here is a brief overview of the application architecture:
<br/><b>Classes:</b>
1. PlayGame <- Main method.
2. Player
3. Town
4. Townlist
5. Game
6. AdministratorActions

Each class contain encapsulated methods and processes to handle the application flow.

<b>How does the flow work?</b>
```
1. Townlist(contains list of towns to play).
2. Town (contains details of a specific town and a linked Game).
3. Game (contains a list of game details and a list of players).
4. Player (contains details about a specific player and their played details).
```

### Example Input
As mentioned above, there must be a town to play a lottery game. If there are no towns, then the options available to the end user are limited.

```
Enter a selection: 6 (add details).
Enter a selection: 3 (Displays list of created towns).
Enter a selection: 4 (Displays list of towns and games).
Enter a selection: 5 (Display game details from a town).
Enter a selection: 2 (Enter player details and numbers to pick).
Enter a selection: 1 (Now enter password to get into Admin mode - Hint -> You have to find this yourself..)

Finally -> Make some admin changes and exit this menu. You can then check out the game details again to view changes for end users!
```


## To Do's / Enhancements
I have some enhancements and code improvements to implement into this project. These will be implemented in the coming future.

Examples of implementations:
```
1. Handle Scanner.nextInt() with validation (hasNextInt()).
2. Implement I/O for this project - upload towns via fileInputStream / save to file using OutputStream.
3. Implement Database handler class.
```

## Thanks for review!

