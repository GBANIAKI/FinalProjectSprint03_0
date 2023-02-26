package view.gui;

import model.interfaces.IDrawObserver;
import model.interfaces.IDrawShapeStrategy;
import model.interfaces.IShape;

import java.awt.*;
import java.util.ArrayList;

public class ShapeDrawer implements IDrawObserver {
 private final PaintCanvas paintCanvas;
 //private PaintCanvas
 //public IDrawShapeStrategy drawerShapeStrategy=null;
 public ShapeDrawer(PaintCanvas paintCanvas){
     this.paintCanvas= paintCanvas;
 }


    public void    update(ArrayList<IShape> shapeList) {

     System.out.println(shapeList);
     for(IShape shape:  shapeList){
         IDrawShapeStrategy drawerShapeStrategy;
         switch(shape.getShapeConfiguration().getActiveShapeType()){
             case RECTANGLE:
                 drawerShapeStrategy=DrawShapeStrategyFactory.createDrawRectangleStrategy();
                 break;
             case ELLIPSE:
                 drawerShapeStrategy=DrawShapeStrategyFactory.createDrawEllipseStrategy();
                 break;
             case TRIANGLE:
                 drawerShapeStrategy=DrawShapeStrategyFactory.createDrawTriangleStrategy();
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

}
