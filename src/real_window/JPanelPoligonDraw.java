package real_window;

import figure.PoligonFigure;
import window.PoligonFigureDraw;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

public class JPanelPoligonDraw extends JPanel implements PoligonFigureDraw {
    private Timer animator;
    private List<PoligonFigure> poligonFigures = new ArrayList<>();

    JPanelPoligonDraw() {
        setBackground(Color.BLACK);
        setVisible(true);

        animator = new Timer (15, e -> {repaint();});
        animator.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D graphics2D = (Graphics2D) g;

        for (int i = 0; i < getHeight(); i++)
            drawLine(i, graphics2D);
    }

    private void drawLine(int i, Graphics2D graphics2D) {
        graphics2D.setColor(Color.RED);
        graphics2D.draw(new Line2D.Float(0, i, 200, i));
        // TODO: 02.10.2018  
    }

    @Override
    public void add(PoligonFigure figure) {
        poligonFigures.add(figure);
    }
}
