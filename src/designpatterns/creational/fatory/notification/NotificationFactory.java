package designpatterns.creational.fatory.notification;

public class NotificationFactory {
    public static Notification createNotification(NotificationType notificationType) {
        if (notificationType == null) return null;

        switch (notificationType) {
            case NotificationType.SMS -> {
                return new SMSNotification();
            }
            case NotificationType.EMAIL -> {
                return new EmailNotification();
            }
            case NotificationType.PUSH -> {
                return new PushNotification();
            }
        }
        throw new IllegalArgumentException("Unknown notification type" + notificationType);
    }

    public enum NotificationType {
        SMS, EMAIL, PUSH
    }
}
