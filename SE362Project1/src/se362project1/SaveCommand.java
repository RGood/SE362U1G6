/*Christopher Norman
 * 03/18/13
 *
 * This command is useded to save files
 *
 */

package se362project1;

import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;


public class SaveCommand extends JButton implements Command {

    private JFileChooser choose;
    private File file;


    public SaveCommand(){

        choose = new JFileChooser();
    }

    @Override
    public void execute() {
       choose.showSaveDialog(null);
    }

    @Override
    public void undo() {


    }

}
