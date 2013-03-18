/*Christopher Norman
 * 03/17/13
 * Command Controller
 * 
 * Inserts an H6 tag in the buffer
 * 
 */
package se362project1;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class H6TagCommand extends JButton implements Command {

    private JTextArea text;

    public H6TagCommand(JTextArea text) {
        this.text = text;
    }

    @Override
    public void execute() {
        text.insert("<h6></h6>", text.getCaretPosition());
    }

    @Override
    public void undo() {
    }
}
