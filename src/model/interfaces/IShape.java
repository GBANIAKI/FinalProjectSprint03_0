package model.interfaces;

import model.ShapeConfiguration;
import model.Point;
import java.awt.*;
import java.awt.geom.Point2D;


public interface IShape {
    public Point getStartPoint();
    public Point getEndPoint();
    public IShapeConfiguration getShapeConfiguration();
    public void setStartPoint(Point newPoint );
    public void setEndPoint(Point newPoint);
    public void draw(Graphics2D graphics2D, IDrawShapeStrategy drawerShapeStrategy);
    public IShape deepCopy();
}
