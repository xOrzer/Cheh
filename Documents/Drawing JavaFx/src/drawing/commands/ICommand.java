package drawing.commands;

import drawing.Arthur;

public interface ICommand {

    void execute() throws Arthur;
    void undo();
    ICommand clone();
}
