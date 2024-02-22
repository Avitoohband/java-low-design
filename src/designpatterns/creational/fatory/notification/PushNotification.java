package designpatterns.creational.fatory.notification;

public class PushNotification implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("Sending push notification");
    }
}
