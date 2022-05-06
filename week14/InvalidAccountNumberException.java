public class InvalidAccountNumberException extends Exception {
    //Account number must be 5 digits
    
    InvalidAccountNumberException(String message){
        super(message);
    }
}
