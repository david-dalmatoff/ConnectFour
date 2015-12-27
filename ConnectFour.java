import java.util.Scanner;

public class Main {
	
	public static String[][] makeBoard()
	{
		String[][] a = new String[7][15];
		
		for (int i=0; i<a.length; i++)
		{
			for (int j=0; j<a[i].length; j++)
			{
				if (j% 2 == 0) a[i][j] = "|";
				else a[i][j] = " ";
				
				if (i==6) a[i][j] = "_";
			}
		}
		return a;
	}
	
	
	
	
	public static void showBoard(String[][] a)
	{
		for (int i=0; i<a.length; i++)
		{
			for (int j = 0; j<a[i].length; j++)
			{
				System.out.print (a[i][j]);
			}
			System.out.println();
		}
	}
	
	
	
	
	public static void redDrop(String[][] a)
	{
		System.out.println("Drop a red disk at column (0-6): ");
		Scanner myScanner = new Scanner (System.in);
		
		int columns = 2*myScanner.nextInt()+1;
		
		for (int i = 5; i>=0; i--)
		{
			if (a[i][columns] == " ")
			{
				a[i][columns] = "R";
				break;
			}
		}
	}
	
	public static void yellowDrop(String[][] a)
	{
		System.out.println("Drop a yellow disk at column (0-6): ");
		Scanner myScanner = new Scanner (System.in);
		
		int columns = 2*myScanner.nextInt()+1;
		
		for (int i = 5; i>=0; i--)
		{
			if (a[i][columns] == " ")
			{
				a[i][columns] = "Y";
				break;
			}
		}
	}
	
	public static String result(String[][] a)
	{
		// horizontal win
		for (int i = 0; i<6; i++)
		{
			for (int j = 0; j<7; j+=2)
			{
				if ((a[i][j+1] != " ")
						&& (a[i][j+3] != " ")
						&& (a[i][j+5] != " ")
						&& (a[i][j+7] != " ")
						&& ((a[i][j+1] == a[i][j+3])
								&& (a[i][j+3] == a[i][j+5])
								&& (a[i][j+5] == a[i][j+7])))
					return a[i][j+1];
			}
		}
		
		// vertical win
		for (int i = 1; i<15; i +=2)
		{
			for (int j = 0; j<3; j++)
			{
				if((a[j][i] != " ")
						&& (a[j+1][i] != " ")
						&& (a[j+2][i] != " ")
						&& (a[j+3][i] != " ")
						&& ((a[j][i] == a[j+1][i])
								&& (a[j+1][i] == a[j+2][i])
								&& (a[j+2][i] == a[j+3][i])))
					return a[j][i];
			}
		}
		
		// diagonal wins
		for (int i = 0; i<3; i++)
		{
			for (int j = 1; j<9; j+=2)
			{
				if ((a[i][j] != " ")
						&& (a[i+1][j+2] != " ")
						&& (a[i+2][j+4] != " ")
						&& (a[i+3][j+6] != " ")
						&& ((a[i][j] == a[i+1][j+2])
								&& (a[i+1][j+2] == a[i+2][j+4])
								&& (a[i+2][j+4] == a[i+3][j+6])))
					return a[i][j];  

			}
		}
		
		for (int i = 0; i<3; i++)
		{
			for (int j=7; j<15; j+=2)
			{
				if ((a[i][j] != " ")
					&& (a[i+1][j-2] != " ")
					&& (a[i+2][j-4] != " ")
					&& (a[i+3][j-6] != " ")
					&& ((a[i][j] == a[i+1][j-2])
							&& (a[i+1][j-2] == a[i+2][j-4])
							&& (a[i+2][j-4] == a[i+3][j-6])))
					return a[i][j];

			}
		}
		return null;
	}
	
	
	public static void main (String[] args)
	{
		System.out.println("David Dalmatoff");
		System.out.println(" ");
		String [][] a = makeBoard();
		boolean loop = true;
		int count = 0;
		showBoard(a);
		while(loop)
		{
			if ( count% 2 == 0) redDrop(a);
			else yellowDrop(a);
			count++;
			showBoard(a);
			if (result(a) != null)
			{
				if (result(a) == "R")
					System.out.println("Red player wins!");
				else if (result(a) == "Y")
					System.out.println("Yellow player wins!");
				loop = false;
			}
		}
	}
}