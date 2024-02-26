package designpatterns.creational.fatory.notification;

public class NotificationService {
    public static void main(String[] args) {
        Notification notification = NotificationFactory.createNotification(
                NotificationFactory.NotificationType.PUSH
        );
        notification.notifyUser();
    }
}
