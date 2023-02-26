package model;

import model.interfaces.IShapeList;
import model.interfaces.IShapeListManager;

public class NullShapeListManager implements IShapeListManager {
    @Override
    public MasterShapeList getMasterShapeList() {
        return null;
    }

    @Override
    public IShapeList getSelectedShapeList() {
        return null;
    }

    @Override
    public IShapeList getClipBoardShapeList() {
        return null;
    }
}
