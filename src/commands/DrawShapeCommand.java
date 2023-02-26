package commands;

import controller.ICommand;
import model.*;
import model.interfaces.*;
import model.persistence.ApplicationState;
import model.persistence.NullApplicationState;

import java.awt.geom.Point2D;

public class DrawShapeCommand implements ICommand, IUndoable{
    private final IDrawSubject masterShapeList;
    private final IShapeList selectedShapeList;
    private final IApplicationState appState;
     private final Point startPoint;
    private final Point endPoint;
    private IShape LastShapeDrawn;
    public DrawShapeCommand(IShapeListManager shapeListManager, IApplicationState appState,
                            Point startPoint, Point endPoint){
        if(shapeListManager==null)
            shapeListManager=new NullShapeListManager();
        this.masterShapeList=shapeListManager.getMasterShapeList();
        this.selectedShapeList=shapeListManager.getSelectedShapeList();
        if(appState==null)
            appState=new NullApplicationState();
        this.appState=appState;
        this.startPoint=startPoint;
        this.endPoint= endPoint;
        //this.LastShapeDrawn=stShapeDrawnLa;
    }


    public void run(){
        ShapeConfiguration shapeConfiguration= appState.getCurrentShapeConfiguration();
        IShape shape = ShapeFactory.createShape(this.startPoint, this.endPoint, shapeConfiguration);
        this.masterShapeList.add(shape);
        this.LastShapeDrawn=shape;
        CommandHistory.add(this);

    }
    public void undo(){
        this.masterShapeList.remove(this.LastShapeDrawn);
        System.out.println(masterShapeList);

        /*if(!this.selectedShapeList.getShapeList().isEmpty()){
            for(int i =0; i< this.selectedShapeList.getShapeList().size(); i++){
                if(this.selectedShapeList.getShapeList().get(i)==this.LastShapeDrawn){
                    this.selectedShapeList.getShapeList().remove(this.LastShapeDrawn);


                }
            }
        }*/

    }
    public void redo(){
        this.masterShapeList.add(this.LastShapeDrawn);
    }


}
