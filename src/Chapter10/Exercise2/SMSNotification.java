package Chapter10.Exercise2;

public class SMSNotification extends Notification{

    public SMSNotification(String message) {
        super(message);
    }

    @Override
    public String send() {
        return "I am an SMS pop-up";
    }
}
