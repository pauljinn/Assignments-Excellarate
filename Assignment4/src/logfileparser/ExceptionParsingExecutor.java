package logfileparser;

public class ExceptionParsingExecutor {

	public static void main(String[] args) {
		//Calling the log parse which parse our desired exception logs
		LogFileParser.parseLogs("Sample Log File.txt","NullPointerException","Output.txt");

	}

}
