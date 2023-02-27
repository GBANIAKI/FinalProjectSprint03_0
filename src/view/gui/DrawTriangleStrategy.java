package view.gui;

import model.ShapeColorMap;
import model.interfaces.IDrawShapeStrategy;
import model.interfaces.IShape;
import model.Point;

import java.awt.*;

public class DrawTriangleStrategy implements IDrawShapeStrategy {
    public DrawTriangleStrategy(){}
    @Override
    public void drawOutLine(Graphics2D graphics2D, IShape shape) {



        graphics2D.setColor(ShapeColorMap.getMappingForShapeColor(shape.
                getShapeConfiguration().getActivePrimaryColor()));
        graphics2D.setStroke(new BasicStroke(4));
        graphics2D.drawPolygon(getXPoints(shape.
                getStartPoint(),shape.getEndPoint()),getYPoints(shape.
                getStartPoint(),shape.getEndPoint()),3);

    }

    @Override
    public void drawFilledIn(Graphics2D graphics2D, IShape shape) {
        graphics2D.setColor(ShapeColorMap.getMappingForShapeColor(shape.
                getShapeConfiguration().getActiveSecondaryColor()));

        graphics2D.fillPolygon(getXPoints(shape.
                getStartPoint(),shape.getEndPoint()),getYPoints(shape.
                getStartPoint(),shape.getEndPoint()),3);

    }
    private int [] getXPoints(Point startPoint,Point endPoint){
        int[] xPoints= new int[3];
        xPoints[0] = startPoint.getX();
        xPoints[1] = startPoint.getX();

        xPoints[2]=endPoint.getX();
        return xPoints;

    }
    private int[] getYPoints(Point startPoint, Point endPoint){
        int[] yPoints = new int[3];
        yPoints[0] = startPoint.getY();
        yPoints[1] = endPoint.getY();
        yPoints[2]=endPoint.getY();
        return yPoints;

    }
}
