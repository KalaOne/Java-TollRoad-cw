package coursework2;

public class InsufficientAccountBalanceException extends Exception {
    public InsufficientAccountBalanceException(String str) {
        super(str);
    }
}
