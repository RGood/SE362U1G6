/*Christopher Norman
 * 03/18/13
 *
 * Opens a new file
 *
 */

package se362project1;


import java.io.File;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;


public class OpenCommand extends JMenuItem implements Command{

    private JFileChooser choose;
    private File file;
    private JEditorPane text;
    private JTabbedPane pane;
    private CurrentFileList list;

    public OpenCommand(JEditorPane text, JTabbedPane pane){
        this.text = text;
        choose = new JFileChooser();
        list = CurrentFileList.getSingletonObject();
    }

    @Override
    public void execute() {
       choose.showOpenDialog(null);
       file = choose.getSelectedFile();
       pane.addTab(file.getName(), text);
       int count = pane.getTabCount();
       pane.setSelectedIndex(count-1);

       //Read in text from the file to the tab
       list.addFile(file);
       System.out.print(list.getList());
    }

    @Override
    public void undo() {


    }





}
