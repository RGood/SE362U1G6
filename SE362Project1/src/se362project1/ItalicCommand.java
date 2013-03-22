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
import javax.swing.text.BadLocationException;

public class ItalicCommand extends JMenuItem implements Command {

    private JEditorPane text;

    public ItalicCommand(JEditorPane text) {
        this.text = text;
    }

    @Override
    public void execute() {
        try {
            text.getDocument().insertString(text.getCaretPosition(), "<i></i>", null);
        } catch (BadLocationException ex) {
            System.out.print("NULL");
        }
    }

    @Override
    public void undo() {
    }
}
