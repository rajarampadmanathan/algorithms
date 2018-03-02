package random.programs;

import java.util.HashMap;
import java.util.Map;

public class MaxRepeatedSubString {

	static Map<String,Integer> count=new HashMap<>();
	public static void main(String[] args) {
		String s="abcdcdc";
		maxRepeatedSubString(s);
		System.out.println(count);
	}

	private static void maxRepeatedSubString(String s) {
			for(int i=0;i<s.length();i++) {
				for(int j=i+1;j<=s.length();j++) {
					String s1=s.substring(i,j);
					if(count.containsKey(s1)) {
						count.put(s1, count.get(s1)+1);
					}else {
						count.put(s1, 1);
					}
				}	
			}
	}
}
