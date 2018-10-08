package primitivs;

import java.awt.*;

public class Poligon {
    public Point[] points;

    private double a;
    private double b;
    private double c;
    private double d;

    public Color color = Color.ORANGE;

    public Poligon(Point[] points) {
        this.points = points;
        findABCD();
    }

    private void findABCD() {
        findA();
        findB();
        findC();
        findD();
    }
    private void findA() {
        double sum = 0;
        for (int i = 0, j = 1; i < points.length; i++, j++) {
            if (i == points.length - 1)
                j = 0;
            sum += (points[i].y - points[j].y) * (points[i].z + points[j].z);
        }
        a = sum;
    }
    private void findB() {
        double sum = 0;
        for (int i = 0, j = 1; i < points.length; i++, j++) {
            if (i == points.length - 1)
                j = 0;
            sum += (points[i].z - points[j].z) * (points[i].x + points[j].x);
        }
        b = sum;
    }
    private void findC() {
        double sum = 0;
        for (int i = 0, j = 1; i < points.length; i++, j++) {
            if (i == points.length - 1)
                j = 0;
            sum += (points[i].x - points[j].x) * (points[i].y + points[j].y);
        }
        c = sum;
    }
    private void findD() {
        d = -(a*points[0].x + b*points[0].y + c*points[0].z);
    }

    @Override
    public String toString() {
        String str = "";
        for (Point point: points) {
            str += point.toString() + "\n";
        }
        str += "\n";
        str += " " + a + " " + b + " " + c + " " + d;
        return str;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
