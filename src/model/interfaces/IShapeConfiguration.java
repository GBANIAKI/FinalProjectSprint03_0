package model.interfaces;

import model.*;

public interface IShapeConfiguration {
    ShapeType getActiveShapeType();
     ShapeColor getActivePrimaryColor();
     ShapeColor getActiveSecondaryColor();
     ShapeShadingType getActiveShadingType();

     MouseMode getActiveMouseMode();
     IShapeConfiguration deepCopy( );
}
