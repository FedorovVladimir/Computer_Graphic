package real_window;

import afin.Afin;
import figure.PointFigure;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoard implements KeyListener {

    private PointFigure figure;

    public KeyBoard(PointFigure figure) {
        this.figure = figure;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == '+') {
            figure.setCenterZ(figure.getCenterZ() + 10);
            Afin.translation(0,0,10, figure);
        }
        if (e.getKeyChar() == '-') {
            figure.setCenterZ(figure.getCenterZ() - 10);
            Afin.translation(0,0,-10, figure);
        }
        if (e.getKeyCode() == 38) {
            figure.setCenterY(figure.getCenterY() + 10);
            Afin.translation(0,10,0, figure);
        }
        if (e.getKeyCode() == 39) {
            figure.setCenterX(figure.getCenterX() + 10);
            Afin.translation(10,0,0, figure);
        }
        if (e.getKeyCode() == 40) {
            figure.setCenterY(figure.getCenterY() - 10);
            Afin.translation(0,-10,0, figure);
        }
        if (e.getKeyCode() == 37) {
            figure.setCenterX(figure.getCenterX() - 10);
            Afin.translation(-10,0,0, figure);
        }


        if (e.getKeyChar() == 'l') {
            double x = figure.getCenterX();
            double y = figure.getCenterY();
            double z = figure.getCenterZ();
            Afin.translation(-x, -y, -z, figure);
            Afin.dilatation(1/1.1,1/1.1,1/1.1, figure);
            Afin.translation(x, y, z, figure);
        }
        if (e.getKeyChar() == 'm') {
            double x = figure.getCenterX();
            double y = figure.getCenterY();
            double z = figure.getCenterZ();
            Afin.translation(-x, -y, -z, figure);
            Afin.dilatation(1.1,1.1,1.1, figure);
            Afin.translation(x, y, z, figure);
        }


        if (e.getKeyChar() == '1') {
            figure.setCenterZ(-figure.getCenterZ());
            Afin.reflectionXY(figure);
        }
        if (e.getKeyChar() == '2') {
            figure.setCenterX(-figure.getCenterX());
            Afin.reflectionYZ(figure);
        }
        if (e.getKeyChar() == '3') {
            figure.setCenterY(-figure.getCenterY());
            Afin.reflectionZX(figure);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
