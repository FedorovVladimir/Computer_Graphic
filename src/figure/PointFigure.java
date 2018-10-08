package figure;

import primitivs.Point;

import java.awt.*;

public interface PointFigure {
    Point[] getPoints();
    Color getPointColor();
    void setPointColor(Color color);

    double getCenterX();
    double getCenterY();
    double getCenterZ();
    double getCenterH();

    void setCenterX(double x);
    void setCenterY(double y);
    void setCenterZ(double z);
    void setCenterH(double h);
}
