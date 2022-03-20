package Points;

public class Main {
    public static void main(String[] args) {
        Point point1 = new Point(3, 4);
        Point point2 = new Point(5, 6);
        System.out.printf("%1.4f", getDistance(point1, point2));
    }

    public static double getDistance(Point p1, Point p2) {
        return Math.sqrt(((p2.getX() - p1.getX()) * (p2.getX() - p1.getX())) + ((p2.getY() - p1.getY()) * (p2.getY() - p1.getY())));
    }
}