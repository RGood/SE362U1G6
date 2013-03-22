/*Christopher Norman
 * 03/17/13
 * H4 Command
 * 
 * Inserts an H4 tag in the buffer
 * 
 */
package se362project1;

import javax.swing.JEditorPane;
import javax.swing.JMenuItem;
import javax.swing.text.BadLocationException;

public class H4TagCommand extends JMenuItem implements Command {

    private JEditorPane text;

    public H4TagCommand(JEditorPane text) {
        this.text = text;
    }

    @Override
    public void execute() {
        try {
            text.getDocument().insertString(text.getCaretPosition(), "<h4></h4>", null);
        } catch (BadLocationException ex) {
            System.out.print("NULL");
        }
    }

    @Override
    public void undo() {
    }
}
