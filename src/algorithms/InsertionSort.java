package algorithms;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class InsertionSort {

	static int[] numbers = new int[] { 4, 9, 7, 6,5,3,1 };
	
	private InsertionSort(){
		System.out.println("Private instance");
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException, NoSuchFieldException {
		
		Class<TestClass> is=TestClass.class;
		
		Constructor<?> construct=is.getDeclaredConstructors()[0];
		construct.setAccessible(true);
		System.out.println(is.getDeclaredConstructors()[0].isAccessible());
		TestClass instance=(TestClass) construct.newInstance();
		System.out.println(instance.getClass().getName());
		Field f=is.getDeclaredField("_");
		f.setAccessible(true);
		System.out.println(f.get(instance));
		
	}
}

class TestClass{
	
	private int _a=10;
	
	private TestClass() {
		System.out.println("Test cass");
	}
}