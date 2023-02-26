package model;

import model.interfaces.IShapeConfiguration;

public class NullShapeConfiguration implements IShapeConfiguration {
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
    public ShapeShadingType getActiveShadingType() {
        return null;
    }

    @Override
    public MouseMode getActiveMouseMode() {
        return null;
    }

    @Override
    public ShapeConfiguration deepCopy() {
        return null;
    }
}
