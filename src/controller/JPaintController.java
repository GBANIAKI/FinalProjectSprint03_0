package controller;
import commands.*;
import model.NullShapeListManager;
//import model.ShapeListManager;
//import commands.UngroupCommand;
//import commands.GoupShapeCommand;
import model.interfaces.IApplicationState;
import model.interfaces.IShapeListManager;
import model.persistence.NullApplicationState;
import view.EventName;
import view.gui.NullGui;
//import view.interfaces.IEventCallback;
import view.interfaces.IUiModule;
public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    private  IShapeListManager shapeListManager;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState, IShapeListManager shapeListManager) {
        if(uiModule==null)
            uiModule=new NullGui();
        this.uiModule = uiModule;
        if(applicationState==null)
            applicationState= new NullApplicationState();
        this.applicationState = applicationState;
        if(shapeListManager==null)
            shapeListManager=new NullShapeListManager();
        this.shapeListManager = shapeListManager;
    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, () -> applicationState.setActiveStartAndEndPointMode());
       uiModule.addEvent(EventName.UNDO,() -> new UndoCommand().run());
       uiModule.addEvent(EventName.REDO, () -> new RedoCommand().run());
        uiModule.addEvent(EventName.COPY, () -> new CopyCommand(this.shapeListManager).run());
       uiModule.addEvent(EventName.PASTE, () ->new PasteShapeCommand(this.shapeListManager).run());
        uiModule.addEvent(EventName.DELETE, () ->new DeleteShapeCommand(this.shapeListManager).run());
        uiModule.addEvent(EventName.GROUP, () ->new GoupShapeCommand(this.shapeListManager).run());
       // uiModule.addEvent(EventName.UNGROUP, () -> new UngroupCommand.run());
    }
}