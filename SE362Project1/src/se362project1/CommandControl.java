/*Christopher Norman
 * 03/17/13
 * Command Controller
 *
 * Sets the command and then executes that command
 *
 */
package se362project1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JEditorPane;
import javax.swing.JTabbedPane;

public class CommandControl {

    
    private Command command;;
    private Editor e;
    private JTabbedPane pane;

    //Passes in an Editor and a JTabbedPane to save the state before
    //a command is executed
    public CommandControl(Editor e, JTabbedPane pane) {
        this.e = e;
        this.pane = pane;
    }
    
    //Sets the command to be executed
    public void setCommand(Command command) {
        this.command = command;
    }

    //Simulates the pressing of a button
    //Calls to the execute command in the inferface
    //then executes the concrete command
    public void pressButton() {
        command.execute();
    }

}
