package random.programs;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FibonacciSeries {

	
	public static void main(String[] args) {
		System.err.println("Starts Here...");
	
		String  x=new BigInteger("3").toString();
		String v=String.valueOf(new BigInteger("3").intValue());
		System.out.println(x.equals(v));
		long l=Long.MAX_VALUE;
		int i=(int)78574837584785l;
		System.out.println(i);
		
		char[] chars=new String("AaBbCcDd").toCharArray();
		for(int singleChar:chars) {
			System.out.println(singleChar);
		}
		LinkedList<Integer> al;
		//al.po
		/*printFibonacci(0);
		printFibonacci(1);
		printFibonacci(-10);
		printFibonacci(-1);
		printFibonacci(2);
		printFibonacci(5);
		printFibonacci(10);*/
		//printFibonacci(1000);
	}

	private static BigInteger printFibonacci(int i) {
	if(i <1) {
		return new BigInteger(new Integer(i).toString());
	}
	System.out.println(0);
	
	BigInteger  value1=new BigInteger("0");
	BigInteger  value2=new BigInteger("1");
	BigInteger fibonacciNumber=new BigInteger("0");
	for(int j=1;j<=i;j++) {
		fibonacciNumber=value1.add(value2);
		value2=value1;
		value1=fibonacciNumber;
		System.out.println(fibonacciNumber);
	}
		return fibonacciNumber;
	}
	
	
}
