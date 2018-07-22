package algorithms;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		int[] arr = { 1, 10, 16, 19, 3, 5 };
		buildHeap(arr);
		Arrays.stream(arr).forEach(System.out::println);
		heapSort(arr);
		Arrays.stream(arr).forEach(System.out::println);
	}

	private static void heapSort(int[] arr) {
		for (int i = arr.length - 1; i > 0; i--) {
			swap(arr, 0, i);
			heapify(arr, 0, i-1);
		}
	}

	private static void buildHeap(int[] arr) {
		int nLIndex = (arr.length - 1) / 2;
		for (int i = nLIndex; i >= 0; i--) {
			heapify(arr, i, arr.length - 1);
		}
	}

	private static void heapify(int[] arr, int i, int len) {
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		int max = i;
		if (l <= len && arr[l] < arr[i])
			max = l;
		if (r <= len && arr[r] < arr[max])
			max = r;
		if (max != i) {
			swap(arr, i, max);
			heapify(arr, max, len);
		}
	}

	private static void swap(int[] arr, int i, int max) {
		arr[i] += arr[max];
		arr[max] = arr[i] - arr[max];
		arr[i] -= arr[max];
	}
}
