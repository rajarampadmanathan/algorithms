package random.programs;

public class SortedArrayMedian {
	
	public static double medianOfSortedArray(int[] A, int[] B) {
		if (A.length > B.length) {
			return medianOfSortedArray(B, A);
		}
		int lengthA = A.length;
		int lengthB = B.length;
		int length = (lengthA + lengthB + 1) / 2;
		int low = 0, high = lengthA;
		boolean even = (lengthA + lengthB) % 2 == 0 ? true : false;
		System.out.println(even + "" + length);
		while (low <= high) {
			int midA = (low + high) / 2;
			int midB = length - midA;
			int aLeft = (midA == 0) ? Integer.MIN_VALUE : A[midA - 1];
			int aRight = (midA == A.length) ? Integer.MAX_VALUE : A[midA];
			int bLeft = (midB == 0) ? Integer.MIN_VALUE : B[midB - 1];
			int bRight = (midB == A.length) ? Integer.MAX_VALUE : B[midB];
			if (aLeft <= bRight && aRight >= bLeft) {
				if (even) {
					System.out.println((Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2.0f);
				} else {
					System.out.println(Math.max(aLeft, bLeft));
				}
				break;
			} else if (aLeft > bRight) {
				high = midA - 1;
			} else {
				low = midA + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		medianOfSortedArray(new int[] { 3, 7, 9, 15, 18, 21, 25 }, new int[] { 4, 6, 8, 10, 11, 18 });
		medianOfSortedArray(new int[] { 1, 3, 8, 9, 15 }, new int[] { 7, 11, 18, 19, 21, 25 });
		medianOfSortedArray(new int[] { 23, 26, 31, 35 }, new int[] { 3, 5, 7, 9, 11, 16 });
	}
}
