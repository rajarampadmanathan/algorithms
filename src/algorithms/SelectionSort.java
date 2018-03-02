package algorithms;

import java.util.Arrays;

public class SelectionSort {

	static int[] numbers = new int[] { 4, 9, 7, 1, 3, 6, 5 };

	public static void main(String[] args) {
		System.out.println(5/2);

		for (int j = 0; j < numbers.length-1; j++) {

			int min = numbers[j];
			int minIndex = 0;
			int temp;
			for (int i = j+1; i < numbers.length; i++) {
				if (min > numbers[i]) {
					min = numbers[i];
					minIndex = i;
				}
			}
			temp = numbers[j];
			numbers[j] = min;
			numbers[minIndex] = temp;
		}

	System.out.println(Arrays.toString(numbers));
	}
}
