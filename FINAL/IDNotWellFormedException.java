public class IDNotWellFormedException extends Exception {
    // The Customer ID must start with a letter, followed by 3 digits
    
    IDNotWellFormedException(String customMessage){
		super(customMessage);
	}
}
