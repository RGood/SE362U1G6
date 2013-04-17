/*Christopher Norman
 * 03/17/13
 * Command Controller
 *
 * Sets the command and then executes that command
 *
 */
package se362project1;

import java.util.Stack;

public class CommandControl {

    private Command command;
    private Stack<Command> undoStack;
    private Editor e;

    public CommandControl(Editor e) {
        undoStack = new Stack<Command>();
        this.e = e;
    }

    public void setCommand(Command command) {
        this.command = command;
        undoStack.push(command);
        e.saveCurState();

    }

    public void pressButton() {
        command.execute();
    }
    
    public void undoButton(){
        e.undoCurState();
    }
}
