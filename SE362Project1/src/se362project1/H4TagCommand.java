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
import javax.swing.JTabbedPane;
import javax.swing.text.BadLocationException;

public class H4TagCommand extends JMenuItem implements Command {

    private JEditorPane pane;
    private JTabbedPane text;
    private Editor e;

    public H4TagCommand(JTabbedPane text, Editor e) {
        this.text = text;
        this.e = e;
    }

    @Override
    public void execute() {
        
        e.saveCurState();
        pane = (JEditorPane) text.getSelectedComponent();

        if (pane.getSelectedText() != null) {

            try {
                pane.getDocument().insertString(pane.getSelectionStart(), "<h4>", null);
                pane.getDocument().insertString(pane.getSelectionEnd(), "</h4>", null);
            } catch (BadLocationException ex) {
                System.out.print("NULL");
            }

        } else {

            try {
                pane.getDocument().insertString(pane.getCaretPosition(), "<h4></h4>", null);
            } catch (BadLocationException ex) {
                System.out.print("NULL");
            }
        }
    }
}
