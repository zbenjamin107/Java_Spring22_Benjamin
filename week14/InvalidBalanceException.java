public class InvalidBalanceException extends Exception{
    //Balance exceeds max balance
    //
    InvalidBalanceException(String message){
        super(message);
    }
}
