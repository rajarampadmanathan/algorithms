package random.programs;

public class SquareRoot {

	
	public static void main(String[] args) {
		
		System.out.println("Sqrt of 144 using Brute Force: "+bruteForce(144)
		+",using bsearch: "+binarySearchSqrt(144)+",using babylonian:"+babylonian(144));
		System.out.println("Sqrt of 3 using Brute Force: "+bruteForce(3)
		+",using bsearch: "+binarySearchSqrt(3)+",using babylonian:"+babylonian(3));
		System.out.println("Sqrt of 9 using Brute Force: "+bruteForce(9)
		+",using bsearch: "+binarySearchSqrt(9)+",using babylonian:"+babylonian(9));
		System.out.println("Sqrt of 225 using Brute Force: "+bruteForce(225)
		+",using bsearch: "+binarySearchSqrt(225)+",using babylonian:"+babylonian(225));
		System.out.println("Sqrt of 26 using Brute Force: "+bruteForce(26)
		+",using bsearch: "+binarySearchSqrt(26)+",using babylonian:"+babylonian(26));
		System.out.println("Sqrt of 35 using Brute Force: "+bruteForce(35)
		+",using bsearch: "+binarySearchSqrt(35)+",using babylonian:"+babylonian(35));
		
	}

	public static double babylonian(int i) {
		if(i <0)
			return -1;
		if(i==1 || i==0)
			return i;
		double sqrt=1,x=i,precision=0.000000001;
		while(x-sqrt > precision) {
			x=(x+sqrt)/2;
			sqrt=i/x;
		}
		return sqrt;
	}

	public static int binarySearchSqrt(int i) {
		if(i <0)
			return -1;
		if(i==1 || i==0)
			return i;
		int sqrt=1,s=1,e=i/2;
		while(s <=e) {
		int mid= (s+e)/2;
		int temp=mid * mid;
		if(temp==i)
			return mid;
		if(temp< i) {
			s=mid+1;
			sqrt=mid;
		}else {
			e=mid-1;
		}
		}
		return sqrt;
	}

	public static int bruteForce(int i) {
		if(i <0)
			return -1;
		if(i==1 || i==0)
			return i;
		int sqrt=1;
		int temp=1;
		while(temp <=i) {
			sqrt ++;
			temp= sqrt * sqrt;
		}
		
		return sqrt-1;
	}
}
