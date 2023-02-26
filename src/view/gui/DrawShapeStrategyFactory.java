package view.gui;

import model.interfaces.IDrawShapeStrategy;
import model.persistence.DashedOutLineEllipse;
import model.persistence.DashedOutLineRectangle;
import model.persistence.DashedOutLineTriangle;

public class DrawShapeStrategyFactory {
    private static boolean isSelectedShape=false;
    //private static IDrawShapeStrategy drawShapeStrategy;
    public static IDrawShapeStrategy createDrawRectangleStrategy(){
        //if(isSelectedShape==true)
        //return new DrawRectangleStrategy();
        return new DashedOutLineRectangle(new DrawRectangleStrategy(),isSelectedShape);
       // else
          // return new DrawRectangleStrategy();
    }
    public static IDrawShapeStrategy createDrawEllipseStrategy(){
       // if(isSelectedShape==true)
            return new DashedOutLineEllipse(new DrawEllipseStrategy(),isSelectedShape);
       // else
          // return new DrawEllipseStrategy();
    }
    public static IDrawShapeStrategy createDrawTriangleStrategy(){

       // if(isSelectedShape==true)
            return new DashedOutLineTriangle(new DrawTriangleStrategy(), isSelectedShape);
       // else
            //return new DrawTriangleStrategy();
    }
    public static void setIsSelectedShape(boolean _isSelectedShape){
        isSelectedShape=_isSelectedShape;
    }
   /*public static boolean getIsSelectedShape(){
        return isSelectedShape;
   }*/

    //}
}
