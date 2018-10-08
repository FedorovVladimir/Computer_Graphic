package real_window;

import figure.PoligonFigure;
import window.PoligonFigureDraw;

import javax.swing.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseMotionListener;

public class WindowPoligon implements PoligonFigureDraw {
    private JFrame window = new JFrame("Computer Graphic");
    private JPanelPoligonDraw jPanelPoligonDraw = new JPanelPoligonDraw();

    public WindowPoligon() {
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

        window.add(jPanelPoligonDraw);
        window.setVisible(true);
    }

    public void addMouseMotionListener(MouseMotionListener mouseMotionListener) {
        window.addMouseMotionListener(mouseMotionListener);
    }

    public void addKeyListener(KeyListener keyListener) {
        window.addKeyListener(keyListener);
    }

    @Override
    public void add(PoligonFigure figure) {
        jPanelPoligonDraw.add(figure);
    }

    public JFrame getWindow() {
        return window;
    }
}
