package designpatterns.behavioral.decorator.shape;

public class DecoratedDemo {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();

        circle.draw();
        rectangle.draw();


        System.out.println("------");
        RedShapeDecorator redRectangle = new RedShapeDecorator(rectangle);

        redRectangle.draw();
    }
}
