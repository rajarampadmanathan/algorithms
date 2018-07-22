package random.programs.postmsft;

import java.util.Scanner;
import java.util.stream.Stream;

public class PrintPrime {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("How many prime numbers?");
		int i = sc.nextInt();
		System.out.println();
		Stream.iterate(0, c -> c + 1).filter(PrintPrime::isPrime).limit(i).forEach(System.out::println);
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			sc.close();
		}));
	}

	private static boolean isPrime(int i) {
		if (i <= 1)
			return false;
		if (i <= 3)
			return true;
		if (i % 2 == 0 || i % 3 == 0)
			return false;
		int x = (int) Math.sqrt(i);
		for (int j = 5; j <= x; j += 6) {
			if (i % j == 0 || i % (j + 2) == 0)
				return false;
		}
		return true;
	}
}
