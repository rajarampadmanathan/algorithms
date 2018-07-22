package random.programs;

public class LuhnAlgorithm {

	/**
	 * This is the main driver function to calculate the luhn algorithm
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("354857091871306 :" + isValidNumber("354857091871306"));
	}

	/**
	 * This function can be used to validate whether the given number is valid or
	 * not based on luhn's algorithm
	 * 
	 * @param number
	 * @return boolean 
	 */
	private static boolean isValidNumber(String number) {
		long sum = 0;
		for (int i = number.length(); i > 0; i--) {
			System.out.println("sum:"+sum+"char:"+(number.charAt(i - 1) - 48));
			if ((number.length() - i) % 2 == 0)
				sum +=(int)number.charAt(i - 1);
			else {
				int temp =(int) number.charAt(i - 1);
				//temp = temp * 2;
				sum += temp / 10;
				sum += temp % 10;
			}
		}
		System.out.println(sum);
		return sum % 10 == 0;
	}
}
