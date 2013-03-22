/*Christopher Norman
 * 
 * 
 */

package se362project1;

import java.io.File;
import javax.swing.JButton;
import javax.swing.JList;

/**
 *
 * @author soldiercnorm
 */
public class CloseCommand extends JButton implements Command{

    private JList list;
    private CurrentFileList filelist;

    public CloseCommand(JList list){
        this.list = list;
        filelist = CurrentFileList.getSingletonObject();
    }

    public void execute() {
        File file = filelist.getList().get(list.getSelectedIndex());
        filelist.getList().remove(file);
    }

    public void undo() {

    }


}
