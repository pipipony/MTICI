import java.util.EmptyStackException;

public class CustomEmptyStackException extends EmptyStackException {
    private String message;

    public CustomEmptyStackException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}