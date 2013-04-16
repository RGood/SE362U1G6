/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se362project1;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author christophernorman
 */
public class SaveAsCommand extends JMenuItem implements Command {
    
    private Editor e;
    private JFileChooser choose;
    
    public SaveAsCommand(Editor e){
        this.e = e;
        choose = new JFileChooser();
    }

    @Override
    public void execute() {
        if(e.check() == false){
                Object[] options = {"Yes, save.", "No, don't save."};
                int n = JOptionPane.showOptionDialog(this, "The file is in an improper format. Save anyway?", 
                        "Unsuccessful Check", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
                        null, options, options[0]);
                if(n == 1){
                    return;
                }
            }
         choose.showSaveDialog(null);
         e.saveAs(choose.getSelectedFile().getPath() + ".html");
    }

}
