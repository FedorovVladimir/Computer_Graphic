package primitivs;

public class Point {
    public double x;
    public double y;
    public double z;
    public double h;

    public Point(double x, double y, double z, double h) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.h = h;
    }

    public double getX() {
        return x + 400;
    }

    public double getY() {
        return -y + 300;
    }

    public void setPoint(Point point) {
        this.x = point.x;
        this.y = point.y;
        this.z = point.z;
        this.h = point.h;
    }

    @Override
    public String toString() {
        return x + " " + y + " " + z + " " + h;
    }
}
