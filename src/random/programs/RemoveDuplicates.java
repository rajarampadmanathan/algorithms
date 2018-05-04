package random.programs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.stream.Collectors;

public class RemoveDuplicates {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br=null;
		BufferedWriter bw=null;
		try{HashMap hm=new HashMap<>();
		br=new BufferedReader(new FileReader("C:\\Users\\rajaram\\Desktop\\temp.txt"));
		br.lines().collect(Collectors.groupingBy(s->s,Collectors.counting())).forEach((a,b)->hm.put(a,b));
		br.close();
		System.out.println(hm);
		 bw=new BufferedWriter(new FileWriter("C:\\\\Users\\\\rajaram\\\\Desktop\\\\temp.txt"));
		bw.write(hm.toString());
		}finally {
			br.close();
			bw.close();
		}
		
	}
}
