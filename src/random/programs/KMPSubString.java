package random.programs;

import java.util.Arrays;

public class KMPSubString {
	
	public static void main(String[] args) {
		String s="abcxabcdabcdabcy";
		String p="abcdabcy";
		System.out.println(regular(s,p));
		System.out.println(kmpSearch(s,p));
	}

	private static int kmpSearch(String s, String p) {
		int nextIndex[]=buildTempArray(p);
		System.out.println(Arrays.toString(nextIndex));
		int i=0,j=0;
		while(i<s.length() && j<p.length()) {
			if(s.charAt(i)==p.charAt(j)) {
				i++;j++;
			}else if(j !=0) {
				j=nextIndex[j-1];
			}else {
				i++;
			}
			
			if(j==p.length()) {
				return i-(p.length());
			}
		}
		
		return -1;
	}

	private static int[] buildTempArray(String p) {
		int []nextIndex=new int[p.length()];
		int j=0;
		for(int i=1;i<p.length();) {
			//System.out.println("i:"+i+" Vales:"+p.charAt(j)+"--"+p.charAt(i));
			if(p.charAt(i) ==p.charAt(j)) {
				nextIndex[i]=j+1;
				i++;
				j++;
			}else {
				if(j==0) {
					nextIndex[i]=0;
					i++;
				}else {
					j=nextIndex[j-1];
				}
			}
		}
		return nextIndex;
	}

	private static int regular(String s, String p) {
	int i=0,j=0,k=0;
	while(i<s.length() && j< p.length()) {
		if(s.charAt(i) == p.charAt(j)) {
			i++;
			j++;
		}else {
			j=0;
			k++;
			i=k;
		}
		
		if(j==p.length()) {
			return k;
		}
	}
		return -1;
	}
	

}
