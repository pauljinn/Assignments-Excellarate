package exceptionassignment;
/**
 * A checked custom exception class for invalid file type.
 * @author amans
 *
 */
public class IncorrectFileTypeException extends Exception{
	public IncorrectFileTypeException(String msg) {
		super(msg);
	}
}
