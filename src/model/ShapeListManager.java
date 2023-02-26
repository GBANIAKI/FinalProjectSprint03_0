package model;

import model.interfaces.IDrawSubject;
import model.interfaces.IShapeList;
import model.interfaces.IShapeListManager;
import model.persistence.NullClipBoardShapeList;
import model.persistence.NullMasterShapeList;
import model.persistence.NullSelectedShapeList;

public class ShapeListManager implements IShapeListManager {
    private final IDrawSubject masterShapeList;
    private final IShapeList selectedShapeList;
    private final IShapeList clipBoardShapeList;
    public ShapeListManager( IDrawSubject masterShapeList,
    IShapeList selectedShapeList,
    IShapeList clipBoardShapeList){
        if(masterShapeList==null)
            masterShapeList=new NullMasterShapeList();
        this.masterShapeList= masterShapeList;
        if(selectedShapeList==null)
            selectedShapeList=new NullSelectedShapeList();
        this.selectedShapeList = selectedShapeList;
        if(clipBoardShapeList==null)
            clipBoardShapeList=new NullClipBoardShapeList();
        this.clipBoardShapeList= clipBoardShapeList;
    }
     public IDrawSubject getMasterShapeList(){
        return this.masterShapeList;
    }
    public  IShapeList getSelectedShapeList(){
        return this.selectedShapeList;
    }
    public IShapeList getClipBoardShapeList(){
        return this.clipBoardShapeList;
    }
}
