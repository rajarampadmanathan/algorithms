
package random.programs;

import java.util.ArrayList;

public class ArmstrongNumber {

	public static void main(String[] args) {
int iComp=-1;
String bIComp=Integer.toBinaryString(iComp);
System.out.println(bIComp);

System.out.println(Integer.parseInt(bIComp,2));
StringBuilder comp=new StringBuilder();
int initZeros=32-bIComp.length();
for(int x=0;x<initZeros;x++) {
comp.append('0');	
}
comp.append(bIComp);
System.out.println("Before Conversion:"+comp.toString());
for(int i=comp.length()-1;i>=0;i--) {
	if(comp.charAt(i) == '1') {
		flip(comp,--i);
		break;
	}
}
System.out.println(comp.toString());
System.out.println(Integer.parseInt(comp.toString(),2));
		int number = 1634;
		ArrayList<Integer> nums=new ArrayList<Integer>();
		int power = 0, quot = number;
		while (quot > 0) {
			nums.add(quot%10);
			quot=quot/10;
				power=power+1;
			
		}
		System.out.println(power);
		System.out.println(nums);
		double newnum=0;
		for(int i:nums) {
			System.out.println(Math.pow(i,power));
			newnum= newnum+Math.pow(i,power);
		}
		System.out.println(newnum);
	}

	private static void flip(StringBuilder comp, int i) {
		while(i>=0) {
			if(comp.charAt(i)=='0') {
		comp.setCharAt(i, '1');	
			}else {
				comp.setCharAt(i, '0');
			}
			i--;
		}
		
	}

}
