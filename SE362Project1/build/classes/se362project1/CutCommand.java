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
import javax.swing.JTabbedPane;


public class CutCommand extends JMenuItem implements Command {

    private JTabbedPane text;
    private JEditorPane pane;

    public CutCommand(JTabbedPane text) {
        this.text = text;
    }

    @Override
    public void execute() {
        pane = (JEditorPane)text.getSelectedComponent();
        StringSelection selection = new StringSelection(pane.getSelectedText());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
        pane.replaceSelection(" ");
    }

    @Override
    public void undo() {
    }
}
