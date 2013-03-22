/*Christopher Norman
 * 03/17/13
 * H6 Command
 * 
 * Inserts an H6 tag in the buffer
 * 
 */
package se362project1;


import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

public class H6TagCommand extends JMenuItem implements Command {

    private JTextArea text;

    public H6TagCommand(JTextArea text) {
        this.text = text;
    }

    @Override
    public void execute() {
        try {
            text.getDocument().insertString(text.getCaretPosition(), "<h6></h6>", null);
        } catch (BadLocationException ex) {
            System.out.print("NULL");
        }
    }

    @Override
    public void undo() {
    }
}
