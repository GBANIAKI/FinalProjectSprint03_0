package commands;

import controller.ICommand;
import commands.CommandHistory;
import model.MasterShapeList;
import model.Point;
import model.ShapeListManager;
import model.interfaces.IShape;
import model.interfaces.IShapeList;
import model.interfaces.IUndoable;
import model.persistence.ApplicationState;

public class UndoCommand implements ICommand{




    @Override
    public void run() {
        CommandHistory.undo();

    }

}
