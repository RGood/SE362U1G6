/*Christopher Norman
 * 03/17/13
 * Cut Command
 * 
 * Cuts the selected text 
 * 
 */
package se362project1;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import javax.swing.JEditorPane;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class CutCommand extends JMenuItem implements Command {

    private JEditorPane text;

    public CutCommand(JEditorPane text) {
        this.text = text;
    }

    @Override
    public void execute() {
        StringSelection selection = new StringSelection(text.getSelectedText());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
        text.replaceSelection(" ");
    }

    @Override
    public void undo() {
    }
}
