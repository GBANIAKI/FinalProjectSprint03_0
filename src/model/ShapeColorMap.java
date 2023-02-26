package model;

import java.awt.*;
import java.util.EnumMap;

import static java.awt.Color.*;

public class ShapeColorMap {
    private static final  EnumMap<ShapeColor, Color>map = new EnumMap<>(ShapeColor.class);
    private static final ShapeColorMap instance = new ShapeColorMap();
    private ShapeColorMap(){
        map.put(ShapeColor.BLACK, BLACK);
        map.put(ShapeColor.BLUE, BLUE);
        map.put(ShapeColor.CYAN, CYAN);
        map.put(ShapeColor.GRAY, GRAY);
        map.put(ShapeColor.DARK_GRAY, DARK_GRAY);
        map.put(ShapeColor.GREEN, GREEN);
        map.put(ShapeColor.LIGHT_GRAY, LIGHT_GRAY);
        map.put(ShapeColor.MAGENTA, MAGENTA);
        map.put(ShapeColor.ORANGE, Color.ORANGE);
        map.put(ShapeColor.PINK, PINK);
        map.put(ShapeColor.RED, RED);
        map.put(ShapeColor.WHITE, WHITE);
        map.put(ShapeColor.YELLOW, YELLOW);

    }
    public static  Color getMappingForShapeColor(ShapeColor shapeColor){
        return instance.get(shapeColor);
    }
    private Color get(ShapeColor shapeColor){
        return map.get(shapeColor);
    }
}
