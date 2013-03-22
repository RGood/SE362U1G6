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
    private CurrentFileList filelist;
    private JTabbedPane pane;

    public CloseCommand(JTabbedPane pane){
        this.pane = pane;
       // this.list = list;
        //filelist = CurrentFileList.getSingletonObject();
    }

    public void execute() {
        Component selected = pane.getSelectedComponent();

        if(selected != null){
            pane.remove(selected);
        }
        //File file = filelist.getList().get(list.getSelectedIndex());
        //filelist.getList().remove(file);
    }

    public void undo() {

    }


}
