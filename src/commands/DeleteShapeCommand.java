package commands;

import controller.ICommand;
//import model.MasterShapeList;
//import model.ShapeList;
//import model.ShapeListManager;
import model.interfaces.*;

import java.util.ArrayList;

public class DeleteShapeCommand implements ICommand, IUndoable {
    private final IDrawSubject masterShapeList;
    private final IShapeList selectedShapeList;
    private final ArrayList<IShape> deletedShapeList= new ArrayList<>();


    public DeleteShapeCommand(IShapeListManager shapeListManager) {
        this.masterShapeList = shapeListManager.getMasterShapeList();
        this.selectedShapeList= shapeListManager.getSelectedShapeList();
    }


    @Override
    public void run() {
        if(!this.selectedShapeList.getShapeList().isEmpty()){
            for(IShape shape: this.selectedShapeList.getShapeList()){
                this.masterShapeList.remove(shape);
                this.masterShapeList.shapeModified();
                this.deletedShapeList.add(shape);
            }
            //this.masterShapeList.shapeModified();
            CommandHistory.add(this);
            this.selectedShapeList.getShapeList().clear();

        }

    }

    @Override
    public void undo() {
if(!this.deletedShapeList.isEmpty()){
    for(IShape shape: this.deletedShapeList){
        this.masterShapeList.add(shape);
    }
}
    }

    @Override
    public void redo() {
        if(!this.deletedShapeList.isEmpty()){
            for(IShape shape: this.deletedShapeList){
                this.masterShapeList.remove(shape);
            }
        }

    }
}
