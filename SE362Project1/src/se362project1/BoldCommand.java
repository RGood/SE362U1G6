/*Christopher Norman
 * 03/17/13
 * Bold Command
 *
 * Inserts a Bold tag in the buffer
 *
 */
package se362project1;

import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JViewport;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class BoldCommand extends JMenuItem implements Command {

    private JTabbedPane text;
    private JEditorPane pane;

    public BoldCommand(JTabbedPane text) {
        this.text = text;
    }

    @Override
    public void execute() {
        
        //JScrollPane scroll = (JScrollPane)text.getSelectedComponent();
        //JViewport view = (JViewport)scroll.getViewport();
        //pane = (JEditorPane)view.getComponent(0);
        
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
