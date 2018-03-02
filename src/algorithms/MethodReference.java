package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MethodReference {
	
	public static int test(int a,int b) {
		return -2;
	}
	
	public static void test(Object b) {
		//return -2;
	}
	
	public static void main(String[] args) {
		List<Integer> numbers= new ArrayList<Integer>(Arrays.asList(1,2,8,7,4,22,95));
		Comparator<Integer> comp =(a,b)->a.compareTo(b);
		Collections.sort(numbers, MethodReference::test);
		numbers.forEach((a)->System.out.println(a));
		numbers.forEach(System.out::println);
		numbers.forEach(MethodReference::test);
	}

}
