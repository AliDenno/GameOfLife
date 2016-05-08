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
	public static int[][] glider_Gun_with_eater(int[][] grid)
	{
		//print a glider_Gun_with_eater on the initial grid
		//the Glider
		grid[row/2][col/2]=1;
		grid[row/2][col/2+1]=1;
		grid[row/2][col/2+2]=1;
		grid[row/2+1][col/2+2]=1;
		grid[row/2+2][col/2+1]=1;
		
		//the eater
		grid[32][61]=1;
		grid[32][62]=1;
		grid[31][61]=1;
		grid[30][62]=1;
		grid[30][63]=1;
		grid[30][64]=1;
		grid[29][64]=1;
		
		return grid;
	}
	
	/** a function that will count the number of alive cells and then write the number on a file 
	  * 
	  * @param step in which step were the cells counted
	  * @param The grid of data 
	  *
	*/
	public static int alive_cells_count(int step,int[][] grid){
		int aliveCount =0;
		PrintStream ps;
		try {	
		ps = new PrintStream(new FileOutputStream(new File("AliveCells.DATA"),true));
		for(int row=0;row < grid.length;row++){
			for(int col=0; col < grid[row].length;col++){
					aliveCount=(grid[row][col]==1) ? aliveCount+1: aliveCount;		
			}
		}
		ps.append("In Step: "+step+" There is "+aliveCount+" alive cells \n");
		ps.close();
		} catch (FileNotFoundException e) {
		System.out.println(e.getMessage());
		}
		return aliveCount;
	}

	
	/** a function that operate on every cell of the grid and calculate the next value
	  * 
	  * @param The Grid
	  * @param The Boolean Grid 
	  *
	*/
	public static boolean[][] operateGrid(int[][] grid,boolean[][] gridstats ){
		
		int A1=-1;int A2=-1; int A3=-1;int B1=-1;int B2=-1;int B3=-1;int C1=-1;int C2=-1;int C3=-1;
		for(int row=0;row < grid.length;row++){
			for(int col=0; col < grid[row].length;col++){
				//corner points
				if(row==0)
				{
					//left top corner
					if(col==0){
						A1=grid[grid.length-1][grid[row].length-1];
						A2=grid[grid.length-1][0];
						A3=grid[grid.length-1][1];
						B1=grid[row][grid[row].length-1];
						B2=grid[row][col];
						B3=grid[row][col+1];
						C1=grid[row+1][grid[row].length-1];
						C2=grid[row+1][col];
						C3=grid[row+1][col+1];
					}
					//right top corner
					else if(col==grid[row].length-1){
						A1=grid[grid.length-1][grid[row].length-2];
						A2=grid[grid.length-1][grid[row].length-1];
						A3=grid[grid.length-1][0];
						B1=grid[0][grid[row].length-2];
						B2=grid[0][grid[row].length-1];
						B3=grid[0][0];
						C1=grid[row+1][grid[row].length-2];
						C2=grid[row+1][grid[row].length-1];
						C3=grid[row+1][0];
					}
					// on first row
					else{
						A1=grid[grid.length-1][col-1];
						A2=grid[grid.length-1][col];
						A3=grid[grid.length-1][col+1];
						B1=grid[row][col-1];
						B2=grid[row][col];
						B3=grid[row][col+1];
						C1=grid[row+1][col-1];
						C2=grid[row+1][col];
						C3=grid[row+1][col+1];
					}
				}
					
				else if(row==grid.length-1)
				{
					//left bottom corner
					if(col==0)
					{
						A1=grid[grid.length-2][grid[row].length-1];
						A2=grid[grid.length-2][0];
						A3=grid[grid.length-2][1];
						B1=grid[grid.length-1][grid[row].length-1];
						B2=grid[grid.length-1][0];
						B3=grid[grid.length-1][1];
						C1=grid[0][grid[row].length-1];
						C2=grid[0][0];
						C3=grid[0][col+1];
					}
					//right bottom corner
					else if(col==grid[row].length-1)
					{
						A1=grid[grid.length-2][grid[row].length-2];
						A2=grid[grid.length-2][grid[row].length-1];
						A3=grid[grid.length-2][0];
						B1=grid[grid.length-1][grid[row].length-2];
						B2=grid[grid.length-1][grid[row].length-1];
						B3=grid[grid.length-1][0];
						C1=grid[0][grid[row].length-2];
						C2=grid[0][grid[row].length-1];
						C3=grid[0][0];
					}
					// on last row
					else{
						A1=grid[grid.length-2][col-1];
						A2=grid[grid.length-2][col];
						A3=grid[grid.length-2][col+1];
						B1=grid[grid.length-1][col-1];
						B2=grid[grid.length-1][col];
						B3=grid[grid.length-1][col+1];
						C1=grid[0][col-1];
						C2=grid[0][col];
						C3=grid[0][col+1];
					}
				}
				// on left column
				else if(col==0)
				{
					A1=grid[row-1][grid[row].length-1];
					A2=grid[row-1][col];
					A3=grid[row-1][col+1];
					B1=grid[row][grid[row].length-1];
					B2=grid[row][col];
					B3=grid[row][col+1];
					C1=grid[row+1][grid[row].length-1];
					C2=grid[row+1][col];
					C3=grid[row+1][col+1];
				}
				// on right column
				else if(col==grid[row].length-1)
				{
					A1=grid[row-1][col-1];
					A2=grid[row-1][col];
					A3=grid[row-1][0];
					B1=grid[row][col-1];
					B2=grid[row][col];
					B3=grid[row][0];
					C1=grid[row+1][col-1];
					C2=grid[row+1][col];
					C3=grid[row+1][0];
				}
				// in middle
				else{
					A1=grid[row-1][col-1];
					A2=grid[row-1][col];
					A3=grid[row-1][col+1];
					B1=grid[row][col-1];
					B2=grid[row][col];
					B3=grid[row][col+1];
					C1=grid[row+1][col-1];
					C2=grid[row+1][col];
					C3=grid[row+1][col+1];
				}
				gridstats[row][col]=assignStatus(A1,A2,A3,B1,B2,B3,C1,C2,C3);
			}
		}
		return gridstats;
	}
	
	/** a function that assign a boolean value to the cell that is under processing
	  * 
	  * @param The cell and its surrounding 
	  *
	*/
	public static boolean assignStatus(int A1,int A2,int A3,int B1,int B2,int B3,int C1,int C2,int C3)
	{
		boolean flag=false;
		int sum =  A1+ A2+ A3+ B1+ B3+ C1+ C2+ C3;
		
		if(B2==1){
			//Survival
			if (sum == 2 || sum == 3)
				flag=true;
			//Death
			else if (sum>3||sum<2)
				flag=false;
		}
		//Birth
		else if(B2==0 && sum==3){
			flag=true;
		}
		
		return flag;
	}
	
	/** a function that check the boolean grid and update the actual grid according to the values
	  * 
	  * @param The grid of data 
	  * @param The grid of boolean values 
	  *
	  *
	*/
	public static int[][] updateGrid(int[][] grid,boolean[][] gridstats)
	{
		for(int row=0;row < grid.length;row++){
			for(int col=0; col < grid[row].length;col++){
				if(gridstats[row][col]){
					grid[row][col]=1;
				}
				else{
					grid[row][col]=0;
				}
			}
		}
		return grid;
	}
	
	
	/** a function that takes the grid and write it to a file
	  * 
	  * @param The grid of data 
	  *
	*/
	public static void save_2DArray_tofile(int[][] grid,String filename)
	{
		PrintStream ps;
		try {
		ps = new PrintStream(new FileOutputStream(filename));
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
	
	//static int row=101;
	//static int col=82;
	static int row=82;
	static int col=101;
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
	
		
		
		// 2D 101 x 82 sized array
		int[][] Grid = new int[row][col];
		boolean [][] GridStats = new boolean [row][col];
		/////////////////////////////////////////////////
		/*
		Grid[0][0]=1;
		Grid[0][Grid[0].length-1]=	2;
		Grid[Grid.length-1][0]=3;
		Grid[Grid.length-1][Grid[0].length-1]=	4;
		save_2DArray_tofile(Grid);
		System.out.println("Wrote");
		System.exit(0);
		*/
		/////////////////////////////////////////////////
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
        case 5:  System.out.println("5.glider_Gun_with_eater launched");
        		glider_Gun_with_eater(Grid);
        		 break;

		}
		save_2DArray_tofile(Grid,"Grid.Data");
		int x=0;
		System.out.println("How many steps do you want the program to proceed:");
		int end=reader.nextInt();
		reader.close();
	    while(x<end){
		GridStats = operateGrid(Grid,GridStats);
		updateGrid(Grid,GridStats);
		save_2DArray_tofile(Grid,"UGrid.Data");
		x++;
		//System.out.println("Number of alive celles in step number "+ x +":"+ alive_cells_count(0,Grid));
		alive_cells_count(x,Grid);
	    }
	    System.out.println("done! the alive cells for each step are printed in AliveCells.DATA");
	}
	
}

