package window;

import figure.PointFigure;

import java.util.List;

public interface PointFigureDraw {
    void add(PointFigure figure);

    List<PointFigure> getPointFigures();
}
