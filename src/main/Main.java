package main;
import controller.ClickHandler;
import controller.IJPaintController;
import controller.JPaintController;
import model.*;
import model.interfaces.IShapeList;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.gui.ShapeDrawer;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;



public class Main {
    public static void main(String[] args){
        MasterShapeList  masterShapeList = new MasterShapeList();
        IShapeList selectedShapeList = new ShapeList();
        IShapeList clipBoardShapeList = new ClipBoardShapeList();
        ShapeListManager shapeListManager = new ShapeListManager(masterShapeList, selectedShapeList,
                clipBoardShapeList);
        PaintCanvas paintCanvas = new PaintCanvas(shapeListManager);



        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);

        ApplicationState appState = new ApplicationState(uiModule);




        ShapeDrawer shapeDrawer = new ShapeDrawer(paintCanvas);
        ClickHandler clickHandler = new ClickHandler(appState,shapeListManager);


        IJPaintController controller = new JPaintController(uiModule, appState,shapeListManager);

        //paintCanvas.addMouseListener(clickHandler);
        controller.setup();
        masterShapeList.registerObserver(shapeDrawer);

        //Graphics2D g = (Graphics2D) paintCanvas.getGraphics();
        paintCanvas.addMouseListener(clickHandler);

        //paintCanvas.addMouseMotionListener(clickHandler);
    }
}
