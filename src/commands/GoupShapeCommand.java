package commands;

import controller.ICommand;
import model.GroupedShapes;
import model.ShapeListManager;
import model.interfaces.*;
import view.gui.PaintCanvas;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import java.util.Collections;

public class GoupShapeCommand implements ICommand, IUndoable {
     IGroupedShapes groupedShapes;
    private final IShapeListManager shapeListManager;
     IGroupedShapes LastGroupedShapes;
     //private PaintCanvas paintCanvas;

    public GoupShapeCommand(IShapeListManager shapeListManager) {
        this.shapeListManager= shapeListManager;
        //this.paintCanvas=paintCanvas;
       // this.groupedShapes = new GroupedShapes(null, null, null);
    }

    @Override
    public void run() {
        this.groupedShapes = new GroupedShapes(this.shapeListManager.getMasterShapeList().getShapeList());
        this.groupedShapes.coordinateCollision();
        this.groupedShapes.setStartPoint(this.groupedShapes.getStartPoint());
        this.groupedShapes.setEndPoint(this.groupedShapes.getEndPoint());
        //this.groupedShapes.
        //this.groupedShapes.clear();
        /*for(int i=0; i<this.shapeListManager.getMasterShapeList().getShapeList().size(); i++)
             this.groupedShapes.getChildIShapes().
                     add(this.shapeListManager.getMasterShapeList().getShapeList().get(i));*/
     System.out.println(this.groupedShapes);
        //this.groupedShapes.getChildIShapes().add(this.groupedShapes);
          /* if(!this.shapeListManager.getSelectedShapeList().getShapeList().isEmpty()){
               //this.shapeListManager.getSelectedShapeList().getShapeList()

            for( IShape shape:this.shapeListManager.getSelectedShapeList().getShapeList()){

                    this.shapeListManager.getSelectedShapeList().getShapeList().remove(shape);

                }
               this.shapeListManager.getSelectedShapeList().getShapeList().clear();
            }*/
          // this.groupedShapes.setStartPoint(this.groupedShapes.getStartPoint());
           //this.groupedShapes.setEndPoint(this.groupedShapes.getEndPoint());
       // this.groupedShapes.coordinateCollision();
         // this.groupedShapes.draw();
        this.shapeListManager.getMasterShapeList().add(this.groupedShapes);
        this.LastGroupedShapes=this.groupedShapes;

        CommandHistory.add(this);
       // paintCanvas.repaint();


    }

    @Override
    public void undo() {
        this.shapeListManager.getMasterShapeList().remove(this.LastGroupedShapes);
        System.out.println(this.shapeListManager.getMasterShapeList());

    }

    @Override
    public void redo() {
        this.shapeListManager.getMasterShapeList().add(this.LastGroupedShapes);
    }
}
