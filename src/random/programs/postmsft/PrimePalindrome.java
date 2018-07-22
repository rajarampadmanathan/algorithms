package random.programs.postmsft;

/**
 * 
 * @author rajaram
 * @category LeetCode
 *           <blockquote>https://leetcode.com/problems/prime-palindrome/description/</blockquote>
 * 
 */

public class PrimePalindrome {

	public static void main(String[] args) {
		System.out.println(primePalindrome(500));
		System.out.println(primePal(500));
	}
	
	/**
	 * https://leetcode.com/problems/prime-palindrome/discuss/146798/Search-Palindrome-with-Even-Digits
	 * @param N
	 */
	public static int primePal(int N) {
		if(N >=8 && N<=11)
			return 11;
		for(int i=1;i<100000;i++) {
			int x=Integer.parseInt(i+new StringBuffer(String.valueOf(i)).reverse().toString().substring(1));
			if(x >=N && isPrime(x))
				return x;
		}
		return -1;
	}
	public static int primePalindrome(int N) {
		if (N <= 2)
			return 2;
		if (N % 2 == 0)
			N += 1;
		while (true) {
			if (isPalindrome(N) && isPrime(N)) {
				return N;
			}
			N += 2;
		}
	}

	private static boolean isPalindrome(int n) {
		if(n <=9)
			return true;
		int n1=0;
		while(n > n1) {
			n1=n1 * 10 +n%10;
			n=n/10;
		}
		return n==n1 || n==n1/10;
	}

	private static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		if (n <= 3)
			return true;
		if (n % 2 == 0 || n % 3 == 0)
			return false;
		for (int i = 5; i <= Math.sqrt(n); i+=6) {
			if (n % i == 0 || n % (i + 2) == 0)
				return false;
		}
		return true;
	}
}
