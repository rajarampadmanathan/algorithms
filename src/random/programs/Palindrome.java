package random.programs;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Palindrome {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println(Math.pow(3,2));
		while(true){
		String text=sc.nextLine();
		Boolean result=true;
		text.trim();
		String [] text1=text.split(" ");
		//StringTokenizer st=new StringTokenizer(str, delim, returnDelims)
		for(String texts:text1) {
		System.out.println(texts.substring(0,texts.length()));
		
		}
		System.out.println("Over !!!");
		for(int i=0;i<text.length()/2;i++) {
			if(text.charAt(i) != text.charAt(text.length()-1-i)) {
				result=false;
				break;
			}
		}
		System.out.println(result);
		}
		//sc.close();
	}
	
}
