package Chapter10.Exercise2;

public class Notification {
    private String message;

    public Notification(){}

    public Notification(String message) {
        this.message = message;
    }

    public String send() {
        return message;
    }
}
