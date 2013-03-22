/*Christopher Norman
 * 03/17/13
 * H3 Command
 * 
 * Inserts an H3 tag in the buffer
 * 
 */
package se362project1;


import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

public class H3TagCommand extends JMenuItem implements Command {

    private JTextArea text;

    public H3TagCommand(JTextArea text) {
        this.text = text;
    }

    @Override
    public void execute() {
        try {
            text.getDocument().insertString(text.getCaretPosition(), "<h3></h3>", null);
        } catch (BadLocationException ex) {
            System.out.print("NULL");
        }
    }

    @Override
    public void undo() {
    }
}
