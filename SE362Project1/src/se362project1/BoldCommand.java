/*Christopher Norman
 * 03/17/13
 * Bold Command
 *
 * Inserts a Bold tag in the buffer
 *
 */
package se362project1;


import javax.swing.JEditorPane;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.text.BadLocationException;

public class BoldCommand extends JMenuItem implements Command {

    private JTabbedPane text;
    private JEditorPane pane;
    private Editor e;

    public BoldCommand(JTabbedPane text, Editor e) {
        this.text = text;
        this.e = e;
    }

    @Override
    public void execute() {
        
        pane = (JEditorPane)text.getSelectedComponent();
        
        try {
            pane.getDocument().insertString(pane.getCaretPosition(), "<b></b>", null);
        } catch (BadLocationException ex) {
            System.out.print("NULL");
        }
    }

    @Override
    public void undo() {
    }
}
