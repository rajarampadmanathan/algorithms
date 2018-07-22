package random.programs;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MaxRepeatedSubString {

	static Map<String, Integer> count = new HashMap<>();

	public static void main(String[] args) {
		String s = "abcdcdc";
		maxRepeatedSubString(s);
		System.out.println(count);
		System.out.println(count.entrySet().stream().sorted((c1, c2) -> {
			int i=c2.getValue().compareTo(c1.getValue());
			if(i==0)
				return Integer.compare(c2.getKey().length(),c1.getKey().length());
			else
				return i;
		}).filter(e -> e.getKey().length() > 1).findFirst().get().getKey());
	}

	private static void maxRepeatedSubString(String s) {
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				String s1 = s.substring(i, j);
				count.merge(s1, 1, (o, n) -> {
					if (o != null)
						return o + n;
					else
						return n;
				});
			}
		}
	}
}
