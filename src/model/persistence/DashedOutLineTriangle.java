package model.persistence;

import model.Point;
//import model.ShapeColorMap;
import model.interfaces.IDrawShapeStrategy;
import model.interfaces.IShape;

import java.awt.*;

public class DashedOutLineTriangle implements IDrawShapeStrategy {
    IDrawShapeStrategy drawShapeStrategy;
    private final boolean isSelectedShape;
    public DashedOutLineTriangle(IDrawShapeStrategy drawShapeStrategy,boolean isSelectedShape){
        this.drawShapeStrategy=drawShapeStrategy;
        this.isSelectedShape= isSelectedShape;

    }
    @Override
    public void drawOutLine(Graphics2D graphics2D, IShape shape) {
        this.drawShapeStrategy.drawOutLine(graphics2D, shape);
        if(this.isSelectedShape) {

            Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
            graphics2D.setStroke(stroke);
            graphics2D.setColor(Color.BLACK);
            graphics2D.drawPolygon(getXPoints(shape.
                    getStartPoint(), shape.getEndPoint()), getYPoints(shape.
                    getStartPoint(), shape.getEndPoint()), 3);

        }
    }

    @Override
    public void drawFilledIn(Graphics2D graphics2D, IShape shape) {
        this.drawShapeStrategy. drawFilledIn(graphics2D, shape);
        if(this.isSelectedShape) {
            Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
            graphics2D.setStroke(stroke);
            graphics2D.setColor(Color.BLACK);

            graphics2D.drawPolygon(getXPoints(shape.
                    getStartPoint(), shape.getEndPoint()), getYPoints(shape.
                    getStartPoint(), shape.getEndPoint()), 3);

        }
    }

    private int [] getXPoints(Point startPoint, Point endPoint){
        int[] xPoints= new int[3];
        xPoints[0] = startPoint.getX()-5;
        xPoints[1] = startPoint.getX()-5;

        xPoints[2]=endPoint.getX()+15;
        return xPoints;

    }
    private int[] getYPoints(Point startPoint, Point endPoint){
        int[] yPoints = new int[3];
        yPoints[0] = startPoint.getY()-9;
        yPoints[1] = endPoint.getY()+5;
        yPoints[2]=endPoint.getY()+5;
        return yPoints;

    }
}
