package model.interfaces;

import model.MasterShapeList;

public interface IShapeListManager {
    IDrawSubject getMasterShapeList();
     IShapeList getSelectedShapeList();
     IShapeList getClipBoardShapeList();

}
