/*Christopher Norman
 * 03/17/13
 * Ordered List Command
 * 
 * Inserts an Ordered List into the buffer, allowing
 * the user to specify the number of items they want
 * in the list
 */
package se362project1;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class OrderedListCommand extends JButton implements Command {

    private JTextArea text;

    public OrderedListCommand(JTextArea text) {
        this.text = text;
    }

    @Override
    public void execute() {
        String str = JOptionPane.showInputDialog(null,
                "Enter the ammount of items for the list");
        int num = Integer.parseInt(str);

        text.insert("<ol>", text.getCaretPosition());

        for (int i = 0; i < num; i++) {
            text.insert("\n    <li></li>", text.getCaretPosition());
        }

        text.insert("\n</ol>", text.getCaretPosition());
    }

    @Override
    public void undo() {
    }
}
