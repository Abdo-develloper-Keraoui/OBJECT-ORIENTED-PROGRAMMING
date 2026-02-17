package Chapter10.Exercise2;

public class PushNotification extends Notification{


    public PushNotification(String message) {
        super(message);
    }

    @Override
    public String send() {
        return "I am an Push pop-up";
    }
}
