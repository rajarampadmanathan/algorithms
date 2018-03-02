package random.programs;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class LongestPalindromicSubStringTest {

	
	
	@Test
	public void testPalindrome(){
		String str = "abcbabcbabcba";
        System.out.println("Length is: " + 
                                 LongestPalindromicSubString.longestPalSubstr(str));
	}
	
	
	public static void main(String[] args) {
		 Result result = JUnitCore.runClasses(LongestPalindromicSubStringTest.class);
		    for (Failure failure : result.getFailures()) {
		      System.out.println(failure.toString());
		    }
	}
}
