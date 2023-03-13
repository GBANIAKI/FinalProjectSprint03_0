package model.persistence;

import model.Point;
import model.interfaces.IDrawShapeStrategy;
import model.interfaces.IGroupedShapes;
import model.interfaces.IShape;
import model.interfaces.IShapeConfiguration;

import java.awt.*;
import java.util.ArrayList;

public class UngroupedShapes implements IGroupedShapes {
    private Point startPoint;
    private Point endPoint ;
    private IShapeConfiguration shapeConfiguration;
    private ArrayList<IShape> childIShapes;
    private ArrayList<IShape> ungroupedShapes;

    public UngroupedShapes(ArrayList<IShape> childIShapes){
        this.startPoint=null;
        this.endPoint= null;
        this.shapeConfiguration=null;
        this.childIShapes = childIShapes;
        this.ungroupedShapes=null;

    }
    @Override
    public void addIShape(IShape ishape) {

    }

    @Override
    public void removeIShape(IShape iShape) {

    }

    @Override
    public ArrayList<IShape> getChildIShapes() {
        return null;
    }

    @Override
    public void setChildIShapes(ArrayList<IShape> childIShapes) {

    }

    @Override
    public void coordinateCollision() {

    }

    @Override
    public void clear() {

    }

    @Override
    public Point getStartPoint() {
        return null;
    }

    @Override
    public Point getEndPoint() {
        return null;
    }

    @Override
    public IShapeConfiguration getShapeConfiguration() {
        return null;
    }
    public ArrayList<IShape>getUngroupedShapes(){
        return this.ungroupedShapes;
    }

    @Override
    public void setStartPoint(Point newPoint) {

    }

    @Override
    public void setEndPoint(Point newPoint) {

    }

    @Override
    public void draw(Graphics2D graphics2D, IDrawShapeStrategy drawerShapeStrategy) {

    }

    @Override
    public IShape deepCopy() {
        return null;
    }
}
