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
    private Editor e;
  

    public OpenCommand(){
        choose = new JFileChooser();
    }
    
    public OpenCommand(Editor e){
        this.e = e;
        choose = new JFileChooser();
    }

    @Override
    public void execute() {
       text = new JEditorPane();
       choose.showOpenDialog(null);
       file = choose.getSelectedFile();
       e.openTab(file.getPath());
    }
    
    public String getFile(){
     return file.getPath();
    }

}
