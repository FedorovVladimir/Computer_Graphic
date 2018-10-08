package afin;

import Jama.Matrix;
import primitivs.Point;
import figure.PointFigure;

import static java.lang.Math.cos;
import static java.lang.StrictMath.sin;

public class Afin {
    // вращение
    public static void rotationX(double angle, PointFigure figure) {
        double[][] mat = new double[][]{
                {1, 0, 0, 0},
                {0, cos(angle), sin(angle), 0},
                {0, -sin(angle), cos(angle), 0},
                {0, 0, 0, 1}};
        mul(figure, new Matrix(mat));
    }
    public static void rotationY(double angle, PointFigure figure) {
        double[][] mat = new double[][]{
                {cos(angle), 0, -sin(angle), 0},
                {0, 1, 0, 0},
                {sin(angle), 0, cos(angle), 0},
                {0, 0, 0, 1}};
        mul(figure, new Matrix(mat));
    }
    public static void rotationZ(double angle, PointFigure figure) {
        double[][] mat = new double[][]{
                {cos(angle), sin(angle), 0, 0},
                {-sin(angle), cos(angle), 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}};
        mul(figure, new Matrix(mat));
    }

    // сжатие
    public static void dilatation(double a, double b, double c, PointFigure figure) {
        double[][] mat = new double[][]{
                {a, 0, 0, 0},
                {0, b, 0, 0},
                {0, 0, c, 0},
                {0, 0, 0, 1}};
        mul(figure, new Matrix(mat));
    }

    // отражение
    public static void reflectionXY(PointFigure figure) {
        double[][] mat = new double[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, -1, 0},
                {0, 0, 0, 1}};
        mul(figure, new Matrix(mat));
    }
    public static void reflectionYZ(PointFigure figure) {
        double[][] mat = new double[][]{
                {-1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}};
        mul(figure, new Matrix(mat));
    }
    public static void reflectionZX(PointFigure figure) {
        double[][] mat = new double[][]{
                {1, 0, 0, 0},
                {0, -1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}};
        mul(figure, new Matrix(mat));
    }

    // перенос
    public static void translation(double a, double b, double c, PointFigure figure) {
        double[][] mat = new double[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {a, b, c, 1}};
        mul(figure, new Matrix(mat));
    }

    // проецирование
    public static Point priekt(Point point) {
        double[][] mat = new double[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, -1, 0},
                {0, 0, 0, 1}};
        point = mul(point, new Matrix(mat));

        mat = new double[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0.3, 0.3, 1, 0},
                {0, 0, 0, 1}};
        point = mul(point, new Matrix(mat));

        mat = new double[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 0.002},
                {0, 0, 0, 1}};
        point = mul(point, new Matrix(mat));

        double k = 1 / point.h;
        return new Point(
                point.x * k,
                point.y * k,
                point.z * k,
                point.h * k);
    }

    private static void mul(PointFigure pointFigure, Matrix matrix) {
        for (int i = 0; i < pointFigure.getPoints().length; i++) {
            Point point = pointFigure.getPoints()[i];
            point.setPoint(mul(point, matrix));
        }
    }
    private static Point mul(Point point, Matrix matrix) {
        double[][] vec = {{point.x, point.y, point.z, point.h}};
        Matrix vector = new Matrix(vec);
        Matrix newVec = vector.times(matrix);

        return new Point(
                newVec.get(0, 0),
                newVec.get(0, 1),
                newVec.get(0, 2),
                newVec.get(0, 3));
    }
}
