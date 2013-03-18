/*Christopher Norman
 * 03/17/13
 * Command Controller
 * 
 * Inserts an H5 tag in the buffer
 * 
 */
package se362project1;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class H5TagCommand extends JButton implements Command {

    private JTextArea text;

    public H5TagCommand(JTextArea text) {
        this.text = text;
    }

    @Override
    public void execute() {
        text.insert("<h5></h5>", text.getCaretPosition());
    }

    @Override
    public void undo() {
    }
}
