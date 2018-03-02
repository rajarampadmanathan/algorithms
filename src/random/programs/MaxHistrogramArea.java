package random.programs;

import java.util.ArrayDeque;
import java.util.Random;

public class MaxHistrogramArea {

	public static void main(String[] args) {
		int[] histogram = new int[] { 2,2,2,6,1,5,4,2,1,2,2};
		int area = calculateMaxArea(histogram);
		System.out.println(area);
		assert area ==12;
	}

	private static int calculateMaxArea(int[] histogram) {
		ArrayDeque<Integer> stack=new ArrayDeque<Integer>();
		if(histogram==null || histogram.length <1)
			return 0;
		int area=0,i;
		int tempArea;
		for(i=0;i<histogram.length;i++) {
			int y=histogram[i];
			if(stack.isEmpty() || histogram[stack.peekFirst()] <=y) {
				stack.addFirst(i);
			}else {
				while(!stack.isEmpty()  && histogram[stack.peekFirst()] > y) {
					tempArea=calculateArea(stack,stack.poll(),i,histogram);
					if(tempArea > area) {
						area=tempArea;
					}
				}
				stack.addFirst(i);
			}
		}
		
		while(!stack.isEmpty() ) {
			tempArea=calculateArea(stack,stack.poll(),i,histogram);
			if(tempArea > area) {
				area=tempArea;
			}
		}
		return area;
	}

	private static int calculateArea(ArrayDeque<Integer> stack, int top, int i,int[] histogram) {
		int area=0;
		if(stack.isEmpty()) {
			area=i*histogram[top];
		}else {
			area=histogram[top] * (i-stack.peekFirst()-1);
		}
		return area;
	}

}
