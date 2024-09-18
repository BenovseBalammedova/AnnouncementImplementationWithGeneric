package exception;

public class UserIllegalArgument extends RuntimeException{
    public UserIllegalArgument(String message) {
        super(message);
    }
}
