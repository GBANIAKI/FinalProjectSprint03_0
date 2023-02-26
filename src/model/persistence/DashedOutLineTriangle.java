package model.persistence;

import model.Point;
import model.ShapeColorMap;
import model.interfaces.IDrawShapeStrategy;
import model.interfaces.IShape;

import java.awt.*;

public class DashedOutLineTriangle implements IDrawShapeStrategy {
    IDrawShapeStrategy drawShapeStrategy;
    private boolean isSelectedShape;
    public DashedOutLineTriangle(IDrawShapeStrategy drawShapeStrategy,boolean isSelectedShape){
        this.drawShapeStrategy=drawShapeStrategy;
        this.isSelectedShape= isSelectedShape;

    }
    @Override
    public void drawOutLine(Graphics2D graphics2D, IShape shape) {
        this.drawShapeStrategy.drawOutLine(graphics2D, shape);
        if(this.isSelectedShape==true) {
            // graphics2D.setColor(ShapeColorMap.getMappingForShapeColor(shape.
            //getShapeConfiguration().getActivePrimaryColor()));
            //graphics2D.setStroke(new BasicStroke(4));
            Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
            graphics2D.setStroke(stroke);
            graphics2D.setColor(Color.BLACK);
            //graphics2d.drawRect(7, 8, 210, 410);
            //graphics2D.drawRect(shape.getStartPoint().getX()-5 ,shape.getStartPoint().getY()-5,width+10,height+10 );

            //this.drawShapeStrategy.drawOutLine(graphics2D, shape);
            graphics2D.drawPolygon(getXPoints(shape.
                    getStartPoint(), shape.getEndPoint()), getYPoints(shape.
                    getStartPoint(), shape.getEndPoint()), 3);
            //this.drawShapeStrategy.drawOutLine(graphics2D, shape);
        }
    }

    @Override
    public void drawFilledIn(Graphics2D graphics2D, IShape shape) {
        this.drawShapeStrategy.drawOutLine(graphics2D, shape);
        if(this.isSelectedShape==true) {
            Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
            graphics2D.setStroke(stroke);
            graphics2D.setColor(Color.BLACK);
            //graphics2d.drawRect(7, 8, 210, 410);
            //graphics2D.drawRect(shape.getStartPoint().getX()-5 ,shape.getStartPoint().getY()-5,width+10,height+10 );
            graphics2D.drawPolygon(getXPoints(shape.
                    getStartPoint(), shape.getEndPoint()), getYPoints(shape.
                    getStartPoint(), shape.getEndPoint()), 3);
            //this.drawShapeStrategy.drawFilledIn(graphics2D, shape);
        }
    }

    private int [] getXPoints(Point startPoint, Point endPoint){
        int[] xPoints= new int[3];
        xPoints[0] = startPoint.getX()-5;
        xPoints[1] = startPoint.getX()-5;
        // xPoints[1] = endPoint.getX();

        //xPoints[2]=startPoint.getX();
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
