package real_figure;

import figure.Figure;
import primitivs.Line;
import primitivs.Point;
import primitivs.Poligon;

public class RectangularParallelepiped extends Figure {
    public RectangularParallelepiped(double lengthX, double lengthY, double lengthZ) {
        Point point1 = new Point(0,0,0,1);
        Point point2 = new Point(lengthX,0,0,1);
        Point point3 = new Point(lengthX,0,lengthZ,1);
        Point point4 = new Point(0,0,lengthZ,1);

        Point point5 = new Point(0,lengthY,0,1);
        Point point6 = new Point(lengthX,lengthY,0,1);
        Point point7 = new Point(lengthX,lengthY,lengthZ,1);
        Point point8 = new Point(0,lengthY,lengthZ,1);

        points = new Point[] {
                point1,
                point2,
                point3,
                point4,

                point5,
                point6,
                point7,
                point8,
        };

        lines = new Line[] {
                new Line(point1, point2),
                new Line(point2, point3),
                new Line(point3, point4),
                new Line(point4, point1),

                new Line(point1, point5),
                new Line(point2, point6),
                new Line(point3, point7),
                new Line(point4, point8),

                new Line(point5, point6),
                new Line(point6, point7),
                new Line(point7, point8),
                new Line(point8, point5),
        };

        poligons = new Poligon[] {
                new Poligon(new Point[]{
                        point1,
                        point2,
                        point3,
                        point4
                }),

                new Poligon(new Point[]{
                        point1,
                        point2,
                        point6,
                        point5
                }),

                new Poligon(new Point[]{
                        point2,
                        point3,
                        point7,
                        point6
                }),

                new Poligon(new Point[]{
                        point3,
                        point4,
                        point8,
                        point7
                }),

                new Poligon(new Point[]{
                        point1,
                        point4,
                        point8,
                        point5
                }),

                new Poligon(new Point[]{
                        point5,
                        point6,
                        point7,
                        point8
                }),
        };

        centerX = lengthX / 2;
        centerY = lengthY / 2;
        centerZ = lengthZ / 2;
        centerH = 1;
    }
}
