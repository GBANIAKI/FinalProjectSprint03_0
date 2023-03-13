package model.interfaces;

import java.util.ArrayList;

public interface IGroupedShapes extends IShape{
    void addIShape(IShape ishape);
    void removeIShape(IShape iShape);
    ArrayList<IShape> getChildIShapes();
    void setChildIShapes(ArrayList<IShape>childIShapes );
     void coordinateCollision();
    void clear();


}
