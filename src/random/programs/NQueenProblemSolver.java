package random.programs;

public class NQueenProblemSolver {

	static int[][] chessBoard;
	static int counter;

	public static void main(String[] args) {
		
		// chessBoard[0][0] = 1;
		// System.out.println(isAllowedDiagonal(1, 2));
		chessBoard = new int[6][6];
		printBoard();
		for(int i=0;i<6;i++) {
			chessBoard = new int[6][6];
			solve6Queen(6,i);
			System.out.println("------------------------Solution :"+i+"--------------------------");
			System.out.println("-----------------------------------------------------------------");
		printBoard();
		}
		
		System.out.println("Total iterations:" + counter);
	}

	private static boolean solve6Queen(int n,int start) {
		counter++;
		while (n > 0) {
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 6; j++) {
					if (chessBoard[i][j] == 0 && isAllowed(i, j) && (i>0 || j >=start)) {
						chessBoard[i][j] = 1;
						if (solve6Queen(n - 1,start)) {
							return true;
						} else {
							chessBoard[i][j] = 0;
						}
					}
				}
			}
			return false;
		}
		return true;

	}

	private static boolean isAllowed(int rowId, int columnId) {
		return (isAllowedHorizontal(rowId) && isAllowedVertical(columnId) && isAllowedDiagonal(rowId, columnId));
	}

	private static boolean isAllowedHorizontal(int rowId) {
		for (int i = 0; i < 6; i++) {
			if (chessBoard[rowId][i] == 1) {
				return false;
			}
		}
		return true;
	}

	private static boolean isAllowedVertical(int columnId) {
		for (int i = 0; i < 6; i++) {
			if (chessBoard[i][columnId] == 1) {
				return false;
			}
		}
		return true;
	}

	private static boolean isAllowedDiagonal(int rowId, int columnId) {
		/**
		 * Checks Diagonal right downwards.
		 * 
		 */
		for (int i = rowId, j = columnId; j < 6 && i < 6; j++, i++) {
			if (chessBoard[i][j] == 1) {
				return false;
			}
		}
		/**
		 * Checks Diagonal left upwards.
		 * 
		 */
		for (int i = rowId, j = columnId; i >= 0 && j >= 0; i--, j--) {
			if (chessBoard[i][j] == 1) {
				return false;
			}
		}
		/**
		 * Checks Diagonal left downwards.
		 * 
		 */
		for (int i = rowId, j = columnId; i < 6 && j >= 0; i++, j--) {
			if (chessBoard[i][j] == 1) {
				return false;
			}
		}
		/**
		 * Checks Diagonal right upwards.
		 * 
		 */
		for (int i = rowId, j = columnId; i >= 0 && j < 6; i--, j++) {
			if (chessBoard[i][j] == 1) {
				return false;
			}
		}
		return true;
	}

	private static void printBoard() {
		System.out.println("-------------------------------------------------");
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print("|  " + chessBoard[i][j] + "  ");
			}
			System.out.println("|\n-------------------------------------------------");
		}
	}
}
