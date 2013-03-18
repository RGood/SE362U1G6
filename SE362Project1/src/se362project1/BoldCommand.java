/*Christopher Norman
 * 03/17/13
 * Command Controller
 *
 * Inserts a Bold tag in the buffer
 *
 */
package se362project1;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class BoldCommand extends JButton implements Command {

    private JTextArea text;

    public BoldCommand(JTextArea text) {
        this.text = text;
    }

    @Override
    public void execute() {
        text.insert("<b></b>", text.getCaretPosition());
    }

    @Override
    public void undo() {
    }
}
