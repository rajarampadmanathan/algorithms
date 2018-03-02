package random.programs;

public class ShiftMultiplicationDivision {

	public static void main(String[] args) {
		System.out.println(multiply(10, -12));
		System.out.println(multiply(-7, 10));
		System.out.println(multiply(9, -9));
		System.out.println(multiply(-9, -7));
		System.out.println(multiply(3, 6));
		System.out.println(multiply(0, 0));
		System.out.println(multiply(10, 12));
		System.out.println(multiply(7, 10));
		System.out.println(multiply(9, 9));
		System.out.println(multiply(9, 7));
		System.out.println(multiply(0, 6));
		System.out.println(multiply(6, 0));
		System.out.println(multiply(-6, 0));
		System.out.println(multiply(0, -6));
		System.out.println(divide(12,4));
		System.out.println(divide(7,5));
		System.out.println(divide(14,7));
		System.out.println(divide(36,-4));
		System.out.println(divide(-12,-4));
		System.out.println(divide(7,0));
		System.out.println(divide(0,7));
		System.out.println(divide(-36,4));
		System.out.println(divide(12,-4));
		System.out.println(divide(7,5));
		System.out.println(divide(14,70));
		System.out.println(divide(36,35));
		
	}

	private static int divide(int a,int b) {
		int result=1;
		boolean negative=false;
		if ((a < 0 && b>0) || (a > 0 && b<0)) {
			negative=true;
		}
		if(a==b) {
			return 1;
		}
		a=Math.abs(a);
		b=Math.abs(b);
		if(b==0) return -1;
		if( a==0 || a <b) return 0;
		
		
		int temp=b;
		while(temp <a) {
			temp=temp << 1;
			result=result <<1;
			if(temp== a) {
				if(negative)return -1 * result;
				return result;
			}
		}
		temp=temp >>1;
		result =result >>1;
		if(negative) return -1 * (result+ divide(a-temp,b));
		return result+ divide(a-temp,b);
	}
	private static int multiply(int i, int j) {
		int result = 1;
		boolean negative=false;
		if ((i == 0 || j == 0)) {
			return 0;
		}
		if ((i < 0 && j>0) || (j < 0 && i>0)) {
			negative=true;
		} else if (i == 1)
			return j;
		else if (j == 1)
			return i;
		if (i < j) {
			return multiply(j, i);
		}
		i=Math.abs(i);
		j=Math.abs(j);
		int counter = 1;
		result = i;
		while (counter < j) {
			result = result << 1;
			counter = counter << 1;
			if (counter == j) {
				if(negative) return (-1 * result);
				return result;
			}
		}
		counter = counter >> 1;
		result = result >> 1;
		if(negative)
		return -1 *(result + multiply(i, j - counter));
		return result + multiply(i, j - counter);
	}
}
