/*Christopher Norman
 * 
 * 
 */

package se362project1;

import java.awt.Component;
import java.io.File;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

/**
 *
 * @author soldiercnorm
 */
public class CloseCommand extends JMenuItem implements Command{

    private JList list;
    private JTabbedPane pane;
    private Editor e;

    public CloseCommand(Editor e){
        this.e = e;
    }

    public void execute() {
        e.closeCur();
    }

    public void undo() {

    }


}
