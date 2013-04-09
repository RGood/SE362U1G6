/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se362project1;

import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

/**
 *
 * @author christophernorman
 */
public class HREFcommand extends JMenuItem implements Command {
    
    private JTabbedPane text;
    private Editor e;
    
    
    public HREFcommand(JTabbedPane text, Editor e){
        this.text = text;
        this.e = e;
    }

    @Override
    public void execute() {
       
    }

    @Override
    public void undo() {
      
    }
    
    
}
