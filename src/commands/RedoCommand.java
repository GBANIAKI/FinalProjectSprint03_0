package commands;

import controller.ICommand;

public class RedoCommand implements ICommand {
    @Override
    public void run() {
        CommandHistory.redo();
    }
}
