package commands;

import controller.ICommand;
import model.GroupedShapes;
import model.interfaces.IGroupedShapes;
import model.interfaces.IShapeListManager;
import model.interfaces.IUndoable;
import model.persistence.UngroupedShapes;

public class UngroupCommand implements ICommand, IUndoable {
    private GoupShapeCommand command;
    private final IShapeListManager shapeListManager;
    private IGroupedShapes lastUnGroupedShapes;

    public UngroupCommand(IShapeListManager shapeListManager){
        this.shapeListManager=shapeListManager;


    }

    @Override
    public void run() {



    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}
