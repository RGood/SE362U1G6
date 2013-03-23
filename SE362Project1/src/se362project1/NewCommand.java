/*Christopher Norman
 * 03/17/13
 * New Command
 *
 * Creates a new tab for an empty file
 *
 */

package se362project1;

import javax.swing.JEditorPane;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;


public class NewCommand extends JMenuItem implements Command{

    private JTabbedPane pane;

    public NewCommand(JTabbedPane pane){
        this.pane = pane;
    }

    @Override
    public void execute() {
        JEditorPane text = new JEditorPane();
        pane.addTab("untilled", text);
        int count = pane.getTabCount();
        pane.setSelectedIndex(count-1);
    }

    @Override
    public void undo() {

    }

}
