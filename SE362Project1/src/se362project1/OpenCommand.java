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
  

    public OpenCommand(JTabbedPane pane){
        choose = new JFileChooser();
    }

    @Override
    public void execute() {
       text = new JEditorPane();
       choose.showOpenDialog(null);
       file = choose.getSelectedFile();
       pane.addTab(file.getName(), text);
       int count = pane.getTabCount();
       pane.setSelectedIndex(count-1);

       //Read in text from the file to the tab

    }

    @Override
    public void undo() {


    }





}
