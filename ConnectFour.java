/* Purpose Statement	: 
 * Author		: David Dalmatoff
 * File	Name	: ConnectFour.java
 */


import java.util.Scanner; 							//"a simple text scanner which can parse primitive types and strings"

public class ConnectFour {
	
	//method to allocate memory for the Connect Four board
	public static String[][] makeBoard()
	{
		String[][] a = new String[7][15];			//declares an array with dimensions 7x15. The board is technically 15 columns because of the '|' character being printed for spacing and aesthetics
		
		for (int i=0; i < a.length; i++)			//loop cycles through rows
		{
			for (int j=0; j < a[i].length; j++)		//loop cycles through columns
			{
				if (j% 2 == 0) a[i][j] = "|";		//prints vertical line to separate each column
				else a[i][j] = " ";					//prints spacing for aesthetics
				
				if (i==6) a[i][j] = "_";			//prints horizontal line to separate each row
			}
		}
		return a;									//returns the board called 'a'
	}
	
	//method to print the board via the output console
	public static void showBoard(String[][] a)
	{
		for (int i=0; i < a.length; i++)			//loop cycles through rows
		{
			for (int j = 0; j < a[i].length; j++)	//loop cycles through columns
			{
				System.out.print (a[i][j]);			//prints the board and respective markers that are "in" the board
			}
			System.out.println();					//prints a line for aesthetic purposes
		}
	}
	
	//method to handle Red team's moves
	public static void redDrop(String[][] a)
	{
		System.out.println("Drop a red disk at column (0-6): ");		//prompts the user to input a number from 0 to 6, these numbers are the column numbers
		Scanner myScanner = new Scanner (System.in);					//myScanner reads in from the keyboard (user's input)
		
		int columns = 2 * myScanner.nextInt() + 1;						//algorithm to calculate which column to drop in
		
		for (int i = 5; i >= 0; i--)			
		{
			if (a[i][columns] == " ")			//if the desired spot is blank..
			{
				a[i][columns] = "R";			//Red team is represented by 'R'; these moves will yield R's
				break;							//breaks the loop
			}
		}
	}
	
	//method to handle Yellow team's moves.
	public static void yellowDrop(String[][] a)
	{
		System.out.println("Drop a yellow disk at column (0-6): ");		//prompts the user to input a number from 0 to 6, these numbers are the column numbers
		Scanner myScanner = new Scanner (System.in);					//myScanner reads in from the keyboard (user's input)
		
		int columns = 2 * myScanner.nextInt() + 1;						//algorithm to calculate which column to drop in
		
		for (int i = 5; i>=0; i--)
		{
			if (a[i][columns] == " ")			//if the desired spot is blank..
			{
				a[i][columns] = "Y";			//Yellow team is represented by 'Y'; these moves will yield Y's
				break;							//breaks the loop
			}
		}
	}
	
	//function to declare a winner. Winner may be determined by 4 markers of the same type in a row. The 4 consecutive markers can be horizontal, vertical, or diagonal. 
	public static String result(String[][] a)
	{
		//loop to handle a horizontal win
		for (int i = 0; i < 6; i++)				//loop cycles through the rows (6 rows total, rows: 0 to 5)
		{
			for (int j = 0; j < 7; j+=2)		//loop cycles through the columns (7 columns total, columns: 0 to 6)
			{
				if ((a[i][j+1] != " ")			//if these particular spots are NOT blank, in addition to the following conditions..
						&& (a[i][j+3] != " ")	//
						&& (a[i][j+5] != " ")	//
						&& (a[i][j+7] != " ")	//
						&& ((a[i][j+1] == a[i][j+3])			//if the spots are equal to each other (all R's or all Y's)
								&& (a[i][j+3] == a[i][j+5])		//
								&& (a[i][j+5] == a[i][j+7])))	//
					return a[i][j+1];
			}
		}
		
		//loop to handle a vertical win
		for (int i = 1; i < 15; i +=2)		//cycles around the horizontal or vertical borders
		{
			for (int j = 0; j < 3; j++)
			{
				if((a[j][i] != " ")				//if these particular spots are NOT blank, in addition to the following conditions..
						&& (a[j+1][i] != " ")	//
						&& (a[j+2][i] != " ")	//
						&& (a[j+3][i] != " ")	//
						&& ((a[j][i] == a[j+1][i])				//if the spots are equal to each other (all R's or all Y's)
								&& (a[j+1][i] == a[j+2][i])		//
								&& (a[j+2][i] == a[j+3][i])))	//
					return a[j][i];
			}
		}
		
		//loop to handle a diagonal wins
		for (int i = 0; i < 3; i++)
		{
			for (int j = 1; j < 9; j+=2)
			{
				if ((a[i][j] != " ")				//if these particular spots are NOT blank, in addition to the following conditions..
						&& (a[i+1][j+2] != " ")		//
						&& (a[i+2][j+4] != " ")		//
						&& (a[i+3][j+6] != " ")		//
						&& ((a[i][j] == a[i+1][j+2])				//if the spots are equal to each other (all R's or all Y's)	
								&& (a[i+1][j+2] == a[i+2][j+4])		//
								&& (a[i+2][j+4] == a[i+3][j+6])))	//
					return a[i][j];  
			}
		}
		
		for (int i = 0; i < 3; i++)
		{
			for (int j=7; j < 15; j+=2)
			{
				if ((a[i][j] != " ")				//if these particular spots are NOT blank, in addition to the following conditions..
					&& (a[i+1][j-2] != " ")			//
					&& (a[i+2][j-4] != " ")			//
					&& (a[i+3][j-6] != " ")			//
					&& ((a[i][j] == a[i+1][j-2])				//if the spots are equal to each other (all R's or all Y's)	
							&& (a[i+1][j-2] == a[i+2][j-4])		//
							&& (a[i+2][j-4] == a[i+3][j-6])))	//
					return a[i][j];
			}
		}
		return null;								//returns null, meaning a player has won
	}
	
	
	public static void main (String[] args)
	{
		System.out.println("David Dalmatoff");
		System.out.println(" ");
		String [][] defaultBoard = makeBoard();				//declare a two dimensional array and calls the function the make the board
		boolean loop = true;								//declare and initialize a boolean that will allow us to loop through until a player wins
		int count = 0;										//declare and initialize an int variable to 0. "count" allows the program to cycle through each player's turn
		showBoard(defaultBoard);							//calls method to print the board
		while(loop)											//while loop is true (loop switches to false after a winner has been declared)
		{
			if (count% 2 == 0) redDrop(defaultBoard);		//if the count of turns is even, red makes a move
			else yellowDrop(defaultBoard);					//else, if the count of turns is odd, yellow makes a move
			count++;										//increments count, the number of turns, by 1 (after red OR yellow has gone)
			showBoard(defaultBoard);						//prints the board after the move has been made
			if (result(defaultBoard) != null)				//if there is a winner (allows us to print the winning statement and halt the program)
			{
				if (result(defaultBoard) == "R")			//if Red team has won, system will print winning statement
					System.out.println("Red player wins!");
				else if (result(defaultBoard) == "Y")		//if Yellow team has won, system will print winning statement
					System.out.println("Yellow player wins!");
				loop = false;								//most importantly, breaks the loop if a winner has been declared.
			}
		}
	}
}