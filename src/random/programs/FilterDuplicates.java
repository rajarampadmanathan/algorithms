package random.programs;

import java.util.Arrays;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public class FilterDuplicates {
	
	public static void main(String[] args) {
		int []nums= {1,2,3,4,1,5,4,5,8,1,9,8,2,1};
		System.out.println(Arrays.stream(nums)
			  .boxed()
			  .collect(groupingBy(Function.identity(),counting()))
			  .entrySet()
			  .stream()
			  .filter(e->e.getValue() >1)
			  .count());
	}
	
	//binarysearch for finding smallest number greater than given number.

}
