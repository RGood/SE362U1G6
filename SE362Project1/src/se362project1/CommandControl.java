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

    public CommandControl() {
        undoStack = new Stack<Command>();
    }

    public void setCommand(Command command) {
        this.command = command;
        undoStack.push(command);

    }

    public void pressButton() {
        command.execute();
    }
}
