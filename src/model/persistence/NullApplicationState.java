package model.persistence;

import model.*;
import model.interfaces.IApplicationState;

public class NullApplicationState implements IApplicationState {
    @Override
    public void setActiveShape() {

    }

    @Override
    public void setActivePrimaryColor() {

    }

    @Override
    public void setActiveSecondaryColor() {

    }

    @Override
    public void setActiveShadingType() {

    }

    @Override
    public void setActiveStartAndEndPointMode() {

    }

    @Override
    public ShapeType getActiveShapeType() {
        return null;
    }

    @Override
    public ShapeColor getActivePrimaryColor() {
        return null;
    }

    @Override
    public ShapeColor getActiveSecondaryColor() {
        return null;
    }

    @Override
    public ShapeShadingType getActiveShapeShadingType() {
        return null;
    }

    @Override
    public MouseMode getActiveMouseMode() {
        return null;
    }

    @Override
    public ShapeConfiguration getCurrentShapeConfiguration() {
        return null;
    }
}
