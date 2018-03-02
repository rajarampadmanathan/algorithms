package algorithms;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeSort {

	public MergeSort() {
		// TODO Auto-generated constructor stub
	}
	public MergeSort(int a){
		super();
		}
	static int[] numbers = new int[] { 4, 9, 7, 6,5,3,1 };
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(mergeSort(numbers)));
		//int[][] numbers=new int[][] {new int[] {1,2},new int[] {1,2},new int[] {1,2}};
		LinkedList<Integer> ll=new LinkedList<Integer>();
	}
	
	static int[] mergeSort(int[] array){
		
		if(array.length < 2) {
			return sort(array);
		}else {
			int n=array.length%2;
			int[] arrayA=new int[array.length/2];
			int[] arrayB=new int[array.length/2+n];
			for(int i=0;i<array.length;i++) {
				if(i<array.length/2) {
					arrayA[i]=array[i];
				}else {
					arrayB[i-(array.length/2)]=array[i];
				}
			}
		arrayA=mergeSort(arrayA);
		arrayB=mergeSort(arrayB);
		array= merge(arrayA,arrayB);
		}
		
		return array;
	}

	private static int[] merge(int[] left, int[] right) {
		int[] sortedArray=new int[left.length+right.length];
		 // running indices
	    int i = 0;
	    int j = 0;
	    int index = 0;
	    
	    // add until one subarray is deplete
	    while (i < left.length && j < right.length) {
	        if (left[i] < right[j]) {
	        	sortedArray[index++] = left[i++];
	        }
	        else {
	        	sortedArray[index++] = right[j++];
	        }
	    }
	    
	    // add every leftover elelment from the subarray 
	    while (i < left.length) {
	    	sortedArray[index++] = left[i++];
	    }
	    
	    // only one of these two while loops will be executed
	    while (j < right.length) {
	    	sortedArray[index++] = right[j++];
	    }
		return sortedArray;
		
	}

	private static int[] sort(int[] array) {
		if(array.length >1) {
			if(array[0] >array[1]) {
				int temp=array[0];
				array[0]=array[1];
				array[1]=temp;
				
			}
			return array;
		}
		else {
			return array;
		}
		
	}
}
