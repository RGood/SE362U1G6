/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se362project1;

import javax.swing.JMenuItem;

/**
 *
 * @author christophernorman
 */
public class OutlineViewCommand extends JMenuItem implements Command {
    
    
    private Editor e;
    
    public OutlineViewCommand(Editor e){
        this.e = e;  
    }
    
    

    @Override
    public void execute() {
        e.openCurOutline();
    }
    
    
}
