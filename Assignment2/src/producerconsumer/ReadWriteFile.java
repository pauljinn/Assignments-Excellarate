package producerconsumer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * A class to read and write file using executor service.
 * @author amans
 *
 */
public class ReadWriteFile {
	
	private static boolean fileReadOver  = false;
	/**
	 * A method to implement read and write from a file.
	 * @param args
	 */
	public static void main(String[] args) {
		//Creating a executor service with fixed thread pool of size 2 (one for read and another for write).
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		//A thread safe buffer to store the lines read from the file.
		ProducerConsumerBufferImpl<String> queue = new ProducerConsumerBufferImpl<>();
		//A Read thread run() method implementation to read from a file.
		Runnable read = () -> {
			BufferedReader br = null;
			try {
				File file = new File("src/producerconsumer/readfile.txt");
				FileReader fileReader = new FileReader(file);
				br = new BufferedReader(fileReader);
				String line;
				//Reading from the input file and storing each line into our buffer.
				while ((line = br.readLine()) != null) {
					System.out.println(line);
					queue.put(line);
				}
				fileReadOver = true;
			} catch (FileNotFoundException fo) {
				fo.printStackTrace();
			}

			catch (IOException io) {
				io.printStackTrace();
			}

			finally {
				try {
					if (br != null) {
						br.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		};
		
		//Starting our Read thread.
		executorService.execute(read);
		
		//A write thread run method implementation to write to a file.
		Runnable write = () -> {
			BufferedWriter bw = null;
			try {
				//File to which write operation will be performed.
				File file = new File("src/producerconsumer/output.txt");
				file.createNewFile();
				FileWriter fw = new FileWriter(file);
				bw = new BufferedWriter(fw);
				//Writing to our file by reading the line from our buffer.
				while(queue.getSize()>0) {
					String line = queue.get();
					line += "\n";
					bw.write(line);
					bw.flush();
				}

			}

			catch (FileNotFoundException fo) {
				fo.printStackTrace();
			}

			catch (IOException io) {
				io.printStackTrace();
			}

			finally {
				try {
					if (bw != null) {
						bw.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		};
		
		//Starting our write thread.
		executorService.execute(write);
		
		//Shutting down our executor service.
		executorService.shutdown();
	}

}
