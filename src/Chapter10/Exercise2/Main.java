package Chapter10.Exercise2;

public class Main {
    public static void main(String[] args) {
        Notification[] notifications = {new SMSNotification("1"),
                new PushNotification("2"),
                new EmailNotification("3")
        };
        sendAll(notifications);
    }

    public static void sendAll(Notification[] notifications) {
        for(Notification notif: notifications) {
            System.out.println(notif.send());
        }
    }
}
