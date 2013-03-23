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
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JViewport;


public class CopyCommand extends JMenuItem implements Command {

    private JEditorPane pane;
    private JTabbedPane text;

    public CopyCommand(JTabbedPane text) {
        this.text = text;
    }

    @Override
    public void execute() {
        JScrollPane scroll = (JScrollPane) text.getComponentAt(text.getSelectedIndex());
        JViewport view = (JViewport) scroll.getViewport();
        pane = (JEditorPane) view.getComponent(0);
        StringSelection selection = new StringSelection(pane.getSelectedText());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
    }

    @Override
    public void undo() {
    }
}
