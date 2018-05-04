package random.programs;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

abstract class A{
	
public void print1() {
	System.out.println("Class A");
	
	print();
	print2();
	
}	

 private void print() {

	System.out.println("Class A");
	
}	

abstract void print2();


}


@A1
public class Temp extends A{

	 void print() {
		System.out.println("Temp");
	}
	
	public static void main(String[] args) {
		System.out.println(2 );
		A a=new Temp();
		//a.print1();
		int c='\u0000';
		if(c=='\u0000') {
			System.out.println("Equal"+c);
		}
		
		int aa=5;
		
	}

	void print2() {
		System.out.println("Temp...Print 2");
		
	}

	
}

