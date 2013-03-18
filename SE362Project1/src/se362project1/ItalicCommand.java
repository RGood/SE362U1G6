/*Christopher Norman
 * 03/17/13
 * Italic Command
 * 
 * Inserts an italic tag in the buffer
 * 
 */
package se362project1;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class ItalicCommand extends JButton implements Command {

    private JTextArea text;

    public ItalicCommand(JTextArea text) {
        this.text = text;
    }

    @Override
    public void execute() {
        text.insert("<i></i>", text.getCaretPosition());
    }

    @Override
    public void undo() {
    }
}
