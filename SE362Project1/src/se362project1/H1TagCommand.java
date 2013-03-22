/*Christopher Norman
 * 03/17/13
 * H1 tag Command
 * 
 * Inserts an H1 tag in the buffer
 * 
 */
package se362project1;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class H1TagCommand extends JButton implements Command {

    private JTextArea text;

    public H1TagCommand(JTextArea text) {
        this.text = text;
    }

    @Override
    public void execute() {
        text.insert("<h1></h1>", text.getCaretPosition());
    }

    @Override
    public void undo() {
    }
}
