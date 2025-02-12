package exercise;

// BEGIN
public class NegativeRadiusException extends Exception {
    public NegativeRadiusException() {
        super("Радиус не может быть отрицательным.");
    }

    public NegativeRadiusException(String message) {
        super(message);
    }
}
// END
