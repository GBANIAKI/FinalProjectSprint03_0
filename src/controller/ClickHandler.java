package controller;

import commands.*;

import model.NullShapeListManager;
import model.ShapeListManager;

import model.Point;

import model.interfaces.IApplicationState;
import model.interfaces.IShapeListManager;
import model.persistence.ApplicationState;
import model.persistence.NullApplicationState;
import view.gui.DrawShapeStrategyFactory;
import view.gui.DrawTriangleStrategy;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static view.gui.DrawShapeStrategyFactory.*;

public class ClickHandler extends MouseAdapter {

    public Point startPoint;
    public  Point endPoint;
    private final IApplicationState applicationState;
    private final IShapeListManager shapeListManager;
     public ClickHandler(IApplicationState applicationState, IShapeListManager shapeListManager ){
         if(applicationState==null)
             applicationState =new NullApplicationState();
         this.applicationState=applicationState;
         if(shapeListManager==null)
             shapeListManager=new NullShapeListManager();
         this.shapeListManager= shapeListManager;

     }

    @Override
    public void mousePressed(MouseEvent e) {

        this.startPoint= new Point(e.getX(),e.getY());

    }

    @Override
    public void mouseReleased(MouseEvent e) {


        this.endPoint= new Point(e.getX(),e.getY());
        Point topLeft = new Point(Integer.min(this.startPoint.getX(),this.endPoint.getX()),
                Integer.min(this.startPoint.getY(),this.endPoint.getY()));
        Point bottomRight = new Point(Integer.max(this.startPoint.getX(),this.endPoint.getX()),
                Integer.max(this.startPoint.getY(),this.endPoint.getY()));
        ICommand command;
        switch (applicationState.getActiveMouseMode()){

            case SELECT:
                shapeListManager.getSelectedShapeList().getShapeList().clear();

                command= new SelectShapeCommand(shapeListManager,topLeft,bottomRight, true);
                break;
            case MOVE:
                command= new MoveShapeCommand(shapeListManager,this.startPoint,this.endPoint);
                break;
            case DRAW:

            default:
                command = new DrawShapeCommand(shapeListManager,applicationState,topLeft, bottomRight );

        }

        command.run();


     }
}

