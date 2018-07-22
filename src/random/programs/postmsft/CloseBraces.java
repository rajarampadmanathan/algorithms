package random.programs.postmsft;

import java.util.ArrayList;
import java.util.List;

public class CloseBraces {

	public static void main(String[] args) {
		List<String> result = new ArrayList<String>();
		closeBraces(result, "", 1, 1);
		result.forEach(System.out::println);
		System.out.println(result.size());
		List<String> result2 = new ArrayList<String>();
		closeBraces(result2, "", 2, 2);
		result2.forEach(System.out::println);
		System.out.println(result2.size());
		List<String> result3 = new ArrayList<String>();
		closeBraces(result3, "", 3, 3);
		result3.forEach(System.out::println);
		System.out.println(result3.size());
		List<String> result4 = new ArrayList<String>();
		closeBraces(result4, "", 4, 4);
		result4.forEach(System.out::println);
		System.out.println(result4.size());
		List<String> result5 = new ArrayList<String>();
		closeBraces(result5, "", 5, 5);
		result5.forEach(System.out::println);
		System.out.println(result5.size());
	}

	private static void closeBraces(List<String> result, String s, int st, int end) {
		if (st == 0 && end == 0) {
			result.add(s);
		}
		if (st > 0)
			closeBraces(result, s + "(", st - 1, end);
		if (st < end)
			closeBraces(result, s + ")", st, end - 1);
	}
}
