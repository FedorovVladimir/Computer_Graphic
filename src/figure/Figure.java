package figure;

import afin.Afin;
import primitivs.Line;
import primitivs.Point;
import primitivs.Poligon;

import java.awt.*;

public class Figure implements PointFigure, LineFigure, PoligonFigure {
    protected primitivs.Point[] points;
    protected Line[] lines;
    protected Poligon[] poligons;
    private Color pointColor = Color.GREEN;
    private Color lineColor = Color.GREEN;
    private Color poligonColor = Color.GREEN;

    protected double centerX;
    protected double centerY;
    protected double centerZ;
    protected double centerH = 1;

    @Override
    public Poligon[] getPoligons() {
        return poligons;
    }

    @Override
    public Color getPoligonColor() {
        return poligonColor;
    }

    @Override
    public void setPoligonColor(Color color) {
        this.poligonColor = color;
    }

    @Override
    public primitivs.Point[] getPoints() {
        return points;
    }

    @Override
    public Color getPointColor() {
        return pointColor;
    }

    @Override
    public void setPointColor(Color color) {
        this.pointColor = color;
    }

    @Override
    public Line[] getLines() {
        return lines;
    }

    @Override
    public Color getLineColor() {
        return lineColor;
    }

    @Override
    public void setLineColor(Color color) {
        this.lineColor = color;
    }

    @Override
    public String toString() {
        String str = "";
        for (Point point: points)
            str += point + "\n";
        for (Line line: lines)
            str += line.point1 + " - " + line.point2 + "\n";
        return str;
    }

    @Override
    public double getCenterX() {
        return centerX;
    }

    @Override
    public double getCenterY() {
        return centerY;
    }

    @Override
    public double getCenterZ() {
        return centerZ;
    }

    @Override
    public double getCenterH() {
        return centerH;
    }

    @Override
    public void setCenterX(double x) {
        Afin.translation(x - centerX, 0,0, this);
        centerX = x;
    }

    @Override
    public void setCenterY(double y) {
        Afin.translation(0,y - centerY,0, this);
        centerY = y;
    }

    @Override
    public void setCenterZ(double z) {
        Afin.translation(0, 0,z - centerZ, this);
        centerZ = z;
    }

    @Override
    public void setCenterH(double h) {
        centerH = h;
    }
}
