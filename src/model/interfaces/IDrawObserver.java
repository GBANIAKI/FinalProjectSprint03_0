package model.interfaces;

import java.awt.*;
import java.util.ArrayList;

public interface IDrawObserver {
    void update();
   void  update(ArrayList<IShape> shapeList);
    void setDrawShapeStrategyFactory(IShape shape);
}
