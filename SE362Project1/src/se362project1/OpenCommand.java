/*Christopher Norman
 * 03/18/13
 *
 * Opens a new file
 *
 */

package se362project1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import se362project1.Command;

public class OpenCommand extends JButton implements Command{

    private JFileChooser choose;
    private File file;
    private JTextArea text;
    private CurrentFileList list;

    public OpenCommand(JTextArea text){
        this.text = text;
        choose = new JFileChooser();
        list = CurrentFileList.getSingletonObject();
    }

    @Override
    public void execute() {
       choose.showOpenDialog(null);
       file = choose.getSelectedFile();
       list.addFile(file);
       System.out.print(list.getList());
    }

    @Override
    public void undo() {


    }





}
