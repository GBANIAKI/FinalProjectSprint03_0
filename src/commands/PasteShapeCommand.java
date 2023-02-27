package commands;

import controller.ICommand;
//import model.MasterShapeList;
//import model.Point;
import model.NullShapeListManager;
import model.interfaces.*;

import java.util.ArrayList;

public class PasteShapeCommand implements ICommand, IUndoable {
    private final IDrawSubject masterShapeList;
    private final IShapeList clipBoardShapeList;
    private final ArrayList<IShape> pastedShapeList=new ArrayList<>();
    public PasteShapeCommand(IShapeListManager shapeListManager){
        if(shapeListManager==null)
            new NullShapeListManager();
        this.masterShapeList=shapeListManager.getMasterShapeList();
        this.clipBoardShapeList=shapeListManager.getClipBoardShapeList();
        //this.pastedShapes= new ArrayList<>();

    }

    @Override
    public void run() {
        if(!clipBoardShapeList.getShapeList().isEmpty()){
            for(IShape shape:clipBoardShapeList.getShapeList()){
               IShape pastedShape=shape.deepCopy();
               //pastedShape.setStartPoint(new Point(shape.getStartPoint().getX()+10, shape.getEndPoint().getY()+10));
               //pastedShape.setEndPoint(new Point(shape.getStartPoint().getX()+10, shape.getEndPoint().getY()+10));
               masterShapeList.add(pastedShape);
               pastedShapeList.add(pastedShape);

            }
            masterShapeList.shapeModified();
            CommandHistory.add(this);

        }

    }

    @Override
    public void undo() {
        for(IShape shape:pastedShapeList){
            masterShapeList.remove(shape);
        }

    }

    @Override
    public void redo() {
        for(IShape shape:pastedShapeList){
            masterShapeList.add(shape);
        }

    }
}
