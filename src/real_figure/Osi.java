package real_figure;

import figure.*;
import primitivs.Line;
import primitivs.Point;

public class Osi extends Figure {
    public Osi(double length) {
        Point point1 = new Point(0,0,0,1);
        Point point2 = new Point(length,0,0,1);
        Point point3 = new Point(0,length,0,1);
        Point point4 = new Point(0,0,length,1);

        points = new Point[] {
                point1,
                point2,
                point3,
                point4
        };

        lines = new Line[] {
                new Line(point1, point2),
                new Line(point1, point3),
                new Line(point1, point4)
        };
    }
}
