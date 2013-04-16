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
import javax.swing.JTabbedPane;
import javax.swing.text.BadLocationException;

public class OrderedListCommand extends JMenuItem implements Command {

    private JEditorPane pane;
    private JTabbedPane text;
    private Editor e;

    public OrderedListCommand(JTabbedPane text, Editor e) {
        this.text = text;
        this.e = e;
    }

    @Override
    public void execute() {
        e.saveCurState();
        
        pane = (JEditorPane)text.getSelectedComponent();
        
        String str = JOptionPane.showInputDialog(null,
                "Enter the ammount of items for the list");
        int num = Integer.parseInt(str);

        try {
            pane.getDocument().insertString(pane.getCaretPosition(), "\n<ol>", null);

            for (int i = 0; i < num; i++) {
                pane.getDocument().insertString(pane.getCaretPosition(), "\n    <li></li>", null);
            }

            pane.getDocument().insertString(pane.getCaretPosition(), "\n</ol>", null);
        } catch (BadLocationException ex) {
            System.out.print("NULL");
        }
    }

    @Override
    public void undo() {
    }
}
