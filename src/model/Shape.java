package model;

import model.interfaces.IDrawShapeStrategy;
import model.interfaces.IShape;
import model.interfaces.IShapeConfiguration;

import java.awt.*;

public  class Shape implements IShape {
    private Point startPoint;
    private Point endPoint ;
    private IShapeConfiguration shapeConfiguration;
    public Shape(Point startPoint,Point endPoint, IShapeConfiguration shapeConfiguration){
        this.startPoint=startPoint;
        this.endPoint= endPoint;
        if(shapeConfiguration==null)
            shapeConfiguration=new NullShapeConfiguration();
        this.shapeConfiguration= shapeConfiguration;
    }


    @Override
    public Point getStartPoint() {
        return this.startPoint;
    }

    public Point getEndPoint(){
        return this.endPoint;
    }
    public IShapeConfiguration getShapeConfiguration(){
        return this.shapeConfiguration;
    }

    @Override
    public void setStartPoint(Point newPoint) {
        this.startPoint=newPoint;
    }


    public void setEndPoint(Point endPoint){
        this.endPoint= endPoint;
    }
    public void setShapeConfiguration( IShapeConfiguration shapeConfiguration){
         this.shapeConfiguration=shapeConfiguration;
    }

    public void draw(Graphics2D graphics2D, IDrawShapeStrategy drawerShapeStrategy){
            switch(this.shapeConfiguration.getActiveShadingType()){
                case FILLED_IN:
                    drawerShapeStrategy.drawFilledIn(graphics2D,this);
                    break;
                case OUTLINE:
                    drawerShapeStrategy.drawOutLine(graphics2D,this);
                    break;
                case OUTLINE_AND_FILLED_IN:
                    drawerShapeStrategy.drawOutLine(graphics2D, this);
                    drawerShapeStrategy.drawFilledIn(graphics2D,this);
                    break;
                default:
                    throw new Error("unknown constant");

            }


    }

    @Override
    public IShape deepCopy() {
        return new Shape(new Point(this.startPoint.getX()+40, this.startPoint.getY()+40),
                new Point(this.endPoint.getX()+40, this.endPoint.getY()+40), this.shapeConfiguration);
    }

   
}
