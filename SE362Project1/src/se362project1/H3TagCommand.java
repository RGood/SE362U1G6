/*Christopher Norman
 * 03/17/13
 * H3 Command
 * 
 * Inserts an H3 tag in the buffer
 * 
 */
package se362project1;

import javax.swing.JEditorPane;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.text.BadLocationException;

public class H3TagCommand extends JMenuItem implements Command {

    private JEditorPane pane;
    private JTabbedPane text;
    private Editor e;

    public H3TagCommand(JTabbedPane text, Editor e) {
        this.text = text;
        this.e = e;
    }

    @Override
    public void execute() {
        e.saveCurState();
        
        pane = (JEditorPane) text.getSelectedComponent();

        if (pane.getSelectedText() != null) {

            try {
                pane.getDocument().insertString(pane.getSelectionStart(), "<h3>", null);
                pane.getDocument().insertString(pane.getSelectionEnd(), "</h3>", null);
            } catch (BadLocationException ex) {
                System.out.print("NULL");
            }

        } else {

            try {
                pane.getDocument().insertString(pane.getCaretPosition(), "<h3></h3>", null);
            } catch (BadLocationException ex) {
                System.out.print("NULL");
            }

        }
    }

    @Override
    public void undo() {
    }
}
