package exceptionassignment;

/**
 * A custom unchecked exception class for blank file name
 * @author amans
 *
 */
public class BlankFileNameException extends RuntimeException {
	
	public BlankFileNameException(String msg) {
		super(msg);
	}
}
