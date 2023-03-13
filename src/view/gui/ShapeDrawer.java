package view.gui;

import model.interfaces.IDrawObserver;
import model.interfaces.IDrawShapeStrategy;
import model.interfaces.IShape;


import java.awt.*;
import java.util.ArrayList;

public class ShapeDrawer implements IDrawObserver {
 private final PaintCanvas paintCanvas;

 public ShapeDrawer(PaintCanvas paintCanvas){
     this.paintCanvas= paintCanvas;
 }


    public void    update(ArrayList<IShape> shapeList, boolean isSelectedShape) {

     System.out.println(shapeList);
     for(IShape shape:  shapeList){
         if(shape.getShapeConfiguration()==null) {
             shape.draw((Graphics2D) paintCanvas.getGraphics(), null);
             break;
         }
         IDrawShapeStrategy drawerShapeStrategy;
         switch(shape.getShapeConfiguration().getActiveShapeType()){
             case RECTANGLE:
                 drawerShapeStrategy=DrawShapeStrategyFactory.createDrawRectangleStrategy(isSelectedShape);
                 break;
             case ELLIPSE:
                 drawerShapeStrategy=DrawShapeStrategyFactory.createDrawEllipseStrategy(isSelectedShape);
                 break;
             case TRIANGLE:
                 drawerShapeStrategy=DrawShapeStrategyFactory.createDrawTriangleStrategy(isSelectedShape);
                 break;
               default:
                 throw new Error("error");
         }
        shape.draw((Graphics2D) paintCanvas.getGraphics(),drawerShapeStrategy);
     }

    }
public void update(){
     paintCanvas.repaint();
}


/*public void setDrawShapeStrategyFactory(IShape shape) {
    IDrawShapeStrategy drawerShapeStrategy;
    switch (shape.getShapeConfiguration().getActiveShapeType()) {
        case RECTANGLE:
            drawerShapeStrategy = DrawShapeStrategyFactory.createDrawRectangleStrategy(shape.getIsSelectedShape());
            break;
        case ELLIPSE:
            drawerShapeStrategy = DrawShapeStrategyFactory.createDrawEllipseStrategy(shape.getIsSelectedShape());
            break;
        case TRIANGLE:
            drawerShapeStrategy = DrawShapeStrategyFactory.createDrawTriangleStrategy(shape.getIsSelectedShape());
            break;
        default:
            throw new Error("error");
    }
    shape.draw((Graphics2D) paintCanvas.getGraphics(), drawerShapeStrategy);

}*/
}
