package random.programs;

import java.util.HashSet;
import java.util.Set;

public class RepeatingNonOverLappingSubString {

	public static void main(String[] args) {
		String s = new String("zbcdefghijklmnopqrstvwxfghiyaa");
		//longestRepeatingSubString(s);
		longestRepeatingNonOverlapSubString(s);
	}

	private static void longestRepeatingNonOverlapSubString(String s) {
		int counter=0;
		if (s == null || s.length() < 2)
			return;
		int window = s.length() / 2;
		System.out.println(window);
		while (window > 0) {
			for (int i = 0; i + (2 * window) <= s.length(); i++) {
				String s1 = s.substring(i, window+i);
				for (int j = window+i; j + window <= s.length(); j++) {
					counter++;
					String s2 = s.substring(j, j+window);
					System.out.println(s2);
					if (s1.equals(s2)) {
						System.out.println(s1+" after"+counter+" iterations.");
						return;
					}
				}
			}
		window=window-1;
		}
	}

	public static void longestRepeatingSubString(String s) {
		int longestLenth = 0;
		String longestString = "";
		Set<String> conter = new HashSet<String>();
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1 + longestLenth; j <= s.length(); j++) {
				String s1 = s.substring(i, j);
				if (conter.contains(s1)) {
					longestLenth = j;
					longestString = s1;
				} else {
					conter.add(s1);
				}

			}
		}
		System.out.println(longestString);
	}
}
