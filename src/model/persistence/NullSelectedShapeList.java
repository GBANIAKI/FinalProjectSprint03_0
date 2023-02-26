package model.persistence;

import model.ShapeList;
import model.interfaces.IShape;
import model.interfaces.IShapeList;

import java.util.ArrayList;

public class NullSelectedShapeList extends ShapeList implements IShapeList {
    @Override
    public void add(IShape shape) {

    }

    @Override
    public void remove(IShape shape) {

    }

    @Override
    public ArrayList<IShape> getShapeList() {
        return null;
    }
}
