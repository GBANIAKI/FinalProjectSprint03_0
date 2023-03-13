package model;

import model.interfaces.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class GroupedShapes implements IGroupedShapes {
    private Point startPoint;
    private Point endPoint ;
    private IShapeConfiguration shapeConfiguration;
    private ArrayList<IShape> childIShapes;


    //private ArrayList<IShapeList> selectedShapeLists;
    //private IShapeListManager shapeListManager;
    public GroupedShapes(ArrayList<IShape> childIShapes){
        this.startPoint=null;
        this.endPoint= null;
        this.shapeConfiguration=null;
        this.childIShapes = childIShapes;

    }




    @Override
    public Point getStartPoint() {


        return this.startPoint;
    }

    @Override
    public Point getEndPoint() {

        return this.endPoint;
    }
    @Override
    public IShapeConfiguration getShapeConfiguration() {
       // List<IShapeConfiguration>groupedConfiguration = new ArrayList<>();
       // Iterator i= this.childIShapes.iterator();
        //for(IShape shape: this.childIShapes){
       // while( i.hasNext()){
            //IShape  shape = (IShape) i;
           // groupedConfiguration.add(shape.getShapeConfiguration());
           // i = (Iterator) ((Iterator )shape).next();

        //}
       //this.shapeConfiguration=(IShapeConfiguration) groupedConfiguration;

        return this.shapeConfiguration;
    }

    @Override
    public void setStartPoint(Point newPoint) {
         this.startPoint=newPoint;
    }

    @Override
    public void setEndPoint(Point newPoint) {
        this.endPoint=newPoint;

    }
    public ArrayList<IShape> getChildIShapes(){
        return this.childIShapes;
    }

    @Override
    public void draw(Graphics2D graphics2D, IDrawShapeStrategy drawerShapeStrategy) {
        //drawerShapeStrategy.drawOutLine(graphics2D,this);
       // if(this.isSelectedShape==true) {
        drawerShapeStrategy=null;
            int width = this.getEndPoint().getX() - this.getStartPoint().getX();
            int height = this.getEndPoint().getY() - this.getStartPoint().getY();

            Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
            graphics2D.setStroke(stroke);
            graphics2D.setColor(Color.BLACK);

            graphics2D.drawRect(this.getStartPoint().getX() - 5, this.getStartPoint().getY() - 5, width + 10, height + 10);
        //}

    }

    @Override
    public IShape deepCopy() {
        // ArrayList<IShape> childIShapes=new ArrayList<>();

        return new GroupedShapes(new ArrayList<>());

    }

    @Override
    public void addIShape(IShape iShape) {
        childIShapes.add(iShape);

    }

    @Override
    public void removeIShape(IShape iShape) {
        childIShapes.remove(iShape);

    }
    public void clear(){
        this.childIShapes.clear();
    }
    public void coordinateCollision(){
        List<Integer>startPointsXList = new ArrayList<>();
        List<Integer>startPointsYList = new ArrayList<>();
        List<Integer> endPointsXList = new ArrayList<>();
        List<Integer>endPointsYList = new ArrayList<>();

        this.childIShapes.forEach(iShape ->{
            startPointsXList.add(iShape.getStartPoint().getX()) ;
            startPointsYList.add(iShape.getStartPoint().getY());
            endPointsXList.add(iShape.getEndPoint().getX());
            endPointsYList.add(iShape.getEndPoint().getY());
        }
        );
        int startPointX = Collections.min(startPointsXList);
        int startPointY = Collections.min(startPointsYList);
        int endPointX = Collections.max(endPointsXList);
        int endPointY = Collections.max(endPointsYList);
        this.startPoint = new Point(startPointX,startPointY);
        this.endPoint = new Point(endPointX,endPointY);

    }
}
