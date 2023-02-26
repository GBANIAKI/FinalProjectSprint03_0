package model;

import model.interfaces.IShape;

public class CollisionDetector {
    public static boolean detectCollision(IShape shape, Point selectionStartPoint, Point selectionEndpoint){
        Point shapeStartPoint = shape.getStartPoint();
        Point shapeEndPoint =shape.getEndPoint();
        int shapeWidth = shapeEndPoint.getX()- shapeStartPoint.getX();
        int shapeHeight = shapeEndPoint.getY() - shapeStartPoint.getY();
        int selectionStartPointX= selectionStartPoint.getX();
        int selectionEndPointX = selectionEndpoint.getX();
        int selectionStartPointY= selectionStartPoint.getY();
        int selectionEndPointY = selectionEndpoint.getY();
        int selectionWidth = selectionEndPointX - selectionStartPointX;
        int selectionHeight = selectionEndPointY - selectionStartPointY;
        boolean collision = (selectionStartPointX <= shapeStartPoint.getX() + shapeWidth) &&
                (selectionStartPointX + selectionWidth >= shapeStartPoint.getX()) &&
                (selectionStartPointY <= shapeStartPoint.getY() + shapeHeight) &&
                (selectionHeight + selectionStartPointY >= shapeStartPoint.getY());
        if (collision) return true;
        else return false;

    }

}
