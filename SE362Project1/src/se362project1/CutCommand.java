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

//Subclasses jemnuitem and implements hte command interface
//so it can be treated as a command
public class CutCommand extends JMenuItem implements Command {

    private JTabbedPane text;
    private JEditorPane pane;
    private Editor e;

    //Passes in a editor and a jtabbedpane
    public CutCommand(JTabbedPane text, Editor e) {
        this.text = text;;
        this.e = e;
    }

    //Overides the execute function in the command interface. 
    //Copys the selection to the clip board and the makes that 
    //selection empty
    @Override
    public void execute() {
        e.saveCurState();
        pane = (JEditorPane)text.getSelectedComponent();
        StringSelection selection = new StringSelection(pane.getSelectedText());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
        pane.replaceSelection(" ");
    }

}
