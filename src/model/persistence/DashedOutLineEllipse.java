package model.persistence;

import model.interfaces.IDrawShapeStrategy;
import model.interfaces.IShape;

import java.awt.*;

public class DashedOutLineEllipse implements IDrawShapeStrategy {
    IDrawShapeStrategy drawShapeStrategy;
    private boolean isSelectedShape;
    public DashedOutLineEllipse(IDrawShapeStrategy drawShapeStrategy,boolean isSelectedShape){
        this.drawShapeStrategy=drawShapeStrategy;
        this.isSelectedShape=isSelectedShape;
    }
    @Override
    public void drawOutLine(Graphics2D graphics2D, IShape shape) {
        this.drawShapeStrategy.drawOutLine(graphics2D, shape);
        if(isSelectedShape==true) {
            int width = shape.getEndPoint().getX() - shape.getStartPoint().getX();
            int height = shape.getEndPoint().getY() - shape.getStartPoint().getY();
            Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
            graphics2D.setStroke(stroke);
            graphics2D.setColor(Color.BLACK);
            graphics2D.drawOval(shape.getStartPoint().getX() - 5, shape.getStartPoint().getY() - 5, width + 10, height + 10);
            //this.drawShapeStrategy.drawOutLine(graphics2D, shape);
        }
    }

    @Override
    public void drawFilledIn(Graphics2D graphics2D, IShape shape) {
        this.drawShapeStrategy.drawOutLine(graphics2D, shape);
        if(isSelectedShape==true) {
            int width = shape.getEndPoint().getX() - shape.getStartPoint().getX();
            int height = shape.getEndPoint().getY() - shape.getStartPoint().getY();
            Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
            graphics2D.setStroke(stroke);
            graphics2D.setColor(Color.BLACK);
            graphics2D.fillOval(shape.getStartPoint().getX() - 5, shape.getStartPoint().getY() - 5, width + 10, height + 10);
            this.drawShapeStrategy.drawFilledIn(graphics2D, shape);
        }

    }
}
