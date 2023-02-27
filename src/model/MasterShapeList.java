package model;

import model.interfaces.IDrawObserver;
//import model.interfaces.IDrawShapeStrategy;
import model.interfaces.IDrawSubject;
import model.interfaces.IShape;
import model.interfaces.IShapeList;

import java.util.ArrayList;

public class MasterShapeList implements IDrawSubject {
   // private final ArrayList<IShape> shapeList;
    private final IShapeList shapeList;

    private final ArrayList<IDrawObserver> observers;
    public MasterShapeList(){
        //this.shapeList=new ShapeList();
        this.shapeList=new ShapeList();
        this.observers=new ArrayList<>();
    }
    public void add(IShape shape){
        this.shapeList.add(shape);
        this.notifyObserver();
    }
    public void remove(IShape shape){
        this.shapeList.remove(shape);
        this.notifyObserver();
    }
    public void shapeModified(){
        this.notifyObserver();

    }
    public void registerObserver(IDrawObserver observerDrawer){
        this.observers.add(observerDrawer);
    }
    public void removeObserver(IDrawObserver observerDrawer){
        this.observers.remove(observerDrawer);
    }
    public void notifyObserver(){
        for(IDrawObserver observer: this.observers){
            observer.update();

        }
    }

    public ArrayList<IShape> getShapeList() {
        return this.shapeList.getShapeList();
    }
      /*public ShapeList getShapeList() {
        return this.shapeList;
    }*/

    @Override
    public ArrayList<IDrawObserver> getObservers(){return this.observers;}
}
