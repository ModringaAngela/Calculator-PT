
public class BadInputException extends RuntimeException{

	private String message;
	
	public BadInputException() {
		message = "Bad input! Insert a valid one!";
	}
	
	 public String toString() {
	      return message;
	   }
}
