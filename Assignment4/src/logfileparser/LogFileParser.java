package logfileparser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A class to parse our logs and extracting the useful information.
 * @author amans
 *
 */
public class LogFileParser {
	/**
	 * Parse our logs and extract the useful information from the logs.
	 * @param fileName
	 * @param exceptionType
	 */
	public static void parseLogs(String logFileName, String exceptionType, String outputFile) {
		//Reading our log file.
		File file = new File(logFileName);
		FileReader fr = null;
		BufferedReader br = null;
		//A list to store all the relevant info for different useful logs.
		List<ExceptionInfo> logsUsefulInfo = new ArrayList<>();
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line;
			//Reading line by line.
			while ((line = br.readLine()) != null) {
				//Store our exception log.
				String log = "";
				//If given exception type matched in a line.
				if (line.contains(exceptionType)) {
					log += line + "\n";
					String temp;
					// Get the entire log for the particular exception till we are not getting a new
					// date in line because that's where our exception log ends.
					while ((temp = br.readLine()) != null && !temp.equals("") && !Character.isDigit(temp.charAt(0))) {
						log += temp + "\n";
					}
					//Extracting the relevant info from the log.
					String message = extractMessage(log);
					String lineNumber =  extractCodeLine(log);
					String className = extractClass(log);
					String method =  extractMethodName(log);
					String description = extractDescription(log);
					String trace = extractTrace(log);
					
					//Storing the relevant info in a Exception Info container.
					ExceptionInfo info = new ExceptionInfo(message, lineNumber, className, method, description, trace);
					logsUsefulInfo.add(info);
				}
			}
			
			if(!logsUsefulInfo.isEmpty()) {
				writeUsefulInfoToFile(logsUsefulInfo,outputFile);
			}
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (IOException io) {
			io.printStackTrace();
		}

		finally {
			try {
				br.close();
			} catch (IOException io) {
				io.printStackTrace();
			}
		}

	}

	/**
	 * Extract message from the log.
	 * @param log
	 * @return
	 */
	private static String extractMessage(String log) {
		String firstLine = log.split("\n")[0];
		//Extracting the message from the first line.
		String message = firstLine.split(":")[0];
		return message;
	}
	
	/**
	 * Extract Second line of the logs.
	 * @param log
	 * @return
	 */
	private static String extractSecondLine(String log) {
		// Getting the stack trace.
		String stackTrace[] = log.split("\t");
		// Extracting the first line where the exception occur.
		String secondLine = stackTrace[1];
		return secondLine;
	}

	/**
	 * Extract line number where error happening from the logs.
	 * @param log
	 * @return
	 */
	private static String extractCodeLine(String log) {
		// Extracting the first line where the exception occur.
		String secondLine = extractSecondLine(log);
		// Fetching the line number where it occurs.
		String lineNumber = secondLine.replaceAll("[^0-9]", "");
		return lineNumber;
	}

	/**
	 * Extract class where error happening from the log.
	 * @param log
	 * @return
	 */
	private static String extractClass(String log) {
		// Extracting the first line where the exception occur.
		String secondLine = extractSecondLine(log);
		//Fetching the class name fromt the second line.
		String className = secondLine.split("[()]+")[1].replaceAll("[0-9:]+", "");
		return className;
	}
	
	/**
	 * Extract method where error happening from the log.
	 * @param log
	 * @return
	 */
	private static String extractMethodName(String log) {
		String secondLine = extractSecondLine(log);
		String methodName = null;
		//A pattern to check for camel case in our line of string.
		Pattern pattern = Pattern.compile("([a-z]*[A-Z]\\w+)+");
		//Matching the line and finding the matched pattern to extract the method name.
		Matcher matcher = pattern.matcher(secondLine);
		while (matcher.find())
		{
			String matched = matcher.group();
			if(Character.isLowerCase(matched.charAt(0))) {
				methodName = matched;
				break;
			}
		}
		//If no method found then return appropriately.
		return methodName==null?"No method present":methodName;
	}
	
	/**
	 * Extract description of error from the log.
	 * @param log
	 * @return
	 */
	private static String extractDescription(String log) {
		String firstLine = log.split("\n")[0];
		//Extracting the description from the first line.
		return firstLine.split(":")[1];
		
	}
	
	/**
	 * Extract whole trace of log.
	 * @param log
	 * @return
	 */
	private static String extractTrace(String log) {
		//This will exclude the log first line and extract the trace.
		return log.substring(log.indexOf("\n")+1).replaceAll("\t", "");
	}
	
	/**
	 * A method to write all the useful information from the logs to a file.
	 * @param logsUsefulInfo
	 * @param outputFileName
	 */
	private static void writeUsefulInfoToFile(List<ExceptionInfo> logsUsefulInfo, String outputFileName) {
		File file = new File(outputFileName);
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			file.createNewFile();
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			for(ExceptionInfo obj:logsUsefulInfo) {
				bw.write(obj.toString());
			}
		}
		catch(FileNotFoundException f) {
			f.printStackTrace();
		}
		catch(IOException io) {
			io.printStackTrace();
		}
		finally {
			try {
				bw.close();
			}
			catch(IOException io) {
				io.printStackTrace();
			}
		}
	}
}