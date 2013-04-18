/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se362project1;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.text.BadLocationException;

/**
 *
 * @author grantstacey
 */
public class Shortcuts implements KeyListener {

    Editor editor;
    private JTabbedPane pane;
    int[] keys = {KeyEvent.VK_N, KeyEvent.VK_O, KeyEvent.VK_S, KeyEvent.VK_A, 
        KeyEvent.VK_X, KeyEvent.VK_C, KeyEvent.VK_T,KeyEvent.VK_P, KeyEvent.VK_Q, 
        KeyEvent.VK_I, KeyEvent.VK_U, KeyEvent.VK_B, KeyEvent.VK_I, KeyEvent.VK_1, 
        KeyEvent.VK_2,KeyEvent.VK_3, KeyEvent.VK_4, KeyEvent.VK_5, KeyEvent.VK_6, 
        KeyEvent.VK_W, KeyEvent.VK_Q, KeyEvent.VK_D, KeyEvent.VK_T, KeyEvent.VK_P,
        KeyEvent.VK_U, KeyEvent.VK_V, KeyEvent.VK_L};
    
    int[] input = {InputEvent.CTRL_MASK, InputEvent.CTRL_MASK, InputEvent.CTRL_MASK, 
        InputEvent.CTRL_MASK, InputEvent.CTRL_MASK, InputEvent.CTRL_MASK,
        InputEvent.CTRL_MASK, InputEvent.CTRL_MASK, InputEvent.CTRL_MASK, 
        InputEvent.CTRL_MASK, InputEvent.CTRL_MASK, InputEvent.SHIFT_MASK,
        InputEvent.SHIFT_MASK, InputEvent.SHIFT_MASK, InputEvent.SHIFT_MASK, 
        InputEvent.SHIFT_MASK, InputEvent.SHIFT_MASK, InputEvent.SHIFT_MASK, 
        InputEvent.SHIFT_MASK, InputEvent.SHIFT_MASK, InputEvent.SHIFT_MASK,
        InputEvent.SHIFT_MASK, InputEvent.SHIFT_MASK, InputEvent.SHIFT_MASK, 
        InputEvent.SHIFT_MASK, InputEvent.CTRL_MASK, InputEvent.CTRL_MASK};

    public Shortcuts() {
    }

    public Shortcuts(Editor e, JTabbedPane pane) {
        editor = e;
        this.pane = pane;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        //System.out.println(key);
        if (e.isControlDown()) {
            //System.out.println(key);
            if (key == 83) {
                if (editor.check() == false) {
                    Object[] options = {"Yes, save.", "No, don't save."};
                    int n = JOptionPane.showOptionDialog(editor, "The file is in an improper format. Save anyway?",
                            "Unsuccessful Check", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null, options, options[0]);
                    if (n == 1) {
                        return;
                    }
                }
                if (!editor.getCurFileName().equals("")) {
                    editor.save();
                } else {
                    //prompt for input
                    SaveCommand com = new SaveCommand();
                    com.execute();
                    editor.saveAs(com.getFile());
                }
            } else if (key == 78) {
                editor.addTab();
            } else if (key == 87) {
                editor.closeCur();
            } else if (key == 81) {
                if (editor.check() == true) {
                    JOptionPane.showMessageDialog(editor, "Check successful.");
                } else {
                    JOptionPane.showMessageDialog(editor, "Check unsuccessful.");
                }
            } else if (key == 79) {
                OpenCommand com = new OpenCommand();
                com.execute();
                editor.openTab(com.getFile());
            } else if (key == 76) {
                //editor.linksList();
            }

        } else if (key == 10) {

            JEditorPane text = (JEditorPane) pane.getSelectedComponent();
            try {
                text.getDocument().insertString(text.getSelectionStart(), "\n\t", null);
            } catch (BadLocationException ex) {
            }

            System.out.print(key);
        }



    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
