package random.programs;

import java.io.PrintStream;

public class SudokuSolverMine {

	static int count=0;
/*	static int[][] sudoku = new int[][] { { 8, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0,3, 6, 0, 0, 0, 0, 0 },
			{ 0, 7, 0, 0, 9, 0, 2, 0, 0 }, { 0,5, 0, 0, 0, 7, 0, 0, 0 }, { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
			{ 0, 0, 0, 1, 0, 0, 0, 3, 0 }, { 0, 0, 1, 0, 0, 0, 0, 6, 8 }, { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
			{ 0, 9, 0, 0, 0, 0, 4, 0, 0 } };
*/
	static int[][] sudoku = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		{ 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

	public static void main(String[] args) {

		   /**   0   1   2        3   4   5        6   7   8
		   * -------------------------------------------------
		 0 |    0   0   0   |    2   6   0   |    7   0   1   |  
		 1 |    6   8   0   |    0   7   0   |    0   9   0   |  
		 2 |    1   9   0   |    0   0   4   |    5   0   0   |  
		    -------------------------------------------------
		 3 |    8   2   0   |    1   0   0   |    0   4   0   |  
		 4 |    0   0   4   |    6   0   2   |    9   0   0   |  
		 5 |    0   5   0   |    0   0   3   |    0   2   8   |  
		    -------------------------------------------------
		 6 |    0   0   9   |    3   0   0   |    0   7   4   |  
		 7 |    0   4   0   |    0   5   0   |    0   3   6   |  
		 8 |    7   0   3   |    0   1   8   |    0   0   0   |  
		    -------------------------------------------------*/
		   printSudoku();
		   solveSudoku();
		   System.out.println("Solution.....");
		   printSudoku();
		   System.out.println(count);
		   
	}

	private static boolean solveSudoku() {
		count++;
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(sudoku[i][j]== 0) {
					for(int x=1;x<=9;x++) {
						//System.out.println("i:"+i+"  j:"+j+"  X:"+x +"  is Allowed:"+isAllowed(i, j, x));
						if(isAllowed(i, j, x)) {
							sudoku[i][j]=x;
							if(solveSudoku()) {
								return true;
							}else {
								sudoku[i][j]=0;
								
							}
						}
					}
					return false;
				}
			}
		}
		return true;
		
	}

	public static boolean isAllowed(int rowId,int columnId,int value) {
		return (isAllowedInRow(rowId,value) && isAllowedInColumn(columnId,value)&& isAllowedInBox(rowId,columnId,value));
	}
	private static boolean isAllowedInBox(int rowId, int columnId, int value) {
		int startRow=(rowId/3)*3;
		int startColumn=(columnId/3)*3;
		for(int i=startRow;i<startRow+3;i++) {
			for(int j=startColumn;j<startColumn+3;j++) {
				if(sudoku[i][j]==value) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isAllowedInColumn(int columnId, int value) {
		for(int i=0;i<9;i++) {
			if(sudoku[i][columnId] == value) {
				return false;
			}
		}
		return true;
	}

	private static boolean isAllowedInRow(int rowId, int value) {
		for(int i=0;i<9;i++) {
			if(sudoku[rowId][i] == value) {
				return false;
			}
		}
		return true;
	}

	public static void printSudoku() {
		for (int i = 0; i < sudoku.length; i++) {
			if (i % 3 == 0) {
				System.out.println("   -------------------------------------------------");
			}
			for (int j = 0; j < sudoku[i].length; j++) {
				if (j % 3 == 0) {
					System.out.print("  |  ");
				}
				System.out.print("  " + sudoku[i][j] + " ");
			}
			System.out.print("  |  ");
			System.out.println();

		}
		System.out.println("   -------------------------------------------------");

	}
}