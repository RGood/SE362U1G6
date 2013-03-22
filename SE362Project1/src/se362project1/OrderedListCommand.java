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
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

public class OrderedListCommand extends JMenuItem implements Command {

    private JEditorPane text;

    public OrderedListCommand(JEditorPane text) {
        this.text = text;
    }

    @Override
    public void execute() {
        String str = JOptionPane.showInputDialog(null,
                "Enter the ammount of items for the list");
        int num = Integer.parseInt(str);

        try {
            text.getDocument().insertString(text.getCaretPosition(), "<ol>", null);

            for (int i = 0; i < num; i++) {
                text.getDocument().insertString(text.getCaretPosition(), "\n    <li></li>", null);
            }

            text.getDocument().insertString(text.getCaretPosition(), "</ol>", null);
        } catch (BadLocationException ex) {
            System.out.print("NULL");
        }
    }

    @Override
    public void undo() {
    }
}
