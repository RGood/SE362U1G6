/*Christopher Norman
 * 03/17/13
 * H2 Command
 * 
 * Inserts an H2 tag in the buffer
 * 
 */
package se362project1;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class H2TagCommand extends JButton implements Command {

    private JTextArea text;

    public H2TagCommand(JTextArea text) {
        this.text = text;
    }

    @Override
    public void execute() {
        text.insert("<h2></h2>", text.getCaretPosition());
    }

    @Override
    public void undo() {
    }
}
