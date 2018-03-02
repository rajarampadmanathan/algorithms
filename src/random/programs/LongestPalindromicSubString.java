package random.programs;

import java.util.Arrays;

public class LongestPalindromicSubString {
	
	public static void main(String[] args) {
		
		String str = "abcbabcbabcba";
        if(args.length >0 ) {
        	str=args[0];
        }
		System.out.println("Length is: " + 
                                 longestPalSubstr(str));
		
		manichers("abba".toCharArray());
		manichers("abbababba".toCharArray());
		manichers("babcbaabcbaccba".toCharArray());
		manichers("cdbabcbabdab".toCharArray());
	}

	public static int manichers(char[] str) {
		int length=0;
		System.out.println(str);
		char[] inpt=new char[2* str.length+1];
		for(int i=0;i<inpt.length;i++) {
			if(i%2==0) {
				inpt[i]='|';
			}else {
				inpt[i]=str[i/2];
			}
		}
		System.out.println(String.valueOf(inpt));
		int[] lpsLength=new int[2* str.length+1];
		int start=0,end=0, newCenter=0;
		for(int i=0;i<lpsLength.length;) {
			System.out.println("New Center:"+i+" , start:"+start+",end:"+end);
			while(start>0 && end <inpt.length-1 && inpt[start-1]==inpt[end+1]) {
				start--;
				end++;
			}
			lpsLength[i]=end-start+1;
			length=Math.max(length, lpsLength[i]/2);
			if(end==inpt.length-1) {
				break;
			}
			newCenter = end +1; //(i%2 ==0 ? 1 : 0);
			for(int j=i+1;j<=end;j++) {
				lpsLength[j]=Math.min(lpsLength[i-(j-i)], (end-j)*2+1);
				length=Math.max(length, lpsLength[j]/2);
				if(lpsLength[(i-(j-i))]/2+j==end) {
					newCenter=j;
					break;
				}
				
			}
			i=newCenter;
			
			start=i-lpsLength[i]/2;
			end=i+lpsLength[i]/2;
			
		}
		System.out.println(Arrays.toString(lpsLength));
		
		/*for(int i:lpsLength) {
		if(i/2>length) {
			length=i/2;
		}	
		}*/
		System.out.println(length);
				return length;
	}
	public static int longestPalSubstr(String str) {
		int length=-1,palIndex=-1;
		int palindrome=0,j=0,k=0;
		for(int i=0;i<str.length();i++) {
			palindrome=0;
			j=i;k=i+1;
			while(j>=0 && k <str.length() && str.charAt(j) == str.charAt(k)) {
					palindrome+=2;
					j--;k++;
			}
			if(palindrome >length) {
			length=palindrome;
			palIndex=j+1;
			}
			palindrome=1;
			j=i-1;k=i+1;
			while(j>=0 && k <str.length() && str.charAt(j) == str.charAt(k)) {
					palindrome+=2;
					j--;k++;
			}
			if(palindrome >length) {
			length=palindrome;
			palIndex=j+1;
			}
		}
		System.out.println(str.substring(palIndex,palIndex+length));
		return length;
	}

}
