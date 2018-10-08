package real_window;

import afin.Afin;
import figure.PointFigure;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseMotionListener {

    private int mouseX = 0;
    private int mouseY = 0;
    private PointFigure figure;

    public Mouse(PointFigure figure) {
        this.figure = figure;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int dx = mouseX - e.getX();
        int dy = mouseY - e.getY();
        mouseX = e.getX();
        mouseY = e.getY();

        if (dx > 10 || dy > 10)
            return;

        double x = figure.getCenterX();
        double y = figure.getCenterY();
        double z = figure.getCenterZ();
        Afin.translation(-x, -y, -z, figure);
        Afin.rotationY(-dx * 3.1415 / 180, figure);
        Afin.rotationX(-dy * 3.1415 / 180, figure);
        Afin.translation(x, y, z, figure);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
