package view.gui;
import model.ShapeListManager;
//import model.interfaces.IShape;

import javax.swing.JComponent;
import java.awt.*;
//import java.util.ArrayList;

public class PaintCanvas extends JComponent{
    ShapeDrawer shapeDrawer;

   public final ShapeListManager shapeListManager;

    public PaintCanvas(ShapeListManager shapeListManager){
        this.shapeListManager = shapeListManager;
        this.shapeDrawer = new ShapeDrawer(this);
    }
    @Override
    public void paint(Graphics g) {
        Graphics2D graphics2d = (Graphics2D)g;
        super.paint(graphics2d);
        this.shapeDrawer.update(this.shapeListManager.getMasterShapeList().getShapeList());


    }


}
