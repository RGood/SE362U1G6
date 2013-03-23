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
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JViewport;
import javax.swing.text.BadLocationException;

public class H4TagCommand extends JMenuItem implements Command {

    private JEditorPane pane;
    private JTabbedPane text;

    public H4TagCommand(JTabbedPane text) {
        this.text = text;
    }

    @Override
    public void execute() {
        JScrollPane scroll = (JScrollPane) text.getComponentAt(text.getSelectedIndex());
        JViewport view = (JViewport) scroll.getViewport();
        pane = (JEditorPane) view.getComponent(0);
        
        try {
            pane.getDocument().insertString(pane.getCaretPosition(), "<h4></h4>", null);
        } catch (BadLocationException ex) {
            System.out.print("NULL");
        }
    }

    @Override
    public void undo() {
    }
}
