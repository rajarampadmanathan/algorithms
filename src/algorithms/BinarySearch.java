package algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

	
	
	public static void main(String[] args) {
		Integer[] numbers =new Integer[] {3,4,5,7,9,13,15,16,17,19};
		Scanner sc=new Scanner(System.in);
		int num;
		do {
		System.out.println("Enter any numbers from :"+Arrays.toString(numbers));
		num=sc.nextInt();
		System.out.println(binarySearch(numbers,num,0,numbers.length-1));
		}while(num !=-1);
		sc.close();
	}

	private static int binarySearch(Integer[] numbers, int i,int low,int high) {
	if(low> high) {
	 return -1;	
	}	
	
	int middle=(low+high)/2;
	if(i==numbers[middle]) {
		return middle;
	}
	if(i>numbers[middle]) {
		return binarySearch(numbers, i, middle+1, high);	
	}
	else {
		return binarySearch(numbers, i, low, middle-1);	
	}
	}
}
