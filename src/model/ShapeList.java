package model;

import model.interfaces.IShape;
import model.interfaces.IShapeList;

import java.util.ArrayList;

public class ShapeList implements IShapeList {
    private final ArrayList<IShape> shapeList;
    public ShapeList(){
        this.shapeList =new ArrayList<>();

    }
    public void add(IShape shape){
        this.shapeList.add(shape);

    }

    @Override
    public void remove(IShape shape) {
        this.shapeList.remove(shape);
    }

    @Override
    public ArrayList<IShape> getShapeList() {
        return this.shapeList;
    }

}
