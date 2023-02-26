package model.interfaces;

import java.awt.*;

public interface IDrawShapeStrategy {
    void drawOutLine(Graphics2D graphics2D, IShape shape);
    void drawFilledIn(Graphics2D graphics2D, IShape shape);
}
