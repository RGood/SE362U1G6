/*Christopher Norman
 * 03/17/13
 * Ordered List Command
 * 
 * Inserts an Ordered List into the buffer, allowing
 * the user to specify the number of items they want
 * in the list
 */
package se362project1;

import javax.swing.JEditorPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JViewport;
import javax.swing.text.BadLocationException;

public class OrderedListCommand extends JMenuItem implements Command {

    private JEditorPane pane;
    private JTabbedPane text;

    public OrderedListCommand(JTabbedPane text) {
        this.text = text;
    }

    @Override
    public void execute() {
        
        JScrollPane scroll = (JScrollPane) text.getComponentAt(text.getSelectedIndex());
        JViewport view = (JViewport) scroll.getViewport();
        pane = (JEditorPane) view.getComponent(0);
        
        String str = JOptionPane.showInputDialog(null,
                "Enter the ammount of items for the list");
        int num = Integer.parseInt(str);

        try {
            pane.getDocument().insertString(pane.getCaretPosition(), "<ol>", null);

            for (int i = 0; i < num; i++) {
                pane.getDocument().insertString(pane.getCaretPosition(), "\n    <li></li>", null);
            }

            pane.getDocument().insertString(pane.getCaretPosition(), "</ol>", null);
        } catch (BadLocationException ex) {
            System.out.print("NULL");
        }
    }

    @Override
    public void undo() {
    }
}
