/*Christopher Norman
 * 03/17/13
 * Copy Command
 *
 * Copys the selected text
 *
 */
package se362project1;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import javax.swing.JEditorPane;
import javax.swing.JMenuItem;


public class CopyCommand extends JMenuItem implements Command {

    private JEditorPane text;

    public CopyCommand(JEditorPane text) {
        this.text = text;
    }

    @Override
    public void execute() {
        StringSelection selection = new StringSelection(text.getSelectedText());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
    }

    @Override
    public void undo() {
    }
}
