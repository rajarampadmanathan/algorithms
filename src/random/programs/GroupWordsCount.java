package random.programs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class GroupWordsCount {

	private static TreeMap<String,Integer> wordsMap=null;
	public static void main(String[] args) {
		wordsMap=new TreeMap<String,Integer>();
		readFile();
		System.out.println(wordsMap.descendingMap());
		wordsMap.forEach((key,value)->{System.out.println(key+":"+value);});
		System.out.println(wordsMap.keySet().parallelStream().collect(Collectors.counting()).toString());
	}
	private static void readFile() {
		FileInputStream fis=null;
		Scanner sc=null;
		try {
			fis=new FileInputStream("C:\\Users\\mc55262\\Documents\\Personal\\machine Learning\\action items.txt");
			sc=new Scanner(fis);
			String word;
			Integer count;
			while(sc.hasNext() && ((word=sc.next()) !=null)) {
				if((count=wordsMap.get(word)) !=null) {
					wordsMap.put(word, count+1);
				}else {
					wordsMap.put(word, 1);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sc.close();
		}
		
	}
}
