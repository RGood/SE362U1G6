/*Christopher Norman
 * 03/17/13
 * H5 Command
 * 
 * Inserts an H5 tag in the buffer
 * 
 */
package se362project1;


import javax.swing.JEditorPane;
import javax.swing.JMenuItem;
import javax.swing.text.BadLocationException;

public class H5TagCommand extends JMenuItem implements Command {

    private JEditorPane text;

    public H5TagCommand(JEditorPane text) {
        this.text = text;
    }

    @Override
    public void execute() {
        try {
            text.getDocument().insertString(text.getCaretPosition(), "<h5></h5>", null);
        } catch (BadLocationException ex) {
            System.out.print("NULL");
        }
    }

    @Override
    public void undo() {
    }
}
