package commands;

import controller.ICommand;
//import model.ShapeListManager;
import model.NullShapeListManager;
import model.interfaces.IShape;
import model.interfaces.IShapeList;
import model.interfaces.IShapeListManager;

public class CopyCommand implements ICommand {
    private final IShapeList selectedShapeList;
    private final IShapeList clipBoardShapeList;
    public CopyCommand(IShapeListManager shapeListManager){
        if(shapeListManager==null)
             new NullShapeListManager();

        this.selectedShapeList= shapeListManager.getSelectedShapeList();
        this.clipBoardShapeList=shapeListManager.getClipBoardShapeList();
    }

    @Override
    public void run() {
        clipBoardShapeList.getShapeList().clear();
        for(IShape shape: selectedShapeList.getShapeList())
            clipBoardShapeList.add(shape.deepCopy());


    }
}
