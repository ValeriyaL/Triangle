package by.liudchyk.triangle.exception;

/**
 * Created by Admin on 24.09.2016.
 */
public class TriangleException extends Exception {
    public TriangleException() {
    }

    public TriangleException(String message) {
        super(message);
    }

    public TriangleException(String message, Throwable cause) {
        super(message, cause);
    }

    public TriangleException(Throwable cause) {
        super(cause);
    }
}
