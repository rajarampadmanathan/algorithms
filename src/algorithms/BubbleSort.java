package algorithms;

import java.util.Arrays;

public class BubbleSort {
	
	static int[] numbers = new int[] { 4, 9, 7, 1, 3, 6, 5 };
	
	public static void main(String[] args) {
	
		for(int i=numbers.length-1; i >0 ;i--) {
			int temp;
			for(int j=0;j<i;j++) {
				if(numbers[j] > numbers[j+1]) {
					temp=numbers[j];
					numbers[j]=numbers[j+1];
					numbers[j+1]=temp;
				}
				
			}
			
		}
		System.out.println(Arrays.toString(numbers));
		
	}

}
