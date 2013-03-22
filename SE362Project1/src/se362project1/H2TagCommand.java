/*Christopher Norman
 * 03/17/13
 * H2 Command
 * 
 * Inserts an H2 tag in the buffer
 * 
 */
package se362project1;

import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

public class H2TagCommand extends JMenuItem implements Command {

    private JTextArea text;

    public H2TagCommand(JTextArea text) {
        this.text = text;
    }

    @Override
    public void execute() {
        try {
            text.getDocument().insertString(text.getCaretPosition(), "<h2></h2>", null);
        } catch (BadLocationException ex) {
            System.out.print("NULL");
        }
    }

    @Override
    public void undo() {
    }
}
