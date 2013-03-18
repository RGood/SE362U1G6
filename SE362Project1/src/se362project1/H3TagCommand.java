/*Christopher Norman
 * 03/17/13
 * Command Controller
 * 
 * Inserts an H3 tag in the buffer
 * 
 */
package se362project1;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class H3TagCommand extends JButton implements Command {

    private JTextArea text;

    public H3TagCommand(JTextArea text) {
        this.text = text;
    }

    @Override
    public void execute() {
        text.insert("<h3></h3>", text.getCaretPosition());
    }

    @Override
    public void undo() {
    }
}
