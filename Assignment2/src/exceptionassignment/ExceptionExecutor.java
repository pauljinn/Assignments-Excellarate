package exceptionassignment;

import java.util.Scanner;

public class ExceptionExecutor {

	public static void main(String[] args) {
		// Console for Uploading file.
		Scanner sc = new Scanner(System.in);
		System.out.println("******Upload File******");
		System.out.print("Please enter file name with extension you wants to upload: ");
		String fileName = sc.nextLine();
		//Handling the our custom checked exception IncorrectFileTypeExtension
		try {
			checkFileExtension(fileName);
		}

		catch (IncorrectFileTypeException ex) {
			System.out.println(ex.getMessage());
		}

		catch (BlankFileNameException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * A utility method to check the file extension is pdf or not.
	 * 
	 * @param fileName
	 * @throws IncorrectFileTypeException
	 */
	public static void checkFileExtension(String fileName) throws IncorrectFileTypeException, BlankFileNameException {

		// Checking both the case when user didn't passed anything in file name and when
		// user passed just the extension not name
		if (fileName.trim().equals("") || fileName.substring(0, fileName.lastIndexOf('.')).trim().equals("")) {
			throw new BlankFileNameException("File name can't be blank");
		}

		// Checking if the file extension is pdf.
		if (fileName.endsWith(".pdf")) {
			System.out.println("Successfully uploaded");
		}
		// If not pdf then throwing incorrect file type exception.
		else {
			throw new IncorrectFileTypeException("Only PDF files are accepted");
		}
	}

}
