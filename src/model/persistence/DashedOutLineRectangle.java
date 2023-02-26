package model.persistence;

import model.Point;
import model.interfaces.IDecorator;
import model.interfaces.IDrawShapeStrategy;
import model.interfaces.IShape;
import view.gui.DrawTriangleStrategy;

import java.awt.*;

public class DashedOutLineRectangle implements IDecorator {
    //private boolean isSelectedShape;

    private IDrawShapeStrategy drawShapeStrategy;
    private boolean isSelectedShape;
   public  DashedOutLineRectangle(IDrawShapeStrategy drawShapeStrategy,boolean isSelectedShape){
       //this.isSelectedShape=isSelectedShape;
       this.drawShapeStrategy=drawShapeStrategy;//drawShapeStrategy;
       this.isSelectedShape=isSelectedShape;
   }



    @Override
    public void drawOutLine(Graphics2D graphics2D, IShape shape) {
        this.drawShapeStrategy.drawOutLine(graphics2D, shape);
        if(this.isSelectedShape==true) {
            int width = shape.getEndPoint().getX() - shape.getStartPoint().getX();
            int height = shape.getEndPoint().getY() - shape.getStartPoint().getY();
            //graphics2D.setColor(ShapeColorMap.getMappingForShapeColor(shape.
            //  getShapeConfiguration().getActivePrimaryColor()));
            //graphics2D.setStroke(new BasicStroke(4));
            //Jeffrey Sharpe 5:55 PM
            Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
            graphics2D.setStroke(stroke);
            graphics2D.setColor(Color.BLACK);
            //graphics2d.drawRect(7, 8, 210, 410);
            graphics2D.drawRect(shape.getStartPoint().getX() - 5, shape.getStartPoint().getY() - 5, width + 10, height + 10);
        }
        //this.drawShapeStrategy.drawOutLine(graphics2D, shape);
    }

    @Override
    public void drawFilledIn(Graphics2D graphics2D, IShape shape) {
        this.drawShapeStrategy.drawFilledIn(graphics2D, shape);
        if(this.isSelectedShape==true) {
            int width = shape.getEndPoint().getX() - shape.getStartPoint().getX();
            int height = shape.getEndPoint().getY() - shape.getStartPoint().getY();
            //graphics2D.setColor(ShapeColorMap.getMappingForShapeColor(shape.
            //  getShapeConfiguration().getActivePrimaryColor()));
            //graphics2D.setStroke(new BasicStroke(4));
            //Jeffrey Sharpe 5:55 PM
            Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
            graphics2D.setStroke(stroke);
            graphics2D.setColor(Color.BLACK);
            //graphics2d.drawRect(7, 8, 210, 410);
            graphics2D.drawRect(shape.getStartPoint().getX() - 5, shape.getStartPoint().getY() - 5, width + 10, height + 10);
        }
      //this.drawShapeStrategy.drawFilledIn(graphics2D, shape);
    }

}
