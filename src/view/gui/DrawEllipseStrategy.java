package view.gui;

import model.ShapeColorMap;
import model.interfaces.IDrawShapeStrategy;
import model.interfaces.IShape;

import java.awt.*;

public class DrawEllipseStrategy implements IDrawShapeStrategy {
    DrawEllipseStrategy(){
    }
    @Override
    public void drawOutLine(Graphics2D graphics2D, IShape shape) {
         int width = shape.getEndPoint().getX() - shape.getStartPoint().getX();
         int height =shape.getEndPoint().getY() - shape.getStartPoint().getY();
        graphics2D.setColor(ShapeColorMap.getMappingForShapeColor(shape.
                getShapeConfiguration().getActivePrimaryColor()));
        graphics2D.setStroke(new BasicStroke(4));
        graphics2D.drawOval(shape.getStartPoint().getX() ,shape.getStartPoint().getY(),width,height );
    }

    @Override
    public void drawFilledIn(Graphics2D graphics2D, IShape shape) {
        int width=shape.getEndPoint().getX() - shape.getStartPoint().getX();
        int height = shape.getEndPoint().getY() - shape.getStartPoint().getY();
        graphics2D.setColor(ShapeColorMap.getMappingForShapeColor(shape.
                getShapeConfiguration().getActiveSecondaryColor()));

        graphics2D.fillOval(shape.getStartPoint().getX() ,shape.getStartPoint().getY(),width,height );

    }
}
