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
import javax.swing.JTabbedPane;

//Subclasses Jmenuitem and implements the command interface to be
//treated as a command
public class CopyCommand extends JMenuItem implements Command {

    
    private JEditorPane pane;
    private JTabbedPane text;
    private Editor e;
    
    //Constructor passes in the jtabbedpane and a editor
    public CopyCommand(JTabbedPane text, Editor e) {
        this.text = text;
        this.e = e;
    }

    //Overrides the execute function in the command interface
    //gets the jeditorpane then copies the slected text to 
    //systems clipboard
    @Override
    public void execute() {
        e.saveCurState();
        pane = (JEditorPane)text.getSelectedComponent();
        StringSelection selection = new StringSelection(pane.getSelectedText());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
    }

}
