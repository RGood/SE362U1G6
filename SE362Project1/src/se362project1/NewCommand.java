/*Christopher Norman
 * 03/17/13
 * New Command
 *
 * Creates a new tab for an empty file
 *
 */

package se362project1;


import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;


public class NewCommand extends JMenuItem implements Command{

    private JTabbedPane pane;
    private Editor e;

    public NewCommand(Editor e){
        this.e = e;
    }

    @Override
    public void execute() {
        e.addTab();
    }

    @Override
    public void undo() {

    }

}
