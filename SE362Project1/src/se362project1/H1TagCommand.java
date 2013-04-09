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
import javax.swing.JTabbedPane;
import javax.swing.text.BadLocationException;

public class H1TagCommand extends JMenuItem implements Command {

    private JEditorPane pane;
    private JTabbedPane text;
    private Editor e;

    public H1TagCommand(JTabbedPane text, Editor e) {
        this.text = text;
        this.e = e;
    }

    @Override
    public void execute() {
        pane = (JEditorPane)text.getSelectedComponent();
        
         try {
            pane.getDocument().insertString(pane.getCaretPosition(), "<h1></h1>", null);
        } catch (BadLocationException ex) {
            System.out.print("NULL");
        }
         
         
    }

    @Override
    public void undo() {
        e.undoCurState();
    }
}
