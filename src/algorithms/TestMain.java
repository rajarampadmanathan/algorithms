package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestMain {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService es=Executors.newFixedThreadPool(5);
		List<Callable<String>> callObjects = new ArrayList<Callable<String>>();
		for(int i=0;i<100;i++) {
			callObjects.add(new TestCallable(i));
		}
		System.out.println("Scheduling starts");
		List<Future<String>> results= es.invokeAll(callObjects);
		System.out.println("Schedule Completed !!!");
		
		results.parallelStream().forEach((Future<String> f)->{
			try {
				System.out.println(f.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		es.shutdown();
		
	}
}
