package commands;

import controller.ICommand;
//import model.MasterShapeList;
import model.Point;
//import model.ShapeListManager;
import model.interfaces.*;

import java.util.ArrayList;

public class MoveShapeCommand implements ICommand, IUndoable {
    private final IDrawSubject masterShapeList;
    private final IShapeList selectedShapeList;
    private final ArrayList<IShape>localShapeList = new ArrayList<>();
    private final int differenceX;
    private final int differenceY;
    public MoveShapeCommand(IShapeListManager shapeListManager, Point moveStartPoint, Point moveEndPoint){
        this.masterShapeList = shapeListManager.getMasterShapeList();
        this.selectedShapeList = shapeListManager.getSelectedShapeList();
        this.differenceX = moveEndPoint.getX() - moveStartPoint.getX();
        this.differenceY = moveEndPoint.getY() - moveStartPoint.getY();

    }

    @Override
    public void run() {
       if(!selectedShapeList.getShapeList().isEmpty()){
           for(IShape shape: selectedShapeList.getShapeList()){
               Point startPoint= shape.getStartPoint();
               Point endPoint = shape.getEndPoint();
               shape.setStartPoint(new Point(startPoint.getX()+ this.differenceX,startPoint.getY()+ this.
                       differenceY));
               shape.setEndPoint(new Point(endPoint.getX()+ this.differenceX, endPoint.getY()+ this.
                               differenceY));
               localShapeList.add(shape);
           }
           masterShapeList.shapeModified();
           CommandHistory.add(this);
       }
    }

    @Override
    public void undo() {
        if(!localShapeList.isEmpty()){
            for(IShape shape: localShapeList){
                Point startPoint = shape.getStartPoint();
                Point endPoint = shape.getEndPoint();
                shape.setStartPoint(new Point(startPoint.getX()- differenceX, startPoint.getY() - differenceY));
                shape.setEndPoint(new Point(endPoint.getX() - differenceX, endPoint.getY() - differenceY));
            }
            masterShapeList.shapeModified();
        }

    }

    @Override
    public void redo() {
        if(!localShapeList.isEmpty()){
            for(IShape shape: localShapeList){
                 Point startPoint =shape.getStartPoint();
                 Point endPoint = shape.getEndPoint();
                 shape.setStartPoint(new Point(startPoint.getX()+ differenceX,startPoint.
                         getY()+ differenceY));
                 shape.setEndPoint(new Point(endPoint.getX()+ differenceX,endPoint.getY() + differenceY ));


            }
            masterShapeList.shapeModified();
        }

    }
}
