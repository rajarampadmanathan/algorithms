package random.programs;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

interface MyCallable<T> extends Callable<T> {

	T call();
}

public class StreamTest {

	static int counter;
	static int counterTotal;

	public static void main(String[] args) {

		File[] files = File.listRoots();
		int i = 0;
		CompletableFuture<String> cf1 = new CompletableFuture<>();
		CompletableFuture<String> cf2 = new CompletableFuture<>();
		CompletableFuture<String> cf3 = new CompletableFuture<>();
		List<CompletableFuture<String>> cf=List.of(cf1,cf2,cf3);
		Collection<MyCallable<String>> cs = new ArrayList<>();
		try {

			cs.add(() -> {
					System.out.println("Called");
					cf1.complete( "1Value i:" + i+1);
					System.out.println("Called end");
				return null;
			});
			cs.add(() -> {
								System.out.println("Called");
					cf2.complete( "2Value i:" + i+1);
					System.out.println("Called end");
				return null;
			});
			cs.add(() -> {
								System.out.println("Called");
					cf3.complete( "3Value i:" + i+1);
					System.out.println("Called end");
				return null;
			});
			ExecutorService ex = Executors.newWorkStealingPool();
			List<Future<String>> f = ex.invokeAll(cs);
			cf.stream().forEach((x)-> {try {
				System.out.println("X:"+x.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}});
			
			ex.shutdown();
		} catch (InterruptedException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		int[] numbers = new int[300];
		Arrays.fill(numbers, 1);
		Arrays.sort(numbers);
		int yi = numbers[290];
		System.out.println(yi);
		// Write a function that takes a string and return the length encoded string for
		// the given string.
		// Ex "wwwxttwwhhjf" should returns "w3xt2w2h2jf"
		StringBuilder res = new StringBuilder();
		Character lastChar = '\u0000';
		int count = 1;
		StringBuffer str = new StringBuffer();
		"wwwxttwwhhjf".chars().boxed().
		collect(Collectors.groupingBy(x -> (char)(int)x, Collectors.counting())).forEach((x, y) -> {
					str.append(x).append(y);
				});
		System.out.println(str);
		for (Character c : "wwwxttwwhhjff".toCharArray()) {
			if (!c.equals(lastChar)) {
				lastChar = c;
				if (count > 1)
					res.append(count);
				count = 1;
				res.append(c.toString());
			} else {
				count++;
			}

		}
		if (count > 1)
			res.append(count);
		System.out.println(res);
		
		Arrays.asList(files).forEach(file -> {
			counter = 0;
			handleFile(file);
			System.out.println("Total Files in " + file.getAbsolutePath() + " Drive:" + counter);
		});
		System.out.println("Total Files:" + counterTotal);
	}

	private static void handleFile(File file) {
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			// System.out.println(files);
			for (int i = 0; files != null && files != null && files.length > 0 && i < files.length; i++) {
				handleFile(files[i]);
			}
		} else {
			counter++;
			counterTotal++;
			// System.out.println(file.getAbsolutePath());
		}

	}

}
