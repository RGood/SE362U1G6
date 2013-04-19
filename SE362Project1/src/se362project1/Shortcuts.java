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
        KeyEvent.VK_U, KeyEvent.VK_H, KeyEvent.VK_L};
    
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
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}
