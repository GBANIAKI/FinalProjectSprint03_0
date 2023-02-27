package commands;
import model.interfaces.IUndoable;

//import java.awt.*;
import java.util.*;
public class CommandHistory {
    private static final Stack<IUndoable> undoStack = new Stack<>();
    private static final Stack<IUndoable> redoStack = new Stack<>();

    public static void add(IUndoable cmd) {
        undoStack.push(cmd);
        redoStack.clear();
        System.out.println(" 1- "+ undoStack);
        System.out.println(" 1- "+ redoStack);
    }

    public static boolean undo() {
        boolean result = !undoStack.empty();
        if (result) {
            IUndoable c = undoStack.pop();
            redoStack.push(c);
            c.undo();
        }
        System.out.println(" 1- "+ undoStack);
        System.out.println(" 1- "+ redoStack);
        return result;
    }

    public static boolean redo() {
        boolean result = !redoStack.empty();
        if (result) {
            IUndoable c = redoStack.pop();
            undoStack.push(c);
            c.redo();
        }
        System.out.println(" 1- "+ undoStack);
        System.out.println(" 1- "+ redoStack);
        return result;
    }
}
