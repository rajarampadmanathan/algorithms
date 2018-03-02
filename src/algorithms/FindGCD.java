package algorithms;

public class FindGCD {

	public static void main(String[] args) {
		int a=15;
		int b=20;
		System.out.println(findGCD(a,b));
		System.out.println(a*b/(findGCD(a,b)));
	}

	private static int findGCD(int a, int b) {
		if(a%b ==0) {
			return b;
		}else {
		return findGCD (b,a%b);	
		}
		
	}
}
