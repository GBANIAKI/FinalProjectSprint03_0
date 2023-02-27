package commands;

import controller.ICommand;
import model.*;
import model.Point;
import model.interfaces.*;
//import view.gui.DrawShapeStrategyFactory;
//import view.gui.*;
//import java.awt.Graphics2D;

//import javax.swing.*;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.util.ArrayList;

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
       //IShape selectedShape=null;
        for(IShape shape: this.masterShapeList.getShapeList()){
            if(CollisionDetector.detectCollision(shape, selectionStartPoint, selectionEndPoint)){
                selectedShapeList.add(shape);
                setIsSelectedShape(this.isSelectedShape);
                //selectedShape=shape;

            }

        }
        for(IDrawObserver observer: this.masterShapeList.getObservers()){
            System.out.println(observer);
            observer.update(this.selectedShapeList.getShapeList());
            //observer.setDrawShapeStrategyFactory(selectedShape);
            setIsSelectedShape(false);
           //observer.update();
            //observer =null;
        }
        //setIsSelectedShape(false);

        System.out.println(selectedShapeList);
    }
}
