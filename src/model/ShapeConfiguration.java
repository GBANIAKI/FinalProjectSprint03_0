package model;
//import model.MouseMode;

import model.interfaces.IShapeConfiguration;

import java.util.List;

public class  ShapeConfiguration implements IShapeConfiguration {
    private final ShapeType activeShapeType;
    private final ShapeColor activePrimaryColor;
    private final ShapeColor activeSecondaryColor;
    private final ShapeShadingType activeShadingType;
    private final MouseMode activeStartAndEndPointMode;

    public ShapeConfiguration(
            ShapeType activeShapeType,
    ShapeColor activePrimaryColor,
     ShapeColor activeSecondaryColor,
    ShapeShadingType activeShadingType,
    MouseMode activeStartAndEndPointMode) {
        this.activeShapeType= activeShapeType;
        this.activePrimaryColor=activePrimaryColor;
        this.activeSecondaryColor= activeSecondaryColor;
        this.activeShadingType=activeShadingType;
        this.activeStartAndEndPointMode= activeStartAndEndPointMode;


    }
    public ShapeType getActiveShapeType(){
        return activeShapeType;
    }
    public ShapeColor getActivePrimaryColor(){
        return activePrimaryColor;
    }
    public ShapeColor getActiveSecondaryColor(){
        return activeSecondaryColor;
    }
    public  ShapeShadingType getActiveShadingType(){
        return activeShadingType;
    }

    public  MouseMode getActiveMouseMode(){
        return activeStartAndEndPointMode;
    }



    public ShapeConfiguration deepCopy( ){
        return new ShapeConfiguration(this.activeShapeType,
                this.activePrimaryColor,
                this.activeSecondaryColor,
                this.activeShadingType,this.activeStartAndEndPointMode);
    }





}
