package random.programs;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Example: Input: paragraph = "Bob hit a ball, the hit BALL flew far after it
 * was hit." banned = ["hit"] Output: "ball" Explanation: "hit" occurs 3 times,
 * but it is a banned word. "ball" occurs twice (and no other word does), so it
 * is the most frequent non-banned word in the paragraph. N\ote that words in
 * the paragraph are not case sensitive, that punctuation is ignored (even if
 * adjacent to words, such as "ball,"), and that "hit" isn't the answer even
 * though it occurs more because it is banned.
 * 
 * 
 * Note:
 * 
 * 1 <= paragraph.length <= 1000. 1 <= banned.length <= 100. 1 <=
 * banned[i].length <= 10. The answer is unique, and written in lowercase (even
 * if its occurrences in paragraph may have uppercase symbols, and even if it is
 * a proper noun.) paragraph only consists of letters, spaces, or the
 * punctuation symbols !?',;. Different words in paragraph are always separated
 * by a space. There are no hyphens or hyphenated words. Words only consist of
 * letters, never apostrophes or other punctuation symbols.
 */
public class LC819MostCommonWord {

	public static void main(String[] args) {
		System.out.println("Ans:"+
				mostCommonWord("Bob hit a ball, the hit BALL ? ' ;. ? ' ;. ? ' ;. ? ' ;.? ' ;. flew far after it was hit.", new String[] { "hit" }));
	}

	public static String mostCommonWord(String paragraph, String[] banned) {
		String word = "";
		if (paragraph == null || paragraph.length() == 0)
			return "";
		paragraph=paragraph.replaceAll("[^a-zA-Z\\s]", "");
		paragraph=paragraph.toLowerCase();
		  word=Stream.of(paragraph.split(" ")).filter(s-> !s.isEmpty()).collect(Collectors.groupingBy(x->x,Collectors.counting())).entrySet().
		  stream().sorted((o1,o2)-> {return o2.getValue().compareTo(o1.getValue());}).filter(x->{
			  for(int i=0;i<banned.length;i++) {
			  if(x.getKey().equals(banned[i]))
				  return false; 
			  }
			  return true;
		  }).findFirst().get().getKey();
		return word;
	}
}
