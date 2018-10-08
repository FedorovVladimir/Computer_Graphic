package figure;

import primitivs.Poligon;

import java.awt.*;

public interface PoligonFigure {
    Poligon[] getPoligons();

    Color getPoligonColor();

    void setPoligonColor(Color color);
}
