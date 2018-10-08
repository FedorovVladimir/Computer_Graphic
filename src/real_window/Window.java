package real_window;

import figure.LineFigure;
import figure.PointFigure;
import figure.PoligonFigure;
import window.FigureDraw;

import javax.swing.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

public class Window implements FigureDraw {
    private JFrame window = new JFrame("Computer Graphic");
    private JPanelDraw jPanelDraw = new JPanelDraw();

    public Window() {
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

        window.add(jPanelDraw);
        window.setVisible(true);
    }

    public void addMouseMotionListener(MouseMotionListener mouseMotionListener) {
        window.addMouseMotionListener(mouseMotionListener);
    }

    public void addKeyListener(KeyListener keyListener) {
        window.addKeyListener(keyListener);
    }

    @Override
    public void add(LineFigure lineFigure) {
        jPanelDraw.add(lineFigure);
    }

    @Override
    public void add(PointFigure figure) {
        jPanelDraw.add(figure);
    }

    @Override
    public List<PointFigure> getPointFigures() {
        return jPanelDraw.getPointFigures();
    }

    @Override
    public String toString() {
        return jPanelDraw.toString();
    }

    @Override
    public void add(PoligonFigure figure) {
        jPanelDraw.add(figure);
    }

    public JFrame getWindow() {
        return window;
    }
}
