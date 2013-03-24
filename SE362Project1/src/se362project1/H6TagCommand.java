/*Christopher Norman
 * 03/17/13
 * H6 Command
 * 
 * Inserts an H6 tag in the buffer
 * 
 */
package se362project1;


import javax.swing.JEditorPane;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.text.BadLocationException;

public class H6TagCommand extends JMenuItem implements Command {

    private JEditorPane pane;
    private JTabbedPane text;
    
    public H6TagCommand(JTabbedPane text) {
        this.text = text;
    }

    @Override
    public void execute() {
        
        pane = (JEditorPane)text.getSelectedComponent();
        
        try {
            pane.getDocument().insertString(pane.getCaretPosition(), "<h6></h6>", null);
        } catch (BadLocationException ex) {
            System.out.print("NULL");
        }
    }

    @Override
    public void undo() {
    }
}
