package random.programs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author mc55262
 *
 *         This class can be used to read the large file and to split it into
 *         multiple pieces either delimited by number of lines or number of
 *         characters.
 */
public class SplitFile {

	/**
	 * 
	 * Main method which will initiate the splitting process.
	 * 
	 * Either splitByLines or splitByChars should be called from here. We can
	 * call both as well.
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		System.out.println("Before Starting:" + System.currentTimeMillis());
		File file = new File("C:/Users/mc55262/GEO_ABC.docx");
		SplitFile testAnnotation = new SplitFile();
		ExecutorService es = Executors.newFixedThreadPool(100);
		try {
			testAnnotation.splitbyLines(file, 10000, es);
			System.out.println("Before Starting split by Chars:" + System.currentTimeMillis());
			testAnnotation.splitByChars(file, 200000, es);
			System.out.println("After Splitting:" + System.currentTimeMillis());
			es.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * This method can be used to split a file delimited by lines.
	 * 
	 * this will make use of {@link WriteToFile} class to write the split
	 * contents to file Asynchronously.
	 * 
	 * @param file
	 * @param maxLines
	 * @param es
	 * @throws IOException
	 */
	private void splitbyLines(File file, int maxLines, ExecutorService es) throws IOException {
		int lineCounter = 0;
		int fileCounter = 0;
		String line;
		StringBuffer lines = new StringBuffer();

		InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		while ((line = br.readLine()) != null) {
			lines.append("\n");
			lines.append(line);
			lineCounter++;
			if (lineCounter >= maxLines) {
				fileCounter++;
				WriteToFile writeToFile = new WriteToFile(lines.toString(), fileCounter);
				es.submit(writeToFile);
				lines = new StringBuffer();
				lineCounter = 0;
			}
		}
		if (lineCounter > 0) {
			WriteToFile writeToFile = new WriteToFile(lines.toString(), fileCounter);
			es.submit(writeToFile);
		}
		br.close();
		isr.close();

	}

	/**
	 * 
	 * This method can be used to split the file delimited by number of
	 * characters.
	 * 
	 * this will make use of {@link FileChunkReader} to split the file
	 * asynchronously.
	 * 
	 * @param file
	 * @param blockSize
	 * @param es
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	private void splitByChars(File file, int blockSize, ExecutorService es)
			throws FileNotFoundException, IOException, InterruptedException {
		int totalChunk = 0;
		try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r")) {
			totalChunk = (int) Math.ceil(Double.valueOf(file.length()) / blockSize);
			System.out.println(totalChunk);
		}

		ArrayList<FileChunkReader> fcrList = new ArrayList<FileChunkReader>();
		for (int index = 0; index < totalChunk; index++) {
			FileChunkReader fcr = new FileChunkReader(file, index, blockSize);
			fcrList.add(fcr);
		}
		es.invokeAll(fcrList);
	}

}

/**
 * used to write contents to file Asynchronously.
 * 
 * @author mc55262
 *
 */
class WriteToFile implements Callable<String> {

	String lines;
	int fileIndex;

	public WriteToFile(String lines, int fileIndex) {
		this.lines = lines;
		this.fileIndex = fileIndex;
	}

	/**
	 * This will get called to initiate Asynchronous processing
	 */
	@Override
	public String call() throws Exception {
		File splittedFile = new File("C:/Users/mc55262/splittedresults-lines/index-" + fileIndex + ".txt");
		try (FileWriter fw = new FileWriter(splittedFile)) {
			fw.write(lines);
			fw.close();
			return null;
		}

	}
}

/**
 * 
 * used to split the file contents by block and to write it to seperate files.
 * 
 * @author mc55262
 *
 */
class FileChunkReader implements Callable<String> {

	File file;
	int index;
	int blocSize;

	public FileChunkReader(File file, int index, int blockSize) {
		this.file = file;
		this.index = index;
		this.blocSize = blockSize;
	}

	/**
	 * This will get called to initiate Asynchronous processing
	 */
	@Override
	public String call() throws Exception {

		byte[] byteArray = new byte[blocSize];
		try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r")) {
			randomAccessFile.seek(index * blocSize);
			randomAccessFile.read(byteArray, 0, blocSize);
			String data = new String(byteArray);
			File splittedFile = new File("C:/Users/mc55262/splittedresults-chars/index-" + index + ".txt");
			FileWriter fw = new FileWriter(splittedFile);
			fw.write(data);
			fw.close();
			return data;
		}

	}
}
