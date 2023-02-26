package model;

import model.interfaces.IShape;


public class ShapeFactory {




    private ShapeFactory(){}
        public  static IShape createShape(Point startPoint, Point endPoint, ShapeConfiguration shapeConfiguration){
            return new Shape(startPoint, endPoint, shapeConfiguration);

        }
    }

