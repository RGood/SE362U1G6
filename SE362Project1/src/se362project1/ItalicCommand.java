/*Christopher Norman
 * 03/17/13
 * Italic Command
 * 
 * Inserts an italic tag in the buffer
 * 
 */
package se362project1;


import javax.swing.JEditorPane;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JViewport;
import javax.swing.text.BadLocationException;

public class ItalicCommand extends JMenuItem implements Command {

    private JEditorPane pane;
    private JTabbedPane text;

    public ItalicCommand(JTabbedPane text) {
        this.text = text;
    }

    @Override
    public void execute() {
        pane = (JEditorPane)text.getSelectedComponent();
        try {
            pane.getDocument().insertString(pane.getCaretPosition(), "<i></i>", null);
        } catch (BadLocationException ex) {
            System.out.print("NULL");
        }
    }

    @Override
    public void undo() {
    }
}
