package Chapter10.Exercise2;

public class EmailNotification extends Notification{

    public EmailNotification(String message) {
        super(message);
    }


    @Override
    public String send() {
        return "I am an Email pop-up";
    }
}
