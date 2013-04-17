/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se362project1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

/**
 *
 * @author grantstacey
 */
public class Shortcuts implements KeyListener {
    Editor editor;
    public Shortcuts(Editor e){
        editor = e;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        //System.out.println(key);
        if(e.isControlDown()){
            //System.out.println(key);
            if(key == 83){
                if(editor.check() == false){
                    Object[] options = {"Yes, save.", "No, don't save."};
                    int n = JOptionPane.showOptionDialog(editor, "The file is in an improper format. Save anyway?", 
                            "Unsuccessful Check", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
                            null, options, options[0]);
                    if(n == 1){
                        return;
                    }
                }
                if(!editor.getCurFileName().equals("")){
                    editor.save();
                }else{
                    //prompt for input
                    SaveCommand com = new SaveCommand();
                    com.execute();
                    editor.saveAs(com.getFile());
                }
            }else if(key == 78){
                editor.addTab();
            }else if(key == 87){
                editor.closeCur();
            }else if(key == 81){
                if(editor.check() == true){
                    JOptionPane.showMessageDialog(editor, "Check successful.");
                }else{
                    JOptionPane.showMessageDialog(editor, "Check unsuccessful.");
                }
            }else if(key == 79){
                OpenCommand com = new OpenCommand();
                com.execute();
                editor.openTab(com.getFile());
            }else if(key == 76){
                //editor.linksList();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
