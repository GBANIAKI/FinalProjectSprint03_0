package view.gui;

import model.interfaces.IDrawShapeStrategy;
import model.persistence.DashedOutLineEllipse;
import model.persistence.DashedOutLineRectangle;
import model.persistence.DashedOutLineTriangle;

public class DrawShapeStrategyFactory {
    private static boolean isSelectedShape=false;

    public static IDrawShapeStrategy createDrawRectangleStrategy(boolean isSelectedShape){

        return new DashedOutLineRectangle(new DrawRectangleStrategy(),isSelectedShape);

    }
    public static IDrawShapeStrategy createDrawEllipseStrategy(boolean isSelectedShape){

            return new DashedOutLineEllipse(new DrawEllipseStrategy(),isSelectedShape);

    }
    public static IDrawShapeStrategy createDrawTriangleStrategy(boolean isSelectedShape){


            return new DashedOutLineTriangle(new DrawTriangleStrategy(), isSelectedShape);

    }
    public static void setIsSelectedShape(boolean _isSelectedShape){
        isSelectedShape=_isSelectedShape;
    }

}
