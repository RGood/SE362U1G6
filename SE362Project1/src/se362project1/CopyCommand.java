/*Christopher Norman
 * 03/17/13
 * Command Controller
 *
 * Copys the selected text
 *
 */
package se362project1;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class CopyCommand extends JButton implements Command {

    private JTextArea text;

    public CopyCommand(JTextArea text) {
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
