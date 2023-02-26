package model.interfaces;

import java.util.ArrayList;

public interface IDrawSubject {
    public void registerObserver(IDrawObserver observerDrawer);
    public void removeObserver(IDrawObserver observerDrawer);
    public void notifyObserver();

    ArrayList<IShape> getShapeList();

    void add(IShape shape);

    void remove(IShape lastShapeDrawn);

    void shapeModified();
}
