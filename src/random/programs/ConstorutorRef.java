package random.programs;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstorutorRef {

	public static void main(String[] args) {
		char[] nameArray=new char[] {'R','A','J','A'};
		
		Function<char[], String> f=String::new;
		String s=f.apply(nameArray);
		System.out.println(s);
		
		Supplier<String> s1=s::toLowerCase;
		System.out.println(s1.get());
		
		List<String> list = new ArrayList<String>();
		list.add("asdasd");
		list.add("zxczxczxc");
		Consumer<String> c1=System.out::println;
		list.forEach(c1);
		list.forEach(x -> System.out.println(x));
		Runnable r=new ConstorutorRef()::test;
		Thread t=new Thread(r);
		t.start();
		r=()->System.out.println("Hello");
		t=new Thread(r);
		t.start();
	}
	
	public void test() {
		System.out.println("test method");
	} 
}
