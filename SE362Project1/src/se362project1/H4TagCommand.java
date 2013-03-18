/*Christopher Norman
 * 03/17/13
 * Command Controller
 * 
 * Inserts an H4 tag in the buffer
 * 
 */
package se362project1;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class H4TagCommand extends JButton implements Command {

    private JTextArea text;

    public H4TagCommand(JTextArea text) {
        this.text = text;
    }

    @Override
    public void execute() {
        text.insert("<h4></h4>", text.getCaretPosition());
    }

    @Override
    public void undo() {
    }
}
