package random.programs;

import java.io.File;

public class StreamTest {
	
	static int counter; 
	static int counterTotal;
	public static void main(String[] args) {
		File[] files=File.listRoots();
		for(File file:files) {
			counter=0;
			handleFile(file);
			System.out.println("Total Files in "+file.getAbsolutePath()+" Drive:"+counter);
		}
		System.out.println("Total Files:"+counterTotal);
	}

	private static void handleFile(File file) {
		if(file.isDirectory()) {
		File[] files=file.listFiles();
		//System.out.println(files);	
		for(int i=0;files!=null && files!=null && files.length >0 && i<files.length ;i++) {
				handleFile(files[i]);
			}	
		}else {
			counter++;
			counterTotal++;
			//System.out.println(file.getAbsolutePath());
		}
		
	}

}
