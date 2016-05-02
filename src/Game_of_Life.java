import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;
public class Game_of_Life {
	
	public static int[][] blinker(int[][] grid)
	{
		//print a blinker on the initial grid
		grid[row/2][col/2]=1;
		grid[row/2+1][col/2]=1;
		grid[row/2+2][col/2]=1;
		return grid;
	}
	public static int[][] glider(int[][] grid)
	{
		//print a glider on the initial grid	
		grid[row/2][col/2]=1;
		grid[row/2][col/2+1]=1;
		grid[row/2][col/2+2]=1;
		grid[row/2+1][col/2+2]=1;
		grid[row/2+2][col/2+1]=1;
		return grid;
	}
	public static int[][] r_pentomino(int[][] grid)
	{
		//print a r_pentomino on the initial grid
		grid[row/2][row/2]=1;
		grid[row/2][row/2+1]=1;
		grid[row/2+1][row/2]=1;
		grid[row/2+1][row/2-1]=1;
		grid[row/2+2][row/2]=1;
		return grid;
	}
	public static int[][] glider_Gun(int[][] grid)
	{
		//print a glider_Gun on the initial grid
		grid[5][1]=1;
		grid[5][2]=1;
		grid[6][1]=1;
		grid[6][2]=1;
		
		grid[3][35]=1;
		grid[3][36]=1;
		grid[4][35]=1;
		grid[4][36]=1;
		
		grid[3][21]=1;
		grid[3][22]=1;
		grid[4][21]=1;
		grid[4][22]=1;
		grid[5][21]=1;
		grid[5][22]=1;
		
		grid[2][23]=1;
		grid[6][23]=1;
		
		grid[1][25]=1;
		grid[2][25]=1;
		grid[6][25]=1;
		grid[7][25]=1;
		
		grid[5][11]=1;
		grid[6][11]=1;
		grid[7][11]=1;
		grid[4][12]=1;
		grid[8][12]=1;
		
		grid[3][13]=1;
		grid[9][13]=1;
		grid[3][14]=1;
		grid[9][14]=1;
		
		grid[6][15]=1;
		grid[4][16]=1;
		grid[8][16]=1;
		grid[6][18]=1;
		grid[5][17]=1;
		grid[6][17]=1;
		grid[7][17]=1;
		return grid;
	}
	public static int[][] your_own_Choice(int[][] grid)
	{
		//print a your_own_Choice on the initial grid
		return grid;
	}

	public static int alive_cells_count(int step,int[][] grid){
		int aliveCount =0;
		PrintStream ps;
		try {
		ps = new PrintStream(new FileOutputStream("AliveCells.DATA"));
		for(int row=0;row < grid.length;row++){
			for(int col=0; col < grid[row].length;col++){
					aliveCount=(grid[row][col]==1) ? aliveCount+1: aliveCount;		
			}
		}
		ps.println("In Step: "+step+" There is "+aliveCount+" alive cells");
		ps.close();
		} catch (FileNotFoundException e) {
		System.out.println(e.getMessage());
		}
		return aliveCount;
	}
	public static void save_2DArray_tofile(int[][] grid)
	{
		PrintStream ps;
		try {
		ps = new PrintStream(new FileOutputStream("Grid.DATA"));
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
	static int row=101;
	static int col=82;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter a number: ");
		int choice=0;
	
		try
		{
			choice = reader.nextInt(); // Scans the next token of the input as an int.
		}
		catch(InputMismatchException exception)
		{
		  System.out.println("This is not an integer.");
		}
	
		reader.close();
		
		// 2D 101 x 82 sized array
		int[][] Grid = new int[row][col];
	
		switch (choice) {
		case 0:  break;
        case 1:  System.out.println("1.blinker launched");
        	     blinker(Grid);
                 break;
        case 2:  System.out.println("2.glider launched"); 
        		 glider(Grid);
        		 break;
        case 3:  System.out.println("3.r_pentomino launched");
        	     r_pentomino(Grid);
        		 break;
        case 4:  System.out.println("4.glider_Gun launched");
			     glider_Gun(Grid);
				 break;
        case 5:  System.out.println("5.your_own_Choice launched");
        		 your_own_Choice(Grid);
        		 break;

		}
		save_2DArray_tofile(Grid);
		System.out.println("NUMMUM: "+ alive_cells_count(0,Grid) );
	}
}

