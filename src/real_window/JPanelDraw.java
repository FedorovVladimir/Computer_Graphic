package real_window;

import afin.Afin;
import figure.*;
import primitivs.Point;
import primitivs.Line;
import primitivs.Poligon;
import window.FigureDraw;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.List;

public class JPanelDraw extends JPanel implements FigureDraw {
    private Timer animator;
    private List<PointFigure> pointFigures = new ArrayList<>();
    private List<LineFigure> lineFigures = new ArrayList<>();
    private List<PoligonFigure> poligonFigures = new ArrayList<>();

    JPanelDraw() {
        setBackground(Color.BLACK);
        setVisible(true);

        animator = new Timer (15, e -> {repaint();});
        animator.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); //сглаживание
        graphics2D.setStroke(new BasicStroke(2));


        for (PoligonFigure figure: poligonFigures) {
            for (Poligon poligon: figure.getPoligons()) {
                graphics2D.setColor(poligon.color);

                int[] arrayX = new int[poligon.points.length];
                int[] arrayY = new int[poligon.points.length];
                for (int i = 0; i < poligon.points.length; i++) {
                    Point point1 = Afin.priekt(poligon.points[i]);
                    arrayX[i] = (int)point1.getX();
                    arrayY[i] = (int)point1.getY();
                }
                GeneralPath genPath = new GeneralPath();
                genPath.moveTo(arrayX[0], arrayY[0]);
                for(int inn = 1; inn < arrayX.length; inn++)
                    genPath.lineTo(arrayX[inn], arrayY[inn]);
                genPath.closePath();
                graphics2D.draw(genPath);

                graphics2D.fill(genPath);
            }
        }

        for (LineFigure figure: lineFigures) {
            graphics2D.setColor(figure.getLineColor());
            for (Line realLine: figure.getLines()) {
                Point point1 = Afin.priekt(realLine.point1);
                Point point2 = Afin.priekt(realLine.point2);
                graphics2D.drawLine((int)point1.getX(), (int)point1.getY(), (int)point2.getX(), (int)point2.getY());
            }
        }

        for (PointFigure figure: pointFigures) {
            graphics2D.setColor(figure.getPointColor());
            for (Point realPoint: figure.getPoints()) {
                Point point = Afin.priekt(realPoint);
                graphics2D.draw(new Ellipse2D.Float((float) point.getX() - 3, (float) point.getY() - 3, 7, 7));
            }
        }
    }

    @Override
    public void add(PointFigure pointFigure) {
        pointFigures.add(pointFigure);
    }

    @Override
    public List<PointFigure> getPointFigures() {
        return pointFigures;
    }

    @Override
    public void add(LineFigure lineFigure) {
        lineFigures.add(lineFigure);
    }

    @Override
    public void add(PoligonFigure figure) {
        poligonFigures.add(figure);
    }
}
