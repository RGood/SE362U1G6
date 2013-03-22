/*Christopher Norman
 * 03/17/13
 * H1 tag Command
 * 
 * Inserts an H1 tag in the buffer
 * 
 */
package se362project1;

import javax.swing.JEditorPane;
import javax.swing.JMenuItem;
import javax.swing.text.BadLocationException;

public class H1TagCommand extends JMenuItem implements Command {

    private JEditorPane text;

    public H1TagCommand(JEditorPane text) {
        this.text = text;
    }

    @Override
    public void execute() {
         try {
            text.getDocument().insertString(text.getCaretPosition(), "<h1></h1>", null);
        } catch (BadLocationException ex) {
            System.out.print("NULL");
        }
    }

    @Override
    public void undo() {
    }
}
