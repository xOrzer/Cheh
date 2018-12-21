package drawing.commands;

import drawing.Arthur;

import java.util.Stack;

public class CommandHistory {

    private Stack<ICommand> pile;

    public CommandHistory(){
        pile = new Stack<>();
    }


    public void exec(ICommand command) {
        try {
            command.execute();
            pile.push(command.clone());
        }catch (Arthur e){
            System.out.println(e.getMessage());        }
    }

    public void undo(){
        pile.lastElement().undo();
        pile.pop();

    }


}
