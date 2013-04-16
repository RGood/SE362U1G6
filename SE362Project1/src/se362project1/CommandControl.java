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
import java.util.Stack;
import javax.swing.JEditorPane;
import javax.swing.JTabbedPane;

public class CommandControl implements ActionListener {

    private Command command;
    private Stack<Command> undoStack;
    private Editor e;
    private JTabbedPane pane;

    public CommandControl(Editor e, JTabbedPane pane) {
        undoStack = new Stack<Command>();
        this.e = e;
        this.pane = pane;
    }

    public void setCommand(Command command) {
        this.command = command;
        undoStack.push(command);
    }

    public void pressButton() {
        command.execute();
    }
    
    public void undoButton(){
        e.undoCurState();
        
    }
    
    @Override
    public void actionPerformed(ActionEvent avt) {
            JEditorPane text = (JEditorPane)pane.getSelectedComponent();
            ((HTMLBuffer)pane.getSelectedComponent().getKeyListeners()[1]).update(text.getText());
            Command command = (Command)avt.getSource();
            setCommand(command);
            pressButton();
    }
}
