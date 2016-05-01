import java.util.Arrays;
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
		//initialize the grid 101*82
		System.out.println("Fick Boris");
		//input methods (1->5)
		//print the choice on the grid
		System.out.println("Hi Sony");
		System.out.println("Hello from eclipseAli");
		
		
		// 2D 101 x 82 sized array
		int[][] Grid = new int[101][82];
		save_2DArray_tofile(Grid);
		
		System.out.println("HiFuck Face");
	}
	

}

