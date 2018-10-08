import figure.*;
import real_figure.Osi;
import real_figure.RectangularParallelepiped;
import real_window.KeyBoard;
import real_window.Mouse;
import real_window.Window;
import real_window.WindowPoligon;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Osi osi = new Osi(250);
        osi.setLineColor(Color.GRAY);
        osi.setPointColor(Color.GRAY);

        RectangularParallelepiped cube = new RectangularParallelepiped(150,150,150);
        cube.setCenterX(0);
        cube.setCenterY(0);
        cube.setCenterZ(0);
        cube.setPoligonColor(new Color(255, 245, 122));
        cube.setLineColor(new Color(255, 181, 16));
        cube.setPointColor(new Color(181, 71,0));

        cube.getPoligons()[0].color = Color.RED;
        cube.getPoligons()[1].color = Color.BLUE;
        cube.getPoligons()[2].color = Color.GREEN;
        cube.getPoligons()[3].color = Color.YELLOW;
        cube.getPoligons()[4].color = Color.WHITE;
        cube.getPoligons()[5].color = Color.CYAN;

        Window window = new Window();
        window.add((PointFigure) osi);
        window.add((LineFigure) osi);

        window.add((PointFigure) cube);
        window.add((LineFigure) cube);
//        window.add((PoligonFigure) cube);
        window.addMouseMotionListener(new Mouse(cube));
        window.addKeyListener(new KeyBoard(cube));

        WindowPoligon windowPoligon = new WindowPoligon();
        windowPoligon.add(cube);
        windowPoligon.addMouseMotionListener(new Mouse(cube));
        windowPoligon.addKeyListener(new KeyBoard(cube));

        window.getWindow().setLocation(window.getWindow().getLocation().x - 400, window.getWindow().getLocation().y);
        windowPoligon.getWindow().setLocation(windowPoligon.getWindow().getLocation().x + 400, windowPoligon.getWindow().getLocation().y);
    }
}
