/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se362project1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
                if(!editor.getCurFileName().equals("")){
                    editor.save();
                }else{
                    //prompt for input
                    editor.saveAs("placeHolder");
                }
            }else if(key == 78){
                editor.addTab();
            }else if(key == 87){
                if(editor.tabsOpen()>=1){
                    editor.dispose();
                }
                editor.closeCur();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
