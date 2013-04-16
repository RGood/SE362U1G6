/*Christopher Norman
 * 03/18/13
 *
 * This command is used to save files
 *
 */

package se362project1;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class SaveCommand extends JMenuItem implements Command {

    private JFileChooser choose;
    private File file;
    private Editor e;


    public SaveCommand(){

        choose = new JFileChooser();
    }
    
    public SaveCommand(Editor e){
        this.e = e;
        choose = new JFileChooser();
    }

    @Override
    public void execute() {
        choose.showSaveDialog(null);
        file = choose.getSelectedFile();
        if(e.check() == false){
                Object[] options = {"Yes, save.", "No, don't save."};
                int n = JOptionPane.showOptionDialog(this, "The file is in an improper format. Save anyway?", 
                        "Unsuccessful Check", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
                        null, options, options[0]);
                if(n == 1){
                    return;
                }
            }
            e.save();  
    }
    
    public String getFile(){
        return file.getPath() + ".html";
    }

    @Override
    public void undo() {


    }

}
