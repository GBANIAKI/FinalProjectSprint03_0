package model.interfaces;

import model.*;

import java.util.List;

public interface IShapeConfiguration {
    ShapeType getActiveShapeType();
     ShapeColor getActivePrimaryColor();
     ShapeColor getActiveSecondaryColor();
     ShapeShadingType getActiveShadingType();

     MouseMode getActiveMouseMode();

     IShapeConfiguration deepCopy( );
}
