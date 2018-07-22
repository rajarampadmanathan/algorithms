package random.programs;
import java.util.HashMap;

/**
 * 
 * @author rajaram
 *
 */

public class MatrixSpiralPrinting {

	public static void main(String[] args) {
		HashMap<Integer, String> hm=new HashMap<>();
		System.out.println(hm.put(1,"ABC"));
		System.out.println(hm.put(1,"CDE"));
		System.out.println(hm.get(1));
		// M x M Matrix.
		System.out.println("M is Even");
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		sprialPrint(matrix);

		// Another M x M Matrix.
		System.out.println("\nAnother Matrix with M Odd");
		int[][] matrix1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		sprialPrint(matrix1);

		// Another M x M Matrix.
		System.out.println("\nSingle Element");
		int[][] matrix11 = { { 0 } };
		sprialPrint(matrix11);

		// Another M x M Matrix.
		System.out.println("\nSingle Element");
		int[][] matrix12 = { { 0, 1 },{2, 3} };
		sprialPrint(matrix12);

		// Null Check
		System.out.println("\nNull Check");
		try {
			sprialPrint(null);
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}

		// Invalid Input
		System.out.println("\nNot a N x N matrix");
		int[][] matrix2 = { { 1, 2, 3, 4 }, { 4, 5, 6, 4 }, { 7, 8, 9, 4 } };
		try {
			sprialPrint(matrix2);
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}

	}

	static class a{
		 private int x;
	}
	private static void sprialPrint(int[][] matrix) {
		System.out.println(new a().x);
		if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length)
			throw new IllegalArgumentException("Arugments not matching the criteria");
		int r1 = 0, r2 = matrix.length - 1;
		while (r1 <= r2) {
			for (int i = r1; i <= r2; i++) {
				if (i == 0)
					System.out.print(matrix[r1][i]);
				else
					System.out.print("," + matrix[r1][i]);
			}
			for (int i = r1 + 1; i <= r2; i++) {
				System.out.print("," + matrix[i][r2]);
			}
			for (int i = r2 - 1; i >= r1; i--) {
				System.out.print("," + matrix[r2][i]);
			}
			for (int i = r2 - 1; i > r1; i--) {
				System.out.print("," + matrix[i][r1]);
			}

			r1++;
			r2--;
		}
		System.out.println();
	}

}
