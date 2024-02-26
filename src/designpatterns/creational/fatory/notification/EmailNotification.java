package designpatterns.creational.fatory.notification;

public class EmailNotification implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("Sending e-mail notification");
    }
}
