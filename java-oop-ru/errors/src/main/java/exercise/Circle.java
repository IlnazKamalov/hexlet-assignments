package exercise;

public class Circle {

    Point point;
    int radius;

    public Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    public int getRadius() {
        return this.radius;
    }

    public double getSquare() throws NegativeRadiusException {
        if (radius < 0) {
           throw new NegativeRadiusException("Circle radius less than zero");
        }
        double area = Math.PI * (radius * radius);
        return area;
    }
}