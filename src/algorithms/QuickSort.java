package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

public class QuickSort {

	static int[] numbers = new int[] { 4, 9, 7, 8, 6, 2, 3, 1, 5 };
	//static Integer[] numbers = new Integer[] { 2,3,1, 5 };

	public static void main(String[] args) {

		ArrayList<Integer> al=new ArrayList<>();
		//new QuickSort().quickSort(numbers,0, numbers.length - 1);
		String s;
				System.out.println((100/100));

	}

	private  Integer[] quickSort( Integer[] numbers, int min, int max) {

		System.out.println("Array:"+Arrays.toString(numbers));
		System.out.println("Min:"+min);
		System.out.println("Max:"+max);
		if(min <max) {
			int pivot = partition( numbers,min, max);
			System.out.println("Array:"+Arrays.toString(numbers));
			System.out.println("Pivot:"+pivot);
			quickSort( numbers,min, pivot - 1);
			System.out.println("After partition Sort part 2");
			System.out.println("Min:"+min);
			System.out.println("Max:"+max);
			System.out.println("pivot:"+pivot);
			quickSort( numbers, pivot + 1, max);
		}
		return numbers;

	}

	private int partition( Integer[] numbers, int min, int max) {
		int pivot = numbers[max];
		int j = min;
		for (int i = min; i < max; i++) {
			System.out.println("Loop Index:"+i);
			if (numbers[i] <= pivot) {
				swap(numbers,i, j);
				j++;
			}
		}
		if(numbers[j] >numbers[max]) {
			System.out.println("Pivot swap");
		swap( numbers,j, max);
		}
		return j;

	}

	private static Integer[] swap(Integer[] numbers, int min, int max) {
		System.out.println("Inside Swap:"+Arrays.toString(numbers));
		System.out.println("Inside Swap:"+min+"::Max:"+max);
		int temp = numbers[min];
		numbers[min] = numbers[max];
		numbers[max] = temp;

		return numbers;
	}
}
