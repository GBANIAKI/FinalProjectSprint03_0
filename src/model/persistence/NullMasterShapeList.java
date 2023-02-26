package model.persistence;

import model.interfaces.IDrawObserver;
import model.interfaces.IDrawSubject;
import model.interfaces.IShape;

import java.util.ArrayList;

public class NullMasterShapeList implements IDrawSubject {
    @Override
    public void registerObserver(IDrawObserver observerDrawer) {

    }

    @Override
    public void removeObserver(IDrawObserver observerDrawer) {

    }

    @Override
    public void notifyObserver() {

    }

    @Override
    public ArrayList<IShape> getShapeList() {
        return null;
    }

    @Override
    public void add(IShape shape) {

    }

    @Override
    public void remove(IShape lastShapeDrawn) {

    }

    @Override
    public void shapeModified() {

    }
}
