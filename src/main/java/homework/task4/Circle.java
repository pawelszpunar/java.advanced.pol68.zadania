package homework.task4;

public class Circle extends Shape{

    private final int radius;


    public Circle(Point p, int radius) {
        super(new Point[]{
                new Point(p.x, p.y)
        });
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * Math.pow(radius, 2);
    }
}
