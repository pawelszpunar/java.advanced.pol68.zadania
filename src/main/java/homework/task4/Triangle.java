package homework.task4;

public class Triangle extends Shape {


    public Triangle(Point a, Point b, Point c) {
        super(new Point[]{
                new Point(a.x, a.y),
                new Point(b.x, b.y),
                new Point(c.x, c.y)
        });
    }

    @Override
    double area() {
        return Math.abs((double) (((points[1].x - points[0].x) * (points[2].y - points[0].y)) - ((points[1].y - points[0].y) * (points[2].x - points[0].x))) / 2);
    }
}
