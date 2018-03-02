package random.programs;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@A1
public class Temp extends Test{

	
	public static void main(String[] args) {
	/*	int[] numbers=new int[] {1,2,3,4,5,6};
		changeArray(numbers);
		System.out.println(Arrays.asList(numbers).toArray());*/
		System.out.println(Temp.class.getAnnotations().length);
		
	}

	private static void changeArray(int[] numbers) {
		
		System.out.println(numbers.getClass().getCanonicalName());
		int temp=numbers[0];
		numbers[0]=numbers[1];
		numbers[1]=temp;
		
	}
}
