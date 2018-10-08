package figure;

import primitivs.Line;

import java.awt.*;

public interface LineFigure {
    Line[] getLines();
    Color getLineColor();
    void setLineColor(Color color);
}
