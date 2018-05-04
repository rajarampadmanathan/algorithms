package random.programs;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LongestPalindromicSubStringTest {

	private static LongestPalindromicSubString longestPalSubStr;

	@BeforeClass
	public static void intitalize() {
		longestPalSubStr = new LongestPalindromicSubString();
	}

	@Parameters
	public static Collection<Object[]> initParameters() {
		Object[][] data = { { "abba", 4 }, { "abbababba", 9 }, { "babcbaabcbaccba", 10 }, { "cdbabcbabdab", 9 } };
		return Arrays.asList(data);
	}

	@Parameter(0)
	public String s1;

	@Parameter(1)
	public int s2;

	@Test
	public void testPalindrome() {
		System.out.println(s1);
		System.out.println(s2);
		assertEquals("No", s2, longestPalSubStr.manichers(s1.toCharArray()));
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(LongestPalindromicSubStringTest.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
	}
}
