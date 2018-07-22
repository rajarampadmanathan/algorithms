package random.programs;

import java.util.LinkedHashMap;
import java.util.Map;

public class StringPermutation {

	public static void main(String[] args) {
		String s="ABABB";
		System.out.println(s.substring(0,0));
		System.out.println(s.substring(0,1));
		LinkedHashMap<Character, Integer> map=new LinkedHashMap<Character,Integer>();
		for(char c:s.toCharArray()) {
				map.compute(c, (key,value)->{
					if(value == null)return 1;
					return value+1;
				});
		}
		permuteString(map,new char[s.length()],0);
	}

	private static void permuteString(LinkedHashMap<Character, Integer> map,char[] result,int index) {
		if(index==result.length) {
			System.out.println(new String(result));
			return;
		}
		for(Map.Entry<Character, Integer> entry:map.entrySet()) {
			if(entry.getValue() >0) {
				entry.setValue(entry.getValue()-1);
				result[index]=entry.getKey();
				permuteString(map, result, index+1);
				entry.setValue(entry.getValue()+1);
			}
		}
		
	}
}
