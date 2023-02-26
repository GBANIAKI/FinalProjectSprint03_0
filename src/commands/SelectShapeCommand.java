package commands;

import controller.ICommand;
import model.CollisionDetector;
import model.MasterShapeList;
import model.Point;
import model.ShapeListManager;
import model.interfaces.*;
import view.gui.DrawShapeStrategyFactory;
import view.gui.*;
import java.awt.Graphics2D;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static view.gui.DrawShapeStrategyFactory.*;

public class SelectShapeCommand implements ICommand {
    private final IDrawSubject masterShapeList;
    private final IShapeList selectedShapeList;
    private final Point selectionStartPoint;
    private final Point selectionEndPoint;
    private final boolean isSelectedShape;
    public SelectShapeCommand(IShapeListManager shapeListManager, Point selectionStartPoint,
                              Point selectionEndPoint,boolean isSelectedShape){
        this.masterShapeList = shapeListManager.getMasterShapeList();
        this.selectedShapeList= shapeListManager.getSelectedShapeList();
        this.selectionStartPoint= selectionStartPoint;
        this.selectionEndPoint= selectionEndPoint;
        this.isSelectedShape=isSelectedShape;
    }


    @Override
    public void run() {
        for(IShape shape: masterShapeList.getShapeList()){
            if(CollisionDetector.detectCollision(shape, selectionStartPoint, selectionEndPoint)){
                selectedShapeList.add(shape);
                setIsSelectedShape(this.isSelectedShape);
               /*DrawShapeStrategy drawerShapeStrategy;

                switch(shape.getShapeConfiguration().getActiveShapeType()){
                    case RECTANGLE:
                        drawerShapeStrategy= createDrawRectangleStrategy();
                        break;
                    case ELLIPSE:
                        drawerShapeStrategy= createDrawEllipseStrategy();
                        break;
                    case TRIANGLE:
                        drawerShapeStrategy= createDrawTriangleStrategy();
                        break;
                    default:
                        throw new Error("error");
                }*/

            }

        }

        System.out.println(selectedShapeList);
    }
}
