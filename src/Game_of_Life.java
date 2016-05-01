import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
public class Game_of_Life {
	
	public static int[][] blinker(int[][] grid)
	{
		//print a blinker on the initial grid
		return grid;
	}
	public static int[][] glider(int[][] grid)
	{
		//print a glider on the initial grid
		return grid;
	}
	public static int[][] r_pentomino(int[][] grid)
	{
		//print a r_pentomino on the initial grid
		return grid;
	}
	public static int[][] your_own_Choice(int[][] grid)
	{
		//print a your_own_Choice on the initial grid
		return grid;
	}
	public static int[][] glider_Gun(int[][] grid)
	{
		//print a glider_Gun on the initial grid
		return grid;
	}
	
	public static void save_2DArray_tofile(int[][] grid)
	{
		PrintStream ps;
		try {
		ps = new PrintStream(new FileOutputStream("NUMBER.DATA"));
		for(int row=0;row < grid.length;row++){
			for(int col=0; col < grid[row].length;col++){
			String s = Integer.toString(grid[row][col]);
			ps.print(s+' ');
			}
			ps.println("");
		}
		ps.close();
		} catch (FileNotFoundException e) {
		System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter a number: ");
		int choice = reader.nextInt(); // Scans the next token of the input as an int.

		
		
		// 2D 101 x 82 sized array
		int[][] Grid = new int[101][82];
		save_2DArray_tofile(Grid);
		switch (choice) {
        case 1:  glider_Gun(Grid);
                 break;
        case 2:  glider_Gun(Grid);
        		 break;
		}
	}
}

