package random.programs;

import java.util.ArrayList;
import java.util.List;

public class StringConditionalReverse {

	public static void main(String[] args) {
		List<String> data=new ArrayList<String>();
		List<String> result=new ArrayList<String>();
		data.add("abc");
		data.add("abcd");
		data.add("12");
		data.add("Pandora");
		
		data.stream().filter(s->{
			if(s.length() >2)return true;
			return false;
		}).forEach(s->{
			char[] c=s.toCharArray();
			for(int i=0;i<c.length/2;i++) {
				char temp;
				temp=c[i];
				c[i]=c[c.length-1-i];
				c[c.length-1-i]=temp;
			}
			result.add(new String(c));
		});
		
		for(String s:result) {
			System.out.println(s);
		}
	}
}
