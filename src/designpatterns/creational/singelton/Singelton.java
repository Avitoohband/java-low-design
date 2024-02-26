package designpatterns.creational.singelton;

public class Singelton {

    private static volatile Singelton instance;

    private Singelton() {
    }

    public static Singelton getInstance() {
        if (instance == null) {
            synchronized (Singelton.class) {
                if (instance == null) instance = new Singelton();
            }
        }
        return instance;
    }
}
